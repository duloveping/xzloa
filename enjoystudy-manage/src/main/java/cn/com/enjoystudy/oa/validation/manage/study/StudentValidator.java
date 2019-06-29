package cn.com.enjoystudy.oa.validation.manage.study;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccountSO;
import cn.com.enjoystudy.oa.bean.base.StudentSO;
import cn.com.enjoystudy.oa.service.base.EmployeeAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

public class StudentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return StudentSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentSO obj = (StudentSO) target;

        if (StringUtils.isBlank(obj.getFullName())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "fullName.required");
            errors.rejectValue("fullName", "fullName.required", "学员姓名不能为空");
        }

        if (StringUtils.isBlank(obj.getCode())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "code.required");
            errors.rejectValue("code", "name.required", "学员账号不能为空");
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            EmployeeAccountService service = context.getBean(EmployeeAccountService.class);

            EmployeeAccountSO so = new EmployeeAccountSO();
            so.setCode(obj.getCode());
            so.setExceptId(obj.getId());
            if (service.count(so) > 0) {
                errors.rejectValue("code", "code.required", "学员账号已被使用");
            }
        }
    }
}