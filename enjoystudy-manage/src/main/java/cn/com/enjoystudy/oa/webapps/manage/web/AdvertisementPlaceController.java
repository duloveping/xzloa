package cn.com.enjoystudy.oa.webapps.manage.web;

import cn.com.enjoystudy.oa.bean.web.AdvertisementPlace;
import cn.com.enjoystudy.oa.bean.web.AdvertisementPlaceSO;
import cn.com.enjoystudy.oa.service.web.AdvertisementPlaceService;
import cn.com.enjoystudy.oa.util.JsUtils;
import cn.com.enjoystudy.oa.validation.manage.web.AdvertisementPlaceValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
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

@Controller
@RequestMapping("/manage/web/advertisement-place")
public class AdvertisementPlaceController extends BaseController {
    @Autowired
    private AdvertisementPlaceService advertisementPlaceService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("manage/web/advertisement-place/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list( AdvertisementPlaceSO so) {
        so.setLike(false);
        PageInfo<AdvertisementPlace> pageInfo = advertisementPlaceService.findPag(so);

        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
        AdvertisementPlace so = null;
        if  (StringUtils.isNotBlank(id)) {
            so = advertisementPlaceService.getById(id);
        } else {
            so = new AdvertisementPlace();
            so.setShowState(false);
        }

        ModelAndView mv = new ModelAndView("manage/web/advertisement-place/edit");
        mv.getModel().put("so", so);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(AdvertisementPlaceSO so, BindingResult result) {

        AdvertisementPlaceValidator validator = new AdvertisementPlaceValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            AdvertisementPlace entity = null;
            if (StringUtils.isNotBlank(so.getId())) {
                entity = advertisementPlaceService.getById(so.getId());
            } else {
                entity = new AdvertisementPlace();
            }
            entity.setCode(StringUtils.trim(so.getCode()));
            entity.setName(StringUtils.trim(so.getName()));
            entity.setWidth(so.getWidth());
            entity.setHeight(so.getHeight());
            entity.setCssClass(StringUtils.trimToNull(so.getCssClass()));
            entity.setCssStyle(StringUtils.trimToNull(so.getCssStyle()));
            entity.setCategory(StringUtils.trimToNull(so.getCategory()));
            entity.setPlaceId(StringUtils.trimToNull(so.getPlaceId()));
            entity.setDescription(StringUtils.trimToNull(so.getDescription()));
            entity.setShowState(so.getShowState());
            if (StringUtils.isNotBlank(so.getId())) {
                advertisementPlaceService.update(entity);
            } else {
                advertisementPlaceService.insert(entity);
            }

            return resultSuccess();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        advertisementPlaceService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("check")
    public void check(
            @RequestParam("code") String code,
            @RequestParam(value = "id", required = false) String id,
            HttpServletResponse response) {
        String flag = "true";

        AdvertisementPlaceSO so = new AdvertisementPlaceSO();
        so.setCode(code);
        so.setExceptId(id);
        if (advertisementPlaceService.count(so) > 0) {
            flag = "false";
        }
        JsUtils.writeText(response, flag);
    }
}
