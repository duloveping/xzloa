package cn.com.enjoystudy.oa.service.web;


import cn.com.enjoystudy.oa.bean.study.Course;
import cn.com.enjoystudy.oa.bean.study.CourseSO;
import cn.com.enjoystudy.oa.bean.web.AdvertisementPlace;
import cn.com.enjoystudy.oa.bean.web.AdvertisementPlaceSO;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdvertisementPlaceService {
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

    AdvertisementPlace getByCode(String code);

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

    PageInfo<AdvertisementPlace> findPag(AdvertisementPlaceSO so);
}
