package cn.com.enjoystudy.oa.util;

import javax.servlet.http.HttpServletRequest;

public class AjaxUtils {
    /**
     * 是否是Ajax请求
     * @param request
     * @return
     */
    public static final Boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader("x-requested-with");
        if (requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest")) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
