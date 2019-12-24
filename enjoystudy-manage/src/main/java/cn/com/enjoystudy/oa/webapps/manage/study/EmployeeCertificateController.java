package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.study.EmployeeCertificate;
import cn.com.enjoystudy.oa.bean.study.EmployeeCertificateSO;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.study.EmployeeCertificateService;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/manage/study/employee-certificate")
public class EmployeeCertificateController extends BaseController {
    @Autowired
    private EmployeeCertificateService employeeCertificateService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("manage/study/employee-certificate/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(EmployeeCertificateSO so) {
        EmployeeAccount account = getCurrentUser();
        so.setEmployeeId(account.getId());
        JSONObject json = adminList(so);
        return json;
    }

    @ResponseBody
    public void download(@RequestParam String id) {
        EmployeeCertificate certificate = employeeCertificateService.getById(id);

        XWPFDocument document = null;
        try {
            document = new XWPFDocument(POIXMLDocument.openPackage(certificate.getCourseCode()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("admin-index")
    public ModelAndView adminIndex() {
        ModelAndView mv = new ModelAndView("manage/study/employee-certificate/admin-index");
        return mv;
    }

    @RequestMapping("admin-list")
    @ResponseBody
    public JSONObject adminList(EmployeeCertificateSO so) {
        PageInfo<EmployeeCertificate> pageInfo = employeeCertificateService.findPag(so);
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("admin-edit")
    public ModelAndView adminEdit(@RequestParam String id) {
        EmployeeCertificate so = employeeCertificateService.getById(id);
        ModelAndView mv = new ModelAndView("manage/study/employee-certificate/admin-edit");
        mv.getModel().put("so", so);
        return mv;
    }

    @RequestMapping("admin-save")
    @ResponseBody
    public JSONObject adminSave(EmployeeCertificateSO so) {
        EmployeeCertificate po = employeeCertificateService.getById(so.getId());
        if (StringUtils.isNotBlank(so.getCertificateCode())) {
            po.setCertificateCode(StringUtils.trim(so.getCertificateCode()));
        }
        if (StringUtils.isNotBlank(so.getCertificateName())) {
            po.setCertificateName(StringUtils.trim(so.getCertificateName()));
        }
        if (StringUtils.isNotBlank(so.getEnglishName())) {
            po.setEnglishName(StringUtils.trim(so.getEnglishName()));
        }
        if (StringUtils.isNotBlank(so.getChineseContent())) {
            po.setChineseContent(StringUtils.trim(so.getChineseContent()));
        }
        if (StringUtils.isNotBlank(so.getEnglishContent())) {
            po.setEnglishContent(StringUtils.trim(so.getEnglishContent()));
        }
        if (StringUtils.isNotBlank(so.getEmployeeCode())) {
            po.setEmployeeCode(StringUtils.trim(so.getEmployeeCode()));
        }
        if (StringUtils.isNotBlank(so.getEmployeeName())) {
            po.setEmployeeName(StringUtils.trim(so.getEmployeeName()));
        }
        if (StringUtils.isNotBlank(so.getEmployeeId())) {
            po.setEmployeeId(StringUtils.trim(so.getEmployeeId()));
        }
        if (StringUtils.isNotBlank(so.getIdentityCode())) {
            po.setIdentityCode(StringUtils.trim(so.getIdentityCode()));
        }
        employeeCertificateService.update(po);
        JSONObject json = resultSuccess();
        return json;
    }
}
