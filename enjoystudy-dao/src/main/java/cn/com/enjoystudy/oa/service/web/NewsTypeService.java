package cn.com.enjoystudy.oa.service.web;

import cn.com.enjoystudy.oa.bean.web.NewsType;
import cn.com.enjoystudy.oa.bean.web.NewsTypeSO;

import java.util.List;

public interface NewsTypeService {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(NewsType entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(NewsType entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    NewsType getById(String id);

    /**
     * 根据编号查找
     * @param id
     * @return
     */
    NewsType getByCode(String id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<NewsType> list(NewsTypeSO so);

    List<NewsType> recursionFindMenu(NewsTypeSO so, List<NewsType> types);
}
