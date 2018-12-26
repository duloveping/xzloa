package cn.com.enjoystudy.oa.validation.manage.study;

import cn.com.enjoystudy.oa.bean.study.CourseExaminationSO;
import cn.com.enjoystudy.oa.bean.study.StorePaperSO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StorePaperValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return StorePaperSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StorePaperSO obj = (StorePaperSO) target;

        if (StringUtils.isBlank(obj.getTitle())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required");
            errors.rejectValue("title", "title.required", "试卷标题不能为空");
        }

        if (StringUtils.isBlank(obj.getCourseId())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courseId", "courseId.required");
            errors.rejectValue("courseId", "title.courseId", "考试课程不能为空");
        }

        if (null == obj.getDuration()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "duration", "duration.required");
            errors.rejectValue("duration", "duration.required", "时长不能为空");
        }

        if (null == obj.getPassScore()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passScore", "passScore.required");
            errors.rejectValue("passScore", "passScore.required", "合格分数不能为空");
        }

        if (null == obj.getPassScore()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalScore", "totalScore.required");
            errors.rejectValue("totalScore", "totalScore.required", "总分数不能为空");
        }

        if (null == obj.getTestAmount()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "testAmount", "testAmount.required");
            errors.rejectValue("testAmount", "testAmount.required", "补考次数不能为空");
        }

        if (null == obj.getShowState()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "showState", "showState.required");
            errors.rejectValue("showState", "showState.required", "补考次数不能为空");
        }
    }
}