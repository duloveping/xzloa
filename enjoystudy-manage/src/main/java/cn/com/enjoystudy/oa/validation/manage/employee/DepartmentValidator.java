package cn.com.enjoystudy.oa.validation.manage.employee;

import cn.com.enjoystudy.oa.bean.base.DepartmentSO;
import cn.com.enjoystudy.oa.service.base.DepartmentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

public class DepartmentValidator  implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return DepartmentSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DepartmentSO obj = (DepartmentSO) target;

        if (StringUtils.isBlank(obj.getName())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
            errors.rejectValue("name", "name.required", "名称不能为空");
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            DepartmentService service = context.getBean(DepartmentService.class);

            DepartmentSO so = new DepartmentSO();
            so.setName(obj.getName());
            so.setParentId(obj.getParentId());
            so.setExceptId(obj.getId());
            so.setLike(Boolean.FALSE);
            if (service.count(so) > 0) {
                errors.rejectValue("name", "name.required", "名称已被使用");
            }
        }

        if (StringUtils.isBlank(obj.getCode())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "code.required");
            errors.rejectValue("code", "name.required", "编号不能为空");
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            DepartmentService service = context.getBean(DepartmentService.class);

            DepartmentSO so = new DepartmentSO();
            so.setCode(obj.getCode());
            so.setExceptId(obj.getId());
            if (service.count(so) > 0) {
                errors.rejectValue("code", "code.required", "编号已被使用");
            }
        }
    }
}