package cn.com.enjoystudy.oa.service.web;

import cn.com.enjoystudy.oa.bean.web.News;
import cn.com.enjoystudy.oa.bean.web.NewsSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface NewsService {
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

    PageInfo<News> findPage(NewsSO so);
}
