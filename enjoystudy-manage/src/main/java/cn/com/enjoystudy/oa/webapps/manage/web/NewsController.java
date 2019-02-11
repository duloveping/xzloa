package cn.com.enjoystudy.oa.webapps.manage.web;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.web.News;
import cn.com.enjoystudy.oa.bean.web.NewsSO;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.web.NewsService;
import cn.com.enjoystudy.oa.service.web.NewsTypeService;
import cn.com.enjoystudy.oa.validation.manage.web.NewsValidator;
import cn.com.enjoystudy.oa.webapps.UploadController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/manage/web/news")
public class NewsController extends UploadController {
    @Autowired
    private NewsTypeService newsTypeService;
    @Autowired
    private NewsService newsService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("manage/web/news/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(NewsSO so) {
        so.setLike(false);
        PageInfo<News> pageInfo = newsService.findPage(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
        News so = null;
        if  (StringUtils.isNotBlank(id)) {
            so = newsService.getById(id);
        } else {
            Subject subject = SecurityUtils.getSubject();
            Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
            EmployeeAccount account = (EmployeeAccount) object;

            so = new News();
            so.setShowState(false);
            so.setAuthor(account.getFullName());
        }

        ModelAndView mv = new ModelAndView("manage/web/news/edit");
        mv.getModel().put("so", so);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(NewsSO so, BindingResult result) {

        NewsValidator validator = new NewsValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            News entity = null;
            if (StringUtils.isNotBlank(so.getId())) {
                entity = newsService.getById(so.getId());
            } else {
                Subject subject = SecurityUtils.getSubject();
                Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
                EmployeeAccount account = (EmployeeAccount) object;

                entity = new News();
                entity.setPublisherId(account.getId());
                entity.setPublisherName(account.getFullName());
                entity.setClickAmount(0);
                entity.setLoveAmount(0);
                entity.setRemarkAmount(0);
                entity.setStarAmount(0);
            }
            entity.setTitle(StringUtils.trim(so.getTitle()));
            entity.setTypeId(so.getTypeId());
            entity.setAuthor(StringUtils.trim(so.getAuthor()));
            entity.setShowState(so.getShowState());
            entity.setPublishTime(new Date());
            entity.setImage(StringUtils.trimToNull(so.getImage()));
            entity.setDescription(StringUtils.trimToNull(so.getDescription()));
            entity.setIntroduction(StringUtils.trimToNull(so.getIntroduction()));
            if (StringUtils.isNotBlank(so.getId())) {
                newsService.update(entity);
            } else {
                newsService.insert(entity);
            }

            return resultSuccess();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        newsService.deleteById(id);
        return resultSuccess();
    }
}
