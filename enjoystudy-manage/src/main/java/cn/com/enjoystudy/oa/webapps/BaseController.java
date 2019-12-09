package cn.com.enjoystudy.oa.webapps;

import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.study.CourseVideo;
import cn.com.enjoystudy.oa.filter.ManageSessionFilter;
import cn.com.enjoystudy.oa.util.AjaxUtils;
import cn.com.enjoystudy.oa.util.JsUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基础Controller，所属的Controller类都需要继承该类
 */
public class BaseController {
    public EmployeeAccount getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getSession().getAttribute(ManageSessionFilter.DEFAULT_LOGIN_USER);
        EmployeeAccount account = (EmployeeAccount) object;
        return account;
    }

    public JSONObject resultSuccess() {
        return resultSuccess("成功");
    }

    public JSONObject resultSuccess(String info) {
        JSONObject json = new JSONObject();
        json.put("status", true);
        json.put("info", info);
        return json;
    }

    public JSONObject resultSuccess(PageInfo<?> pageInfo) {
        JSONObject json = resultSuccess();
        json.put("datas", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        json.put("pages", pageInfo.getPages());
        return json;
    }

    public JSONObject resultError() {
        return resultError("失败");
    }

    public JSONObject resultError(String info) {
        JSONObject json = new JSONObject();
        json.put("status", false);
        if (StringUtils.isNotBlank(info)) {
            json.put("info", info);
        }
        return json;
    }


    public Integer getStart(int page, int size) {
        if (page > 0) {
            return (page - 1) * size;
        }
        return 0;
    }

    public Integer getTotalPage(int total, int size) {
        int page = total / size;
        if (total % size != 0) {
            page += 1;
        }
        return page;
    }

    /**
     * 登录认证异常
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
    public ModelAndView authenticationException(HttpServletRequest request, HttpServletResponse response) {
        if (AjaxUtils.isAjaxRequest(request)) {
            JSONObject json = new JSONObject();
            json.put("info", "未登录");
            json.put("status", false);
            JsUtils.writeJson(response, json.toJSONString());
            return null;
        } else {
            return new ModelAndView("redirect:/manage/login/index.jhtml");
        }
    }

    /**
     * 权限异常
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
    public ModelAndView authorizationException(HttpServletRequest request, HttpServletResponse response) {
        if (AjaxUtils.isAjaxRequest(request)) {
            JSONObject json = new JSONObject();
            json.put("info", "无权限");
            json.put("status", false);
            JsUtils.writeJson(response, json.toJSONString());
            return null;
        } else {
            return new ModelAndView("redirect:/common/error/403.jhtml");
        }
    }
}

