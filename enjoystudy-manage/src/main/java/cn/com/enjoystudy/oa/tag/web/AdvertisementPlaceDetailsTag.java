package cn.com.enjoystudy.oa.tag.web;

import cn.com.enjoystudy.oa.bean.web.AdvertisementPlace;
import cn.com.enjoystudy.oa.service.web.AdvertisementPlaceService;
import cn.com.enjoystudy.oa.tag.BaseTagSupport;
import org.apache.commons.lang3.StringUtils;

public class AdvertisementPlaceDetailsTag extends BaseTagSupport {
    /** 位置ID */
    private String placeId;
    /** 位置编号 */
    private String placeCode;

    @Override
    protected int doStartTagInternal() throws Exception {
        AdvertisementPlaceService service = (AdvertisementPlaceService) getBean(AdvertisementPlaceService.class);

        AdvertisementPlace place = null;
        if (StringUtils.isNotBlank(placeId) || StringUtils.isNotBlank(placeCode)) {
            if (StringUtils.isNotBlank(placeId)) {
                place = service.getById(StringUtils.trim(placeId));
            } else if (StringUtils.isNotBlank(placeCode)) {
                place = service.getByCode(StringUtils.trim(placeCode));
            }
        }
        pageContext.setAttribute(getVarid(), place);
        return SKIP_PAGE;
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
}
