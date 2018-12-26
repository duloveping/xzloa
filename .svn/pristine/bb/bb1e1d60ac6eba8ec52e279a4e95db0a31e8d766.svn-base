package cn.com.enjoystudy.oa.validation.manage.system;

import cn.com.enjoystudy.oa.bean.sys.BaseDictionarySO;
import cn.com.enjoystudy.oa.service.sys.BaseDictionaryService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

public class BaseDictionaryValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BaseDictionarySO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BaseDictionarySO obj = (BaseDictionarySO) target;

        if (StringUtils.isBlank(obj.getCode())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "code.required");
            errors.rejectValue("code", "name.required", "编号不能为空");
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            BaseDictionaryService service = context.getBean(BaseDictionaryService.class);

            BaseDictionarySO so = new BaseDictionarySO();
            so.setCode(obj.getCode());
            so.setExceptId(obj.getId());
            if (service.count(so) > 0) {
                errors.rejectValue("code", "code.required", "编号已经被使用");
            }
        }

        if (StringUtils.isBlank(obj.getName())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
            errors.rejectValue("name", "name.required", "名称不能为空");
        }

        if (null == obj.getShowState()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "showState", "showState.required");
            errors.rejectValue("showState", "showState.required", "显示状态不能为空");
        }

        if (ArrayUtils.isEmpty(obj.getItemCodes())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemCodes", "itemCodes.required");
            errors.rejectValue("itemCodes", "itemCodes.required", "字典选项编号不能为空");
        }

        if (ArrayUtils.isEmpty(obj.getItemNames())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemNames", "itemNames.required");
            errors.rejectValue("itemNames", "itemNames.required", "字典选项名称不能为空");
        }

        if (ArrayUtils.isEmpty(obj.getItemStates())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemStates", "itemStates.required");
            errors.rejectValue("itemStates", "itemStates.required", "字典选项状态不能为空");
        }

        if (ArrayUtils.isEmpty(obj.getItemSorts())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemSorts", "itemSorts.required");
            errors.rejectValue("itemSorts", "itemSorts.required", "字典选项排序不能为空");
        }
    }

}
