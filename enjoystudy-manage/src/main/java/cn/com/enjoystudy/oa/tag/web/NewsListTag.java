package cn.com.enjoystudy.oa.tag.web;

import cn.com.enjoystudy.oa.bean.web.News;
import cn.com.enjoystudy.oa.bean.web.NewsSO;
import cn.com.enjoystudy.oa.service.web.NewsService;
import cn.com.enjoystudy.oa.tag.BaseTagSupport;
import com.github.pagehelper.PageInfo;

public class NewsListTag extends BaseTagSupport {
    private int pageSize = 20;
    /** 标题 */
    private String title;
    /** 显示状态 */
    private Boolean showState;
    /** 所属类别ID */
    private String typeId;
    /** 所属类别编号 */
    private String typeCode;
    /** 所属类别状态 */
    private Boolean typeState;


    @Override
    protected int doStartTagInternal() throws Exception {
        NewsSO so = new NewsSO();
        so.setPageNum(1);
        so.setPageSize(pageSize);
        so.setShowState(showState);
        so.setTitle(title);
        so.setTypeId(typeId);
        so.setTypeCode(typeCode);
        so.setTypeState(typeState);

        NewsService service = (NewsService) getBean(NewsService.class);
        PageInfo<News> pageInfo = service.findPage(so);
        pageContext.setAttribute(getVarid(), pageInfo.getList());
        return SKIP_PAGE;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Boolean getTypeState() {
        return typeState;
    }

    public void setTypeState(Boolean typeState) {
        this.typeState = typeState;
    }
}