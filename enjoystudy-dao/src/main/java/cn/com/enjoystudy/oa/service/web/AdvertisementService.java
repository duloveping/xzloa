package cn.com.enjoystudy.oa.service.web;


import cn.com.enjoystudy.oa.bean.web.Advertisement;
import cn.com.enjoystudy.oa.bean.web.AdvertisementSO;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdvertisementService {
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

    PageInfo<Advertisement> findPag(AdvertisementSO so);
}
