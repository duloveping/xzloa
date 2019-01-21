package cn.com.enjoystudy.oa.dao.web;

import cn.com.enjoystudy.oa.bean.web.Advertisement;
import cn.com.enjoystudy.oa.bean.web.AdvertisementSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 广告DAO
 * @author 广州新咨力科技有限公司-杜永生
 *
 */
@Repository
public interface AdvertisementDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(Advertisement entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(Advertisement entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    Advertisement getById(@Param("id") String id);

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
    List<Advertisement> list(AdvertisementSO so);

}
