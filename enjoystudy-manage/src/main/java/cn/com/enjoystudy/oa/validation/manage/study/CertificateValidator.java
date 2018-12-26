package cn.com.enjoystudy.oa.validation.manage.study;

import cn.com.enjoystudy.oa.bean.study.CertificateSO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CertificateValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CertificateSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CertificateSO obj = (CertificateSO) target;

        if (StringUtils.isBlank(obj.getName())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
            errors.rejectValue("name", "name.required", "名称不能为空");
        }

        if (null == obj.getCourseIds() || obj.getCourseIds().length == 0) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courseIds", "courseIds.required");
            errors.rejectValue("courseIds", "courseIds.required", "所属课程不能为空");
        }
    }
}