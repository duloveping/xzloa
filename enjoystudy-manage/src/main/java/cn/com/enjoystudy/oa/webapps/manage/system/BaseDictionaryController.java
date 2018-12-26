package cn.com.enjoystudy.oa.webapps.manage.system;

import cn.com.enjoystudy.oa.bean.sys.BaseDictionary;
import cn.com.enjoystudy.oa.bean.sys.BaseDictionaryItem;
import cn.com.enjoystudy.oa.bean.sys.BaseDictionaryItemSO;
import cn.com.enjoystudy.oa.bean.sys.BaseDictionarySO;
import cn.com.enjoystudy.oa.service.sys.BaseDictionaryItemService;
import cn.com.enjoystudy.oa.service.sys.BaseDictionaryService;
import cn.com.enjoystudy.oa.util.JsUtils;
import cn.com.enjoystudy.oa.validation.manage.system.BaseDictionaryValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manage/system/base-dictionary")
public class BaseDictionaryController extends BaseController {
    @Autowired
    private BaseDictionaryService baseDictionaryService;
    @Autowired
    private BaseDictionaryItemService baseDictionaryItemService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("manage/system/base-dictionary/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(@ModelAttribute BaseDictionarySO so) {
            PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<BaseDictionary> pageInfo = new PageInfo<BaseDictionary>(baseDictionaryService.list(so));
        List<BaseDictionary> datas = pageInfo.getList();
        JSONArray array = new JSONArray();
        if (null != datas && datas.size() > 0) {
            for (BaseDictionary dictionary : datas) {
                array.add(beanToJson(dictionary));
            }
        }

        JSONObject json = resultSuccess();
        json.put("datas", array);
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
        BaseDictionary so = null;
        if  (StringUtils.isNotBlank(id)) {
            so = baseDictionaryService.getById(id);
        } else {
            so = new BaseDictionary();
            so.setShowState(false);
            so.setItemList(new ArrayList<BaseDictionaryItem>());
        }

        ModelAndView mv = new ModelAndView("manage/system/base-dictionary/edit");
        mv.getModel().put("so", so);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(
            @ModelAttribute BaseDictionarySO so,
            @RequestParam("itemCodes") String[] itemCodes,
            @RequestParam("itemNames") String[] itemNames,
            @RequestParam("itemStates") Boolean[] itemStates,
            @RequestParam("itemSorts") Integer[] itemSorts,
            BindingResult result) {
        so.setItemCodes(itemCodes);
        so.setItemNames(itemNames);
        so.setItemStates(itemStates);
        so.setItemSorts(itemSorts);

        BaseDictionaryValidator validator = new BaseDictionaryValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            BaseDictionary dictionary = null;
            if (StringUtils.isNotBlank(so.getId())) {
                dictionary = baseDictionaryService.getById(so.getId());
            } else {
                dictionary = new BaseDictionary();
            }
            dictionary.setCode(StringUtils.trim(so.getCode()));
            dictionary.setName(StringUtils.trim(so.getName()));
            dictionary.setCaption(StringUtils.trimToNull(so.getCaption()));
            dictionary.setShowState(so.getShowState());
            if (StringUtils.isNotBlank(so.getId())) {
                baseDictionaryService.update(dictionary);
                baseDictionaryItemService.deleteByDictionaryId(so.getId());
            } else {
                baseDictionaryService.insert(dictionary);
            }

            int i = 0;
            for (String code : itemCodes) {
                BaseDictionaryItem item = new BaseDictionaryItem();
                item.setDictionaryId(dictionary.getId());
                item.setItemValue(code);
                item.setItemText(itemNames[i]);
                item.setSerialNumber(itemSorts[i]);
                item.setShowState(itemStates[i]);
                baseDictionaryItemService.insert(item);
                i++;
            }

            return resultSuccess();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        baseDictionaryService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("check")
    public void check(
            @RequestParam("code") String code,
            @RequestParam(value = "id", required = false) String id,
            HttpServletResponse response) {
        String flag = "true";

        BaseDictionarySO so = new BaseDictionarySO();
        so.setCode(code);
        so.setExceptId(id);
        if (baseDictionaryService.count(so) > 0) {
            flag = "false";
        }
        JsUtils.writeText(response, flag);
    }

    private JSONObject beanToJson(BaseDictionary dictionary) {
        List<BaseDictionaryItem> items = null;
        if (null != dictionary.getItemList() && dictionary.getItemList().size() > 0) {
            items = dictionary.getItemList();
        } else {
            BaseDictionaryItemSO so = new BaseDictionaryItemSO();
            so.setDictionaryId(dictionary.getId());
            items = baseDictionaryItemService.list(so);
        }

        JSONArray array = new JSONArray();
        if (null != items && items.size() > 0) {
            for (BaseDictionaryItem item : items) {
                JSONObject data = new JSONObject();
                data.put("id", item.getId());
                data.put("showState", item.getShowState());
                data.put("itemValue", item.getItemValue());
                data.put("itemText", item.getItemText());
                data.put("serialNumber", item.getSerialNumber());
                array.add(data);
            }
        }

        JSONObject obj = new JSONObject();
        obj.put("id", dictionary.getId());
        obj.put("showState", dictionary.getShowState());
        obj.put("code", dictionary.getCode());
        obj.put("name", dictionary.getName());
        obj.put("caption", StringUtils.trimToEmpty(dictionary.getCaption()));
        obj.put("items", array);
        return obj;
    }
}
