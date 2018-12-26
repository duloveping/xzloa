package cn.com.enjoystudy.oa.validation.manage.study;

import cn.com.enjoystudy.oa.bean.study.CourseTypeSO;
import cn.com.enjoystudy.oa.bean.study.TeacherSO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TeacherValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return TeacherSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TeacherSO obj = (TeacherSO) target;

        if (StringUtils.isBlank(obj.getFullName())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "fullName.required");
            errors.rejectValue("fullName", "fullName.required", "姓名不能为空");
        }
    }
}