package cn.com.enjoystudy.oa.dao.web;

import cn.com.enjoystudy.oa.bean.web.NewsType;
import cn.com.enjoystudy.oa.bean.web.NewsTypeSO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 新闻类别DAO
 * @author 广州新咨力科技有限公司-杜永生
 *
 */
@Repository
public interface NewsTypeDao {
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
}
