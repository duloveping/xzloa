package cn.com.enjoystudy.oa.tag.web;

import cn.com.enjoystudy.oa.bean.web.Advertisement;
import cn.com.enjoystudy.oa.bean.web.AdvertisementSO;
import cn.com.enjoystudy.oa.service.web.AdvertisementService;
import cn.com.enjoystudy.oa.tag.BaseTagSupport;
import com.github.pagehelper.PageInfo;

public class AdvertisementListTag extends BaseTagSupport {
    private int pageSize = 20;
    /** 显示状态 */
    private Boolean showState;
    /** 所属位置ID */
    private String placeId;
    /** 所属位置编号 */
    private String placeCode;
    /** 类型 */
    private String category;


    @Override
    protected int doStartTagInternal() throws Exception {
        AdvertisementSO so = new AdvertisementSO();
        so.setPageNum(1);
        so.setPageSize(pageSize);
        so.setShowState(showState);
        so.setPlaceId(placeId);
        so.setPlaceCode(placeCode);
        so.setCategory(category);

        AdvertisementService service = (AdvertisementService) getBean(AdvertisementService.class);
        PageInfo<Advertisement> pageInfo = service.findPag(so);
        pageContext.setAttribute(getVarid(), pageInfo.getList());
        return SKIP_PAGE;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
