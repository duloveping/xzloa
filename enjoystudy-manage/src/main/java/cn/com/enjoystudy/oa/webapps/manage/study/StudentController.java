package cn.com.enjoystudy.oa.webapps.manage.study;

import cn.com.enjoystudy.oa.bean.base.*;
import cn.com.enjoystudy.oa.bean.study.EmployeeAccountCourse;
import cn.com.enjoystudy.oa.bean.study.EmployeeAccountCourseSO;
import cn.com.enjoystudy.oa.bean.sys.SysRole;
import cn.com.enjoystudy.oa.bean.sys.SysRolePosition;
import cn.com.enjoystudy.oa.bean.sys.SysSequence;
import cn.com.enjoystudy.oa.common.Constants;
import cn.com.enjoystudy.oa.service.base.*;
import cn.com.enjoystudy.oa.service.study.EmployeeAccountCourseService;
import cn.com.enjoystudy.oa.service.study.StudentService;
import cn.com.enjoystudy.oa.service.sys.SysRolePositionService;
import cn.com.enjoystudy.oa.service.sys.SysRoleService;
import cn.com.enjoystudy.oa.service.sys.SysSequenceService;
import cn.com.enjoystudy.oa.util.JsUtils;
import cn.com.enjoystudy.oa.validation.manage.study.StudentValidator;
import cn.com.enjoystudy.oa.webapps.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manage/study/student")
public class StudentController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private EmployeeAccountService employeeAccountService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private EmployeeCommunicationService employeeCommunicationService;
    @Autowired
    private BasePositionService basePositionService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private EmployeePositionService employeePositionService;
    @Autowired
    private EmployeeRoleService employeeRoleService;
    @Autowired
    private SysRolePositionService sysRolePositionService;
    @Autowired
    private EmployeeAccountCourseService employeeAccountCourseService;
    @Autowired
    private SysSequenceService sysSequenceService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("manage/study/student/index");
        return mv;
    }

    @RequestMapping("list")
    @ResponseBody
    public JSONObject list(StudentSO so) {
        PageInfo<Student> pageInfo = studentService.findPage(so);
        List<Student> datas = pageInfo.getList();

        JSONObject json = resultSuccess();
        json.put("datas", datas);
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
}

    @RequestMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) String id) {
        Student student = null;
        if (StringUtils.isNotBlank(id)) {
            student = studentService.getById(StringUtils.trim(id));
            EmployeeCommunication communication = employeeCommunicationService.getCommunication(student.getId(), Constants.COMMUNICATION_CATEGORY_MYSELF);
            if (null == communication) {
                communication = new EmployeeCommunication();
                communication.setCategory(Constants.COMMUNICATION_CATEGORY_MYSELF);
            }
            student.setCommunication(communication);
        } else {
            student = new Student();
            student.setLockState(false);
            student.setCommunication(new EmployeeCommunication());
        }
        ModelAndView mv = new ModelAndView("manage/study/student/edit");
        mv.getModel().put("so", student);
        return mv;
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONObject save(StudentSO so, BindingResult result) {

        StudentValidator validator = new StudentValidator();
        validator.validate(so, result);

        if (result.hasErrors()) {
            return resultError(result.getFieldError().getDefaultMessage());
        } else {
            Student student = null;
            EmployeeCommunication communication = null;
            if (StringUtils.isNotBlank(so.getId())) {
                student = studentService.getById(so.getId());
                communication = employeeCommunicationService.getCommunication(student.getId(), Constants.COMMUNICATION_CATEGORY_MYSELF);
            } else {
                student = new Student();
                student.setCategory(Constants.ACCOUNT_CATEGORY_STUDENT);

                communication = new EmployeeCommunication();
                communication.setCategory(Constants.COMMUNICATION_CATEGORY_MYSELF);
            }
            student.setCode(StringUtils.trim(so.getCode()));
            student.setFullName(StringUtils.trim(so.getFullName()));
            student.setLockState(so.getLockState());
            if (StringUtils.isNotBlank(so.getLoginPassword())) {
                student.setLoginPassword(DigestUtils.sha1Hex(so.getLoginPassword().trim()));
            }

            if (null != so.getCommunication()) {
                communication.setPhone(StringUtils.trim(so.getCommunication().getPhone()));
                communication.setMobile(StringUtils.trim(so.getCommunication().getMobile()));
                communication.setEmail(StringUtils.trim(so.getCommunication().getEmail()));
                communication.setFax(StringUtils.trim(so.getCommunication().getFax()));
                communication.setProvinceId(StringUtils.trimToNull(so.getCommunication().getProvinceId()));
                communication.setCityId(StringUtils.trimToNull(so.getCommunication().getCityId()));
                communication.setTownId(StringUtils.trimToNull(so.getCommunication().getTownId()));
                communication.setAddress(StringUtils.trimToNull(so.getCommunication().getAddress()));
                communication.setPostCode(StringUtils.trimToNull(so.getCommunication().getPostCode()));
            }

            if (StringUtils.isNotBlank(so.getId())) {
                studentService.update(student);
                employeeCommunicationService.update(communication);
            } else {
                studentService.insert(student);

                communication.setEmployeeId(student.getId());
                employeeCommunicationService.insert(communication);

                boolean rpflag = false;
                BasePosition position = basePositionService.getByCode(Constants.POSITION_SYS_STUDENT);
                if (null == position) {
                    position = new BasePosition();
                    position.setCode(Constants.POSITION_SYS_STUDENT);
                    position.setName("学员");
                    position.setShowState(true);
                    position.setCaption("系统内置职务信息，请不要删除！");
                    basePositionService.insert(position);
                    rpflag = true;
                }

                EmployeePosition ep = new EmployeePosition();
                ep.setEmployeeId(student.getId());
                ep.setPositionId(position.getId());
                employeePositionService.insert(ep);

                SysRole role = sysRoleService.getByCode(Constants.POSITION_SYS_STUDENT);
                if (null == role) {
                    role = new SysRole();
                    role.setCode(Constants.POSITION_SYS_STUDENT);
                    role.setName("学员");
                    role.setCaption("系统内置角色信息，请不要删除！");
                    role.setShowState(true);
                    sysRoleService.insert(role);
                    rpflag = true;
                }

                if (rpflag) {
                    SysRolePosition rp = new SysRolePosition();
                    rp.setPositionId(position.getId());
                    rp.setRoleId(role.getId());
                    sysRolePositionService.insert(rp);
                }

                EmployeeRole er = new EmployeeRole();
                er.setEmployeeId(student.getId());
                er.setRoleId(role.getId());
                employeeRoleService.insert(er);
            }
            return resultSuccess();
        }
    }

    @RequestMapping("check")
    public void check(
            @RequestParam("code") String code,
            @RequestParam(value = "id", required = false) String id,
            HttpServletResponse response) {
        String flag = "true";

        EmployeeAccountSO so = new EmployeeAccountSO();
        so.setCode(code);
        so.setExceptId(id);
        if (employeeAccountService.count(so) > 0) {
            flag = "false";
        }
        JsUtils.writeText(response, flag);
    }

    @RequestMapping("delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String id) {
        studentService.deleteById(id);
        return resultSuccess();
    }

    @RequestMapping("saveCourse")
    @ResponseBody
    public JSONObject saveCourse(@RequestParam String[] employeeIds, @RequestParam String courseId) {
        EmployeeAccountCourseSO so = new EmployeeAccountCourseSO();
        so.setEmployeeIds(employeeIds);
        so.setCourseId(courseId);

        List<EmployeeAccountCourse> list = employeeAccountCourseService.list(so);
        for (String sid : employeeIds) {
            boolean flag = true;
            if (null != list && list.size() > 0) {
                for (EmployeeAccountCourse po : list) {
                    po.getEmployeeId().equalsIgnoreCase(sid);
                    flag = false;
                    break;
                }
            }

            if (flag) {
                EmployeeAccountCourse po = new EmployeeAccountCourse();
                po.setCourseId(courseId);
                po.setEmployeeId(sid);
                employeeAccountCourseService.insert(po);
            }
        }
        return resultSuccess();
    }

    @RequestMapping("courseList")
    public ModelAndView courseList(@RequestParam String employeeId) {
        EmployeeAccountCourseSO so = new EmployeeAccountCourseSO();
        so.setEmployeeId(employeeId);

        List<EmployeeAccountCourse> list = employeeAccountCourseService.list(so);

        ModelAndView mv = new ModelAndView("manage/study/student/courseList");
        mv.getModel().put("list", list);
        return mv;
    }

    @RequestMapping("batchEdit")
    public ModelAndView batchEdit() {
        ModelAndView mv = new ModelAndView("manage/study/student/batchEdit");
        return mv;
    }

    @RequestMapping("batchSave")
    @ResponseBody
    public JSONObject batchSave(StudentSO so) {
        String ym = DateFormatUtils.format(new Date(), "yyyyMM");
        String code = "XY" + ym;
        String name = "学员" +  ym;

        Integer seqval = 1;

        SysSequence sequence = sysSequenceService.getSequenceValue(code);
        if (null == sequence) {
            sequence = new SysSequence();
            sequence.setSeqValue(1);
            sequence.setSeqCode(code);
            sequence.setSeqName(name);
            sysSequenceService.insert(sequence);
        }
        seqval = sequence.getSeqValue();

        BasePosition position = basePositionService.getByCode(Constants.POSITION_SYS_STUDENT);
        SysRole role = sysRoleService.getByCode(Constants.POSITION_SYS_STUDENT);

        for (int i = 0; i < so.getAmount(); i++) {
            String seq = SysSequence.autoGenericCode((seqval + i) + "", 6);
            Student student = new Student();
            student.setCategory(Constants.ACCOUNT_CATEGORY_STUDENT);
            student.setCode(code + seq);
            student.setFullName(name + seq);
            student.setLockState(so.getLockState());
            student.setLoginPassword(DigestUtils.sha1Hex(so.getLoginPassword().trim()));
            studentService.insert(student);

            EmployeeCommunication communication = new EmployeeCommunication();
            communication.setEmployeeId(student.getId());
            communication.setCategory(Constants.COMMUNICATION_CATEGORY_MYSELF);
            employeeCommunicationService.insert(communication);

            EmployeePosition ep = new EmployeePosition();
            ep.setEmployeeId(student.getId());
            ep.setPositionId(position.getId());
            employeePositionService.insert(ep);

            EmployeeRole er = new EmployeeRole();
            er.setEmployeeId(student.getId());
            er.setRoleId(role.getId());
            employeeRoleService.insert(er);

            if (StringUtils.isNotBlank(so.getCourseId())) {
                EmployeeAccountCourse po = new EmployeeAccountCourse();
                po.setEmployeeId(student.getId());
                po.setCourseId(so.getCourseId());
                employeeAccountCourseService.insert(po);
            }
        }

        sequence.setSeqValue(sequence.getSeqValue() + so.getAmount());
        sysSequenceService.update(sequence);
        return resultSuccess();
    }

    @RequestMapping("export")
    public void export(@RequestParam String[] studentIds, HttpServletResponse response) {
        StudentSO so = new StudentSO();
        so.setIds(studentIds);
        List<Student> list = studentService.list(so);

        String sheetname = "学员信息";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetname);
        int rownum = 0;
        XSSFRow row0=sheet.createRow(rownum++);

        int colnum = 0;
        XSSFCell cell0 = row0.createCell(colnum++);
        cell0.setCellValue("账号");

        XSSFCell cell1 = row0.createCell(colnum++);
        cell1.setCellValue("姓名");

        XSSFCell cell2 = row0.createCell(colnum++);
        cell2.setCellValue("电话");

        XSSFCell cell3 = row0.createCell(colnum++);
        cell3.setCellValue("邮箱");

        if (null != list && list.size() > 0) {

            for (Student student : list) {
                colnum = 0;
                XSSFRow row1=sheet.createRow(rownum++);

                XSSFCell account = row1.createCell(colnum++);
                account.setCellValue(student.getCode());

                XSSFCell fullName = row1.createCell(colnum++);
                fullName.setCellValue(student.getFullName());

                XSSFCell phone = row1.createCell(colnum++);
                if (StringUtils.isNotBlank(student.getCommunication().getMobile())) {
                    phone.setCellValue(student.getCommunication().getMobile());
                } else {
                    phone.setCellValue(StringUtils.trimToEmpty(student.getCommunication().getPhone()));
                }

                XSSFCell email = row1.createCell(colnum++);
                email.setCellValue(StringUtils.trimToEmpty(student.getCommunication().getEmail()));
            }
        }


        OutputStream output = null;
        try {
            output = response.getOutputStream();

            String name = java.net.URLEncoder.encode(sheetname+".xlsx", "UTF8");

            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=" + name);
            response.setContentType("application/x-msdownload");
            workbook.write(output);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (null != output) {
                try {
                    output.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
    }
}
