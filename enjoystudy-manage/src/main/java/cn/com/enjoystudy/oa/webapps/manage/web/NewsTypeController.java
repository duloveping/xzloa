package cn.com.enjoystudy.oa.webapps.manage.web;

import cn.com.enjoystudy.oa.bean.web.NewsType;
import cn.com.enjoystudy.oa.bean.web.NewsTypeSO;
import cn.com.enjoystudy.oa.service.web.NewsTypeService;
import cn.com.enjoystudy.oa.util.JsUtils;
import cn.com.enjoystudy.oa.validation.manage.web.NewsTypeValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manage/web/news-type")
public class NewsTypeController extends BaseController {
    @Autowired
    private NewsTypeService newsTypeService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("manage/web/news-type/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list( NewsTypeSO so) {
        so.setLike(false);
        List<NewsType> list = newsTypeService.list(so);

        JSONObject json = resultSuccess();
        json.put("datas", list);
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
        NewsType so = null;
        if  (StringUtils.isNotBlank(id)) {
            so = newsTypeService.getById(id);
        } else {
            so = new NewsType();
            so.setShowState(false);
        }

        ModelAndView mv = new ModelAndView("manage/web/news-type/edit");
        mv.getModel().put("so", so);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(NewsTypeSO so, BindingResult result) {

        NewsTypeValidator validator = new NewsTypeValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            NewsType entity = null;
            if (StringUtils.isNotBlank(so.getId())) {
                entity = newsTypeService.getById(so.getId());
            } else {
                entity = new NewsType();
            }
            entity.setCode(StringUtils.trim(so.getCode()));
            entity.setName(StringUtils.trim(so.getName()));
            entity.setShowState(so.getShowState());
            entity.setParentId(so.getParentId());
            if (StringUtils.isNotBlank(so.getId())) {
                newsTypeService.update(entity);
            } else {
                newsTypeService.insert(entity);
            }

            return resultSuccess();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        newsTypeService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("check")
    public void check(
            @RequestParam("code") String code,
            @RequestParam(value = "id", required = false) String id,
            HttpServletResponse response) {
        String flag = "true";

        NewsTypeSO so = new NewsTypeSO();
        so.setCode(code);
        so.setExceptId(id);
        if (newsTypeService.list(so).size() > 0) {
            flag = "false";
        }
        JsUtils.writeText(response, flag);
    }

    @RequestMapping("single")
    public ModelAndView single(@RequestParam(value = "id", required = false) String id){
        NewsTypeSO so = new NewsTypeSO();
        so.setParentId("0");

        List<NewsType> types = new ArrayList<NewsType>();
        types = newsTypeService.recursionFindMenu(so, types);

        JSONArray array = new JSONArray();
        if (null != types && types.size() > 0) {
            for (NewsType type : types) {
                JSONObject json = new JSONObject();
                json.put("id", type.getId());
                json.put("name", type.getName());
                if (StringUtils.isNotBlank(type.getParentId())) {
                    json.put("pId", type.getParentId());
                } else {
                    json.put("pId", "0");
                }
                if (id.equals(type.getId())) {
                    json.put("checked", true);
                }

                array.add(json);
            }
        }
        ModelAndView mv = new ModelAndView("manage/web/news-type/single");
        mv.getModel().put("types", array.toJSONString());
        return mv;
    }
}
