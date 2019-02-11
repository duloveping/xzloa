package cn.com.enjoystudy.oa.tag.web;

import cn.com.enjoystudy.oa.bean.web.AdvertisementPlace;
import cn.com.enjoystudy.oa.bean.web.AdvertisementPlaceSO;
import cn.com.enjoystudy.oa.service.web.AdvertisementPlaceService;
import cn.com.enjoystudy.oa.tag.BaseTagSupport;
import com.github.pagehelper.PageInfo;

public class AdvertisementPlaceListTag extends BaseTagSupport {
    private int pageSize = 20;
    /** 显示状态 */
    private Boolean showState;
    /** 编号 */
    private String code;
    /** 名称 */
    private String name;
    /** 所属位置 */
    private String placeId;
    /** 归类 */
    private String category;

    @Override
    protected int doStartTagInternal() throws Exception {
        AdvertisementPlaceSO so = new AdvertisementPlaceSO();
        so.setPageNum(1);
        so.setPageNum(pageSize);
        so.setCode(code);
        so.setName(name);
        so.setPlaceId(placeId);
        so.setCategory(category);

        AdvertisementPlaceService service = (AdvertisementPlaceService) getBean(AdvertisementPlaceService.class);
        PageInfo<AdvertisementPlace> pageInfo = service.findPag(so);
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
