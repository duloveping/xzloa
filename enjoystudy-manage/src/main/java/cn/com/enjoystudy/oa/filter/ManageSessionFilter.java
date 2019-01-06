package cn.com.enjoystudy.oa.filter;

import cn.com.enjoystudy.oa.util.JsUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "manageSessionFilter", urlPatterns = { "/manage/*" })
public class ManageSessionFilter extends OncePerRequestFilter {
    public static final String DEFAULT_LOGIN_USER = "manage_login_user";

    @Override
    protected void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // 不过滤的uri
        String[] notFilter = new String[] {
                "/manage/login/index.jhtml",
                "/manage/login/login.jhtml",
                "/manage/login/register.jhtml",
                "/manage/login/entry.jhtml",
                "/manage/login/check.jhtml",
                "/manage/login/preview.jhtml",
                "/manage/login/activation.jhtml"};

        // 请求的uri
        String ctxpath = req.getContextPath();
        String uri = req.getRequestURI().substring(ctxpath.length());

        // 是否过滤
        boolean doFilter = true;
        for (String s : notFilter) {
            if (uri.startsWith(s)) {
                // 如果uri中包含不过滤的uri，则不进行过滤
                doFilter = false;
                break;
            }
        }
        if (doFilter) {
            // 从session中获取登录者实体
            Subject subject = SecurityUtils.getSubject();
            Object obj = subject.getSession().getAttribute(DEFAULT_LOGIN_USER);
            if (null == obj) {
                String loginPage = ctxpath + "/manage/login/index.jhtml";
                StringBuilder builder = new StringBuilder();
                builder.append("alert(\"网页过期，请重新登录！\");");
                builder.append("window.top.location.href=\"");
                builder.append(loginPage);
                builder.append("\";");
                JsUtils.executeJavascript(res, builder.toString());
            } else {
                // 如果session中存在登录者实体，则继续
                chain.doFilter(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }
    }
}


