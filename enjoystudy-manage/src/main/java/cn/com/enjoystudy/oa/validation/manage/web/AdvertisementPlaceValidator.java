package cn.com.enjoystudy.oa.validation.manage.web;

import cn.com.enjoystudy.oa.bean.web.AdvertisementPlaceSO;
import cn.com.enjoystudy.oa.service.web.AdvertisementPlaceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

public class AdvertisementPlaceValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AdvertisementPlaceSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdvertisementPlaceSO obj = (AdvertisementPlaceSO) target;

        if (StringUtils.isBlank(obj.getCode())) {
            errors.rejectValue("code", "name.required", "编号不能为空");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "code.required");
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            AdvertisementPlaceService service = context.getBean(AdvertisementPlaceService.class);

            AdvertisementPlaceSO so = new AdvertisementPlaceSO();
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
