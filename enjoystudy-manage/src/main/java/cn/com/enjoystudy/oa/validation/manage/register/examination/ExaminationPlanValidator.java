package cn.com.enjoystudy.oa.validation.manage.register.examination;

import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlanSO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ExaminationPlanValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ExaminationPlanSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ExaminationPlanSO obj = (ExaminationPlanSO) target;

        if (StringUtils.isBlank(obj.getTitle())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required");
            errors.rejectValue("title", "title.required", "考试标题不能为空");
        }

        if (null == obj.getShowState()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "entryState", "entryState.required");
            errors.rejectValue("showState", "showState.required", "显示状态不能为空");
        }
    }
}