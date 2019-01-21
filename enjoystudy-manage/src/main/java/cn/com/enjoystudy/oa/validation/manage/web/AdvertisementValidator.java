package cn.com.enjoystudy.oa.validation.manage.web;

import cn.com.enjoystudy.oa.bean.web.AdvertisementSO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AdvertisementValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AdvertisementSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdvertisementSO obj = (AdvertisementSO) target;


        if (StringUtils.isBlank(obj.getPlaceId())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "placeId", "placeId.required");
            errors.rejectValue("placeId", "placeId.required", "名称不能为空");
        }

        if (null == obj.getShowState()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "showState", "showState.required");
            errors.rejectValue("showState", "showState.required", "显示状态不能为空");
        }

        if (null == obj.getShowState()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "large", "large.required");
            errors.rejectValue("large", "large.required", "图片不能为空");
        }
    }
}
