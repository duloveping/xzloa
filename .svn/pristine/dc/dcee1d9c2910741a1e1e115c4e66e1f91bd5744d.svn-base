package cn.com.enjoystudy.oa.validation.manage.study;

import cn.com.enjoystudy.oa.bean.study.CourseVideoSO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CourseVideoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CourseVideoSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourseVideoSO obj = (CourseVideoSO) target;

        if (StringUtils.isBlank(obj.getName())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
            errors.rejectValue("name", "name.required", "名称不能为空");
        }

        if (StringUtils.isBlank(obj.getCourseId())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courseId", "courseId.required");
            errors.rejectValue("courseId", "courseId.required", "分类不能为空");
        }

        if (StringUtils.isBlank(obj.getImage())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "image", "image.required");
            errors.rejectValue("image", "image.required", "封面不能为空");
        }

        if (StringUtils.isBlank(obj.getFilePath())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "filePath", "filePath.required");
            errors.rejectValue("filePath", "filePath.required", "视频不能为空");
        }
    }
}