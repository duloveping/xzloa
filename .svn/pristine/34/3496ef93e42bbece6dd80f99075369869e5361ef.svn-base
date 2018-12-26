package cn.com.enjoystudy.oa.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * JS工具类
 * @author 广州新咨力科技有限公司-杜永生
 */
public class JsUtils {
    private final static Logger LOGGER = LoggerFactory.getLogger(JsUtils.class);

    public static void showMsgAndOutFrame(HttpServletResponse response, String message, String url) {
        showMsgAndOutFrame(response, message, url, "utf-8");
    }

    public static void showMsgAndOutFrame(HttpServletResponse response, String message, String url, String charset) {
        String js = "alert(\"" + message + "\");window.location.href=\"" + url + "\";";
        executeJavascript(response, js, charset);
    }


    public static void executeJavascript(HttpServletResponse response, String js) {
        executeJavascript(response, js, "utf-8");
    }

    /**
     * 执行JS脚本语句
     * @param response
     * @param js
     */
    public static void executeJavascript(HttpServletResponse response, String js, String charset) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding(charset);
            response.setContentType("text/html");
            //不要让浏览器开辟缓存
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("Cache-Control","no-store");
            //程序立即过期
            response.setDateHeader("Expires",0);
            //不要让浏览其缓存程序
            response.setHeader("Pragma","no-cache");

            out = response.getWriter();
            out.println("<script type=\"text/javascript\" language=\"javascript\">"+js+"</script>");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (out != null) {
                out.close();
                out.flush();
            }
        }
    }

    public static void writeText(HttpServletResponse response, String text) {
        writeText(response, text, "utf-8");
    }

    /**
     * 执行JS脚本语句
     * @param response
     * @param js
     */
    public static void writeText(HttpServletResponse response, String text, String charset) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding(charset);
            response.setContentType("text/html");
            //不要让浏览器开辟缓存
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("Cache-Control","no-store");
            //程序立即过期
            response.setDateHeader("Expires",0);
            //不要让浏览其缓存程序
            response.setHeader("Pragma","no-cache");
            out = response.getWriter();
            out.println(text);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (out != null) {
                out.close();
                out.flush();
            }
        }
    }

    public static void writeJson(HttpServletResponse response, String json) {
        writeJson(response, json, "utf-8");
    }

    public static void writeJson(HttpServletResponse response, String json, String charset) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding(charset);
            response.setContentType("application/x-javascript");
            //不要让浏览器开辟缓存
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("Cache-Control","no-store");
            //程序立即过期
            response.setDateHeader("Expires",0);
            //不要让浏览其缓存程序
            response.setHeader("Pragma","no-cache");
            out = response.getWriter();
            out.print(json);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
}
