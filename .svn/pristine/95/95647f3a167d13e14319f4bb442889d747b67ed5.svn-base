package cn.com.enjoystudy.oa.validation.manage.study;

import cn.com.enjoystudy.oa.bean.study.CourseExerciseSO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CourseExerciseValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CourseExerciseSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourseExerciseSO obj = (CourseExerciseSO) target;

        if (StringUtils.isBlank(obj.getTitle())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required");
            errors.rejectValue("title", "title.required", "练习题问题不能为空");
        }

        if (null == obj.getCategory()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "category.required");
            errors.rejectValue("category", "category.required", "练习题类型不能为空");
        }

        if (null == obj.getScore()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "score.required");
            errors.rejectValue("score", "score.required", "练习题类型不能为空");
        }

        if (StringUtils.isBlank(obj.getCourseId())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courseId", "courseId.required");
            errors.rejectValue("courseId", "courseId.required", "所属课程ID不能为空");
        }

        if (null == obj.getItemList() || obj.getItemList().size() == 0) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemList", "itemList.required");
            errors.rejectValue("itemList", "itemList.required", "答题选项ID不能为空");
        }
    }
}