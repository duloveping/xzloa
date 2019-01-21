package cn.com.enjoystudy.oa.dao.web;

import cn.com.enjoystudy.oa.bean.web.AdvertisementPlace;
import cn.com.enjoystudy.oa.bean.web.AdvertisementPlaceSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 广告位置DAO
 * @author 广州新咨力科技有限公司-杜永生
 *
 */
@Repository
public interface AdvertisementPlaceDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(AdvertisementPlace entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(AdvertisementPlace entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    AdvertisementPlace getById(@Param("id") String id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(@Param("id") String id);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<AdvertisementPlace> list(AdvertisementPlaceSO so);

    /**
     * 统计
     * @param so
     * @return
     */
    long count(AdvertisementPlaceSO so);
}
