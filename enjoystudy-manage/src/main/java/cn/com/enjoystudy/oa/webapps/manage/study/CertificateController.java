package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.study.*;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.service.study.CertificateService;
import cn.com.enjoystudy.oa.service.study.CourseCertificateService;
import cn.com.enjoystudy.oa.service.study.CourseService;
import cn.com.enjoystudy.oa.service.study.EmployeeCertificateService;
import cn.com.enjoystudy.oa.validation.manage.study.CertificateValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manage/study/certificate")
public class CertificateController extends BaseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CertificateService certificateService;
    @Autowired
    private CourseCertificateService courseCertificateService;
    @Autowired
    private EmployeeCertificateService employeeCertificateService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("manage/study/certificate/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(CertificateSO so) {
        PageInfo<Certificate> pageInfo = certificateService.findPag(so);
        List<Certificate> datas = pageInfo.getList();
        JSONObject json = resultSuccess();
        json.put("datas", datas);
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
        List<Course> courseList = courseService.list(new CourseSO());

        Certificate certificate = null;
        if (StringUtils.isNotBlank(id)) {
            certificate = certificateService.getById(id);

            CourseCertificateSO certificateSO = new CourseCertificateSO();
            certificateSO.setCertificateId(certificate.getId());
            List<CourseCertificate> certificates = courseCertificateService.list(certificateSO);
            if (null != certificate && certificates.size() > 0) {
                String[] strs = new String[certificates.size()];

                int index = 0;
                for (CourseCertificate cc : certificates) {
                    strs[index] = cc.getCourseId();
                    index++;
                }
                certificate.setCourseIds(strs);
            }
        } else {
            certificate = new Certificate();
        }

        ModelAndView mv = new ModelAndView("manage/study/certificate/edit");
        mv.getModel().put("so", certificate);
        mv.getModel().put("courseList", courseList);
        return mv;
    }

    @RequestMapping("preview")
    public ModelAndView preview(@RequestParam String id) {
        ModelAndView mv = new ModelAndView("manage/study/certificate/preview");
        EmployeeCertificate certificate = employeeCertificateService.getById(id);
        mv.getModel().put("certificate", certificate);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(CertificateSO so, BindingResult result) {
        CertificateValidator validator = new CertificateValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            Certificate certificate = null;
            if (StringUtils.isNotBlank(so.getId())) {
                certificate = certificateService.getById(so.getId());
            } else {
                certificate = new Certificate();
            }
            certificate.setName(StringUtils.trim(so.getName()));
            if (StringUtils.isNotBlank(so.getId())) {
                certificateService.update(certificate);
                courseCertificateService.deleteByCertificateId(certificate.getId());
            } else {
                certificateService.insert(certificate);
            }
            if (null != so.getCourseIds() && so.getCourseIds().length > 0) {
                for (String courseId : so.getCourseIds()) {
                    CourseCertificate cc = new CourseCertificate();
                    cc.setCertificateId(certificate.getId());
                    cc.setCourseId(courseId);
                    courseCertificateService.insert(cc);
                }
            }
            return resultSuccess();
        }
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        certificateService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("listCertificate")
    public ModelAndView listCertificate(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("manage/study/certificate/listCentificate");
        return mv;
    }

    @RequestMapping("print")
    @ResponseBody
    public void  print(@RequestParam(value = "id", required = false) String id,HttpServletRequest request, HttpServletResponse response) {

        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
        EmployeeAccount account = (EmployeeAccount) object;

       String fileDir = request.getServletContext().getRealPath("/");

        try {
            //获取模板文件的目录地址
           // String fileDir = new File(base);
            //获取模板文件
            File demoFile=new File(fileDir + "/static/certificate/"+id+".doc");

            FileInputStream in = new FileInputStream(demoFile);
            HWPFDocument hdt = new HWPFDocument(in);
            //替换读取到的word模板内容的指定字段
            Range range = hdt.getRange();
            Map<String, String> map = new HashMap<String, String>();
            map.put("$studentName$", account.getFullName());


            for (Map.Entry<String,String> entry:map.entrySet()) {
                range.replaceText(entry.getKey(),entry.getValue());
            }

            //输出word内容文件流，提供下载
            response.setContentType("application/x-msdownload");
            String name = java.net.URLEncoder.encode("证书_"+id+"_"+account.getFullName()+".doc", "UTF8");
            name = new String((name).getBytes("UTF-8"), "ISO-8859-1");
            response.addHeader("Content-Disposition", "attachment; filename*=utf-8'zh_cn'"+name);
            ByteArrayOutputStream ostream = new ByteArrayOutputStream();
            ServletOutputStream servletOS = response.getOutputStream();
            hdt.write(ostream);
            servletOS.write(ostream.toByteArray());
            servletOS.flush();
            servletOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
