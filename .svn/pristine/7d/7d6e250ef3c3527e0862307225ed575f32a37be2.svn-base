package cn.com.enjoystudy.oa.tag.system;

import cn.com.enjoystudy.oa.bean.sys.SysBaseConfig;
import cn.com.enjoystudy.oa.bean.sys.SysBaseConfigSO;
import cn.com.enjoystudy.oa.service.sys.SysBaseConfigService;
import cn.com.enjoystudy.oa.tag.BaseTagSupport;

import java.util.List;

public class SysBaseConfigTag extends BaseTagSupport {

    @Override
    protected int doStartTagInternal() throws Exception {
        List<SysBaseConfig> list = null;
        SysBaseConfigService service = (SysBaseConfigService) getBean(SysBaseConfigService.class);
        if (null != service) {
            list = service.list(new SysBaseConfigSO());
            pageContext.setAttribute("sysBaseConfig", list.get(0));
        }
        return SKIP_PAGE;
    }
}
