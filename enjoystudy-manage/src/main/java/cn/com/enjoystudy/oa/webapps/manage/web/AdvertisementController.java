package cn.com.enjoystudy.oa.webapps.manage.web;

import cn.com.enjoystudy.oa.bean.web.Advertisement;
import cn.com.enjoystudy.oa.bean.web.AdvertisementPlace;
import cn.com.enjoystudy.oa.bean.web.AdvertisementPlaceSO;
import cn.com.enjoystudy.oa.bean.web.AdvertisementSO;
import cn.com.enjoystudy.oa.service.web.AdvertisementPlaceService;
import cn.com.enjoystudy.oa.service.web.AdvertisementService;
import cn.com.enjoystudy.oa.util.JsUtils;
import cn.com.enjoystudy.oa.validation.manage.web.AdvertisementPlaceValidator;
import cn.com.enjoystudy.oa.validation.manage.web.AdvertisementValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
import cn.com.enjoystudy.oa.webapps.UploadController;
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
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manage/web/advertisement")
public class AdvertisementController extends UploadController {
    @Autowired
    private AdvertisementPlaceService advertisementPlaceService;
    @Autowired
    private AdvertisementService advertisementService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        List<AdvertisementPlace> listPlace = advertisementPlaceService.list(new AdvertisementPlaceSO());

        ModelAndView mv = new ModelAndView("manage/web/advertisement/index");
        mv.getModel().put("listPlace", listPlace);
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list( AdvertisementSO so) {
        so.setLike(false);
        PageInfo<Advertisement> pageInfo = advertisementService.findPag(so);

        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
        List<AdvertisementPlace> listPlace = advertisementPlaceService.list(new AdvertisementPlaceSO());

        Advertisement so = null;
        if  (StringUtils.isNotBlank(id)) {
            so = advertisementService.getById(id);
        } else {
            so = new Advertisement();
            so.setShowState(false);
            so.setSerialNumber(0);
        }

        ModelAndView mv = new ModelAndView("manage/web/advertisement/edit");
        mv.getModel().put("listPlace", listPlace);
        mv.getModel().put("so", so);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(AdvertisementSO so, BindingResult result) {

        AdvertisementValidator validator = new AdvertisementValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            Advertisement entity = null;
            if (StringUtils.isNotBlank(so.getId())) {
                entity = advertisementService.getById(so.getId());
            } else {
                entity = new Advertisement();
            }
            entity.setLarge(so.getLarge());
            entity.setMiddle(so.getMiddle());
            entity.setSmall(so.getSmall());
            entity.setIcon(so.getIcon());
            entity.setUploadTime(new Date());
            entity.setTitle(StringUtils.trimToNull(so.getTitle()));
            entity.setCategory(StringUtils.trimToNull(so.getCategory()));
            entity.setPlaceId(StringUtils.trimToNull(so.getPlaceId()));
            entity.setCssClass(StringUtils.trimToNull(so.getCssClass()));
            entity.setCssStyle(StringUtils.trimToNull(so.getCssStyle()));
            entity.setShowState(so.getShowState());
            entity.setSerialNumber(so.getSerialNumber());
            if (StringUtils.isNotBlank(so.getId())) {
                advertisementService.update(entity);
            } else {
                advertisementService.insert(entity);
            }

            return resultSuccess();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        advertisementService.deleteById(id);
        return resultSuccess();
    }

}
