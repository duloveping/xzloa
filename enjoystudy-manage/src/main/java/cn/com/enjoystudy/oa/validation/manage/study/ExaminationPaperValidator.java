package cn.com.enjoystudy.oa.validation.manage.study;

import cn.com.enjoystudy.oa.bean.study.ExaminationPaperSO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ExaminationPaperValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ExaminationPaperSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ExaminationPaperSO obj = (ExaminationPaperSO) target;

        if (StringUtils.isBlank(obj.getTitle())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required");
            errors.rejectValue("title", "title.required", "考卷名称不能为空");
        }

        if (StringUtils.isBlank(obj.getCourseId())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courseId", "typeId.required");
            errors.rejectValue("courseId", "courseId.required", "课程ID不能为空");
        }

        if (null == obj.getTestType()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "testType", "testType.required");
            errors.rejectValue("testType", "testType.required", "考试类型不能为空");
        }

        if (null == obj.getTestState()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "testState", "testState.required");
            errors.rejectValue("testState", "testState.required", "考试状态为空");
        }

        if (null == obj.getDuration()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "duration", "duration.required");
            errors.rejectValue("duration", "duration.required", "考试时长状态为空");
        }
    }
}