package cn.com.enjoystudy.oa.tag;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

public abstract class BaseTagSupport extends RequestContextAwareTag {
    private static final long serialVersionUID = 2632917102773627172L;
    /** 变量名称 */
    private String varid;

    protected Object getBean(String beanId) {
        WebApplicationContext context = getRequestContext().getWebApplicationContext();
        return context.getBean(beanId);
    }

    protected Object getBean(Class<?> clazz) {
        WebApplicationContext context = getRequestContext().getWebApplicationContext();
        return context.getBean(clazz);
    }

    protected Object getBean(Class<?> clazz, Object... objs) {
        WebApplicationContext context = getRequestContext().getWebApplicationContext();
        return context.getBean(clazz, objs);
    }

    protected Object getBean(String arg0, Class<?> clazz) {
        WebApplicationContext context = getRequestContext().getWebApplicationContext();
        return context.getBean(arg0, clazz);
    }

    public String getVarid() {
        return varid;
    }

    public void setVarid(String varid) {
        this.varid = varid;
    }
}