package cn.com.enjoystudy.oa.validation.manage.web;

import cn.com.enjoystudy.oa.bean.web.NewsTypeSO;
import cn.com.enjoystudy.oa.service.web.NewsTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

public class NewsTypeValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return NewsTypeSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewsTypeSO obj = (NewsTypeSO) target;

        if (StringUtils.isBlank(obj.getCode())) {
            errors.rejectValue("code", "name.required", "编号不能为空");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "code.required");
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            NewsTypeService service = context.getBean(NewsTypeService.class);

            NewsTypeSO so = new NewsTypeSO();
            so.setCode(obj.getCode());
            so.setExceptId(obj.getId());
            if (service.list(so).size() > 0) {
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
