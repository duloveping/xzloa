package cn.com.enjoystudy.oa.validation.manage.study;

import cn.com.enjoystudy.oa.bean.study.CourseAttachmentSO;
import cn.com.enjoystudy.oa.bean.study.CourseVideoSO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CourseAttachmentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CourseAttachmentSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourseAttachmentSO obj = (CourseAttachmentSO) target;

        if (StringUtils.isBlank(obj.getFileName())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
            errors.rejectValue("fileName", "fileName.required", "名称不能为空");
        }

        if (StringUtils.isBlank(obj.getCourseId())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courseId", "courseId.required");
            errors.rejectValue("courseId", "courseId.required", "分类不能为空");
        }

        if (StringUtils.isBlank(obj.getFilePath())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "filePath", "filePath.required");
            errors.rejectValue("filePath", "filePath.required", "文件不能为空");
        }
    }
}