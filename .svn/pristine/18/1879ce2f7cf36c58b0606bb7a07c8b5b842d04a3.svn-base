package cn.com.enjoystudy.oa.validation.manage.system;

import cn.com.enjoystudy.oa.bean.sys.SysMenuSO;
import cn.com.enjoystudy.oa.service.sys.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

public class SysMenuValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return SysMenuSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "showState", "showState.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "category.required");
        SysMenuSO obj = (SysMenuSO) target;

        if (StringUtils.isBlank(obj.getCode())) {
            errors.rejectValue("code", "name.required", "编号不能为空");
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            SysMenuService service = context.getBean(SysMenuService.class);

            SysMenuSO so = new SysMenuSO();
            so.setCode(obj.getCode());
            so.setExceptId(obj.getId());
            if (service.count(so) > 0) {
                errors.rejectValue("code", "code.required", "编号已经被使用");
            }
        }

        if (StringUtils.isBlank(obj.getName())) {
            errors.rejectValue("name", "name.required", "名称不能为空");
        }

        if (null == obj.getShowState()) {
            errors.rejectValue("showState", "showState.required", "显示状态不能为空");
        }

        if (null == obj.getCategory()) {
            errors.rejectValue("category", "category.required", "类型不能为空");
        } else {
            if (!obj.getCategory().equals(1) && !obj.getCategory().equals(2)) {
                errors.rejectValue("category", "category.required", "类型不正确");
            }
        }
    }

}
