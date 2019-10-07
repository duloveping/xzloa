package cn.com.enjoystudy.oa.filter;

import cn.com.enjoystudy.oa.util.AjaxUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeAccountUserFilter extends UserFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (AjaxUtils.isAjaxRequest(req)) {
            JSONObject json = new JSONObject();
            json.put("status", true);
            json.put("info", "网页过期，请重新登录");
        }

        return super.onAccessDenied(request, response);
    }
}
