package cn.com.enjoystudy.oa.validation.manage.register.examination;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccountSO;
import cn.com.enjoystudy.oa.bean.register.examination.AccountRegister;
import cn.com.enjoystudy.oa.bean.register.examination.ExaminationPlanSO;
import cn.com.enjoystudy.oa.service.base.EmployeeAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

public class AccountRegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AccountRegister.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountRegister obj = (AccountRegister) target;

        if (StringUtils.isBlank(obj.getUsername())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
            errors.rejectValue("username", "username.required", "用户名不能为空");
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            EmployeeAccountService service = context.getBean(EmployeeAccountService.class);

            EmployeeAccountSO so = new EmployeeAccountSO();
            so.setCode(obj.getUsername());
            if (service.count(so) > 0) {
                errors.rejectValue("username", "username.required", "用户名已被使用");
            }
        }

        if (StringUtils.isBlank(obj.getRealname())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "realname", "realname.required");
            errors.rejectValue("realname", "realname.required", "姓名不能为空");
        }

        if (null == obj.getSex()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "sex.required");
            errors.rejectValue("sex", "sex.required", "性别不能为空");
        }

        if (null == obj.getIdentityType()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "identityType", "identityType.required");
            errors.rejectValue("identityType", "identityType.required", "证件类型不能为空");
        }

        if (StringUtils.isBlank(obj.getIdentityCode())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "identityCode", "identityCode.required");
            errors.rejectValue("identityCode", "identityCode.required", "证件号码不能为空");
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            EmployeeAccountService service = context.getBean(EmployeeAccountService.class);

            EmployeeAccountSO so = new EmployeeAccountSO();
            so.setIdentityCode(StringUtils.trim(obj.getIdentityCode()));
            so.setIdentityType(obj.getIdentityType());
            if (service.count(so) > 0) {
                errors.rejectValue("identityCode", "identityCode.required", "该证件号已被使用");
            }
        }

        if (StringUtils.isBlank(obj.getQuestion())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "question", "question.required");
            errors.rejectValue("question", "question.required", "密码找回问题不能为空");
        }

        if (StringUtils.isBlank(obj.getAnswer())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer", "answer.required");
            errors.rejectValue("answer", "answer.required", "密码找回答案不能为空");
        }

        if (StringUtils.isBlank(obj.getMobile())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "mobile.required");
            errors.rejectValue("mobile", "mobile.required", "手机号码不能为空");
        }

        if (StringUtils.isBlank(obj.getLoginPassword())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginPassword", "loginPassword.required");
            errors.rejectValue("loginPassword", "loginPassword.required", "登录密码不能为空");
        } else if (StringUtils.isBlank(obj.getConfirmPassword())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "confirmPassword.required");
            errors.rejectValue("confirmPassword", "confirmPassword.required", "登录密码不能为空");
        } else if (!obj.getLoginPassword().equals(obj.getConfirmPassword())) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginPassword", "loginPassword.required");
            errors.rejectValue("loginPassword", "loginPassword.required", "输入的密码不相同");
        }
    }
}