package cn.com.enjoystudy.oa.tag.study;

import cn.com.enjoystudy.oa.bean.study.Teacher;
import cn.com.enjoystudy.oa.bean.study.TeacherSO;
import cn.com.enjoystudy.oa.service.study.TeacherService;
import cn.com.enjoystudy.oa.tag.BaseTagSupport;
import com.github.pagehelper.PageInfo;

public class TeacherListTag extends BaseTagSupport {
    private int pageSize = 20;

    @Override
    protected int doStartTagInternal() throws Exception {
        TeacherSO so = new TeacherSO();
        so.setPageNum(1);
        so.setPageSize(pageSize);

        TeacherService service = (TeacherService) getBean(TeacherService.class);
        PageInfo<Teacher> pageInfo = service.findPag(so);

        pageContext.setAttribute(getVarid(), pageInfo.getList());
        return SKIP_PAGE;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
