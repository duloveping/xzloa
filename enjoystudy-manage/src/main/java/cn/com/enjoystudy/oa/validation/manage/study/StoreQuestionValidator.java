package cn.com.enjoystudy.oa.validation.manage.study;

import cn.com.enjoystudy.oa.bean.study.StoreQuestionSO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StoreQuestionValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return StoreQuestionSO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StoreQuestionSO obj = (StoreQuestionSO) target;

        if (StringUtils.isBlank(obj.getTitle())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required");
            errors.rejectValue("title", "title.required", "考试题问题不能为空");
        }

        if (null == obj.getCategory()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "category.required");
            errors.rejectValue("category", "category.required", "考试题类型不能为空");
        }

        if (null == obj.getScore()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "score.required");
            errors.rejectValue("score", "score.required", "考试题分值不能为空");
        }

        if (null == obj.getItemList() || obj.getItemList().size() == 0) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemList", "itemList.required");
            errors.rejectValue("itemList", "itemList.required", "答题选项不能为空");
        }
    }
}