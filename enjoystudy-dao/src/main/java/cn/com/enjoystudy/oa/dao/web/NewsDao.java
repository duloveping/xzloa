package cn.com.enjoystudy.oa.dao.web;

import cn.com.enjoystudy.oa.bean.web.News;
import cn.com.enjoystudy.oa.bean.web.NewsSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(News entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(News entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    News getById(String id);

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
    List<News> list(NewsSO so);
}
