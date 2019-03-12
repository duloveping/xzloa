package cn.com.enjoystudy.oa.validation.manage.web;

import cn.com.enjoystudy.oa.bean.web.CourseTrainPlanSO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CourseTrainPlanValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CourseTrainPlanSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourseTrainPlanSO obj = (CourseTrainPlanSO) target;

        if (StringUtils.isBlank(obj.getCourseName())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courseName", "courseName.required");
            errors.rejectValue("courseName", "courseName.required", "培训课程名称不能为空");
        }

        if (StringUtils.isBlank(obj.getCompanyName())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "companyName.required");
            errors.rejectValue("companyName", "companyName.required", "培训单位名称不能为空");
        }

        if (StringUtils.isBlank(obj.getTrainAddress())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainAddress", "trainAddress.required");
            errors.rejectValue("trainAddress", "trainAddress.required", "培训地址不能为空");
        }

        if (StringUtils.isBlank(obj.getLinkManName())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "linkManName", "linkManName.required");
            errors.rejectValue("linkManName", "linkManName.required", "联系人姓名不能为空");
        }

        if (StringUtils.isBlank(obj.getLinkManMobile())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "linkManMobile", "linkManMobile.required");
            errors.rejectValue("linkManMobile", "linkManMobile.required", "联系人电话不能为空");
        }

        if (StringUtils.isBlank(obj.getTrainTeacherName())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainTeacherName", "trainTeacherName.required");
            errors.rejectValue("trainTeacherName", "trainTeacherName.required", "培训师姓名不能为空");
        }

        if (StringUtils.isBlank(obj.getTrainTeacherMobile())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainTeacherMobile", "trainTeacherMobile.required");
            errors.rejectValue("trainTeacherMobile", "trainTeacherMobile.required", "培训师电话不能为空");
        }

        if (null == obj.getShowState()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "showState", "showState.required");
            errors.rejectValue("showState", "showState.required", "显示状态不能为空");
        }

        if (null == obj.getTrainStartTime()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainStartTime", "trainStartTime.required");
            errors.rejectValue("trainStartTime", "trainStartTime.required", "培训开始时间不能为空");
        }

        if (null == obj.getTrainStartTime()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainEndTime", "trainEndTime.required");
            errors.rejectValue("trainEndTime", "trainEndTime.required", "培训结束时间不能为空");
        }
    }
}

