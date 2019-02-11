package cn.com.enjoystudy.oa.validation.manage.web;

import cn.com.enjoystudy.oa.bean.web.NewsSO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class NewsValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return NewsSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewsSO obj = (NewsSO) target;

        if (StringUtils.isBlank(obj.getTitle())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required");
            errors.rejectValue("title", "title.required", "名称不能为空");
        }

        if (StringUtils.isBlank(obj.getTitle())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "typeId", "typeId.required");
            errors.rejectValue("typeId", "typeId.required", "类别不能为空");
        }

        if (null == obj.getShowState()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "showState", "showState.required");
            errors.rejectValue("showState", "showState.required", "显示状态不能为空");
        }
    }
}
