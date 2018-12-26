package cn.com.enjoystudy.oa.webapps.manage.system;

import cn.com.enjoystudy.oa.bean.sys.SysBaseConfig;
import cn.com.enjoystudy.oa.bean.sys.SysBaseConfigSO;
import cn.com.enjoystudy.oa.service.sys.SysBaseConfigService;
import cn.com.enjoystudy.oa.webapps.UploadController;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/manage/system/sys-base-config")
public class SysBaseConfigController extends UploadController {
    @Autowired
    private SysBaseConfigService sysBaseConfigService;

    @RequestMapping("edit")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        SysBaseConfig config = null;
        List<SysBaseConfig> list = sysBaseConfigService.list(new SysBaseConfigSO());
        if (null != list && list.size() > 0) {
            config = list.get(0);
        } else {
            config = new SysBaseConfig();
            config.setAllowUploadImage("gif,jpg,jpeg,png,bmp");
            config.setAllowUploadMedia("swf,flv,mp3,mp4,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
            config.setAllowUploadFlash("swf,flv");
            config.setAllowUploadFile("doc,docx,xls,xlsx,ppt,pptx,pdf,et,wps,dps,txt,xz,zip,bzip2,rar,tar,gz,gzip,bz2,7z");
        }

        ModelAndView mv = new ModelAndView("manage/system/sys-base-config/edit");
        mv.getModel().put("config", config);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(SysBaseConfigSO so) {
        SysBaseConfig config = null;
        if (StringUtils.isNotBlank(so.getId())) {
            config = sysBaseConfigService.getById(so.getId());
        } else {
            config = new SysBaseConfig();
        }
        config.setSystemName(StringUtils.trimToNull(so.getSystemName()));
        config.setCopyright(StringUtils.trimToNull(so.getCopyright()));
        config.setAllowUploadFile(StringUtils.trimToNull(so.getAllowUploadFile()));
        config.setAllowUploadFlash(StringUtils.trimToNull(so.getAllowUploadFlash()));
        config.setAllowUploadImage(StringUtils.trimToNull(so.getAllowUploadImage()));
        config.setAllowUploadMedia(StringUtils.trimToNull(so.getAllowUploadMedia()));
        config.setWebSite(StringUtils.trimToNull(so.getWebSite()));
        config.setKeywords(StringUtils.trimToNull(so.getKeywords()));
        config.setDescription(StringUtils.trimToNull(so.getDescription()));
        if (StringUtils.isNotBlank(so.getId())) {
            sysBaseConfigService.update(config);
        } else {
            sysBaseConfigService.insert(config);
        }
        JSONObject json = resultSuccess();
        json.put("id", config.getId());
        return json;
    }
}
