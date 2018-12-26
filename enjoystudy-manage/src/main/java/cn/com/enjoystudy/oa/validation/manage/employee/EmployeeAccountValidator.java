package cn.com.enjoystudy.oa.validation.manage.employee;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccountSO;
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

public class EmployeeAccountValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeAccountSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeAccountSO obj = (EmployeeAccountSO) target;

        if (StringUtils.isBlank(obj.getFullName())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "fullName.required");
            errors.rejectValue("fullName", "fullName.required", "员工姓名不能为空");
        }

        if (StringUtils.isBlank(obj.getCode())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "code.required");
            errors.rejectValue("code", "name.required", "员工编号不能为空");
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            EmployeeAccountService service = context.getBean(EmployeeAccountService.class);

            EmployeeAccountSO so = new EmployeeAccountSO();
            so.setCode(obj.getCode());
            so.setExceptId(obj.getId());
            if (service.count(so) > 0) {
                errors.rejectValue("code", "code.required", "员工编号已被使用");
            }
        }
    }
}