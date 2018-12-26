package cn.com.enjoystudy.oa.validation.manage.system;

import cn.com.enjoystudy.oa.bean.base.BasePositionSO;
import cn.com.enjoystudy.oa.service.base.BasePositionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

public class BasePositionValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return BasePositionSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BasePositionSO obj = (BasePositionSO) target;

        if (StringUtils.isBlank(obj.getCode())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "code.required");
            errors.rejectValue("code", "name.required", "编号不能为空");
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            BasePositionService service = context.getBean(BasePositionService.class);

            BasePositionSO so = new BasePositionSO();
            so.setCode(obj.getCode());
            so.setExceptId(obj.getId());
            if (service.count(so) > 0) {
                errors.rejectValue("code", "code.required", "编号已经被使用");
            }
        }

        if (StringUtils.isBlank(obj.getName())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
            errors.rejectValue("name", "name.required", "名称不能为空");
        }

        if (null == obj.getShowState()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "showState", "showState.required");
            errors.rejectValue("showState", "showState.required", "显示状态不能为空");
        }
    }
}
