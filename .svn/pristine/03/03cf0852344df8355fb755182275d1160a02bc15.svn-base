package cn.com.enjoystudy.oa.dao.sys;

import cn.com.enjoystudy.oa.bean.sys.BaseDictionary;
import cn.com.enjoystudy.oa.bean.sys.BaseDictionaryItem;
import cn.com.enjoystudy.oa.bean.sys.BaseDictionarySO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数字字典DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface BaseDictionaryDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(BaseDictionary entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(BaseDictionary entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    BaseDictionary getById(@Param("id") String id);

    /**
     * 根据ID删除
     * @param id
     */
    void deleteById(@Param("id") String id);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<BaseDictionary> list(BaseDictionarySO so);

    long count(BaseDictionarySO so);

    List<BaseDictionaryItem> findItemByDictionaryId(@Param("dictionaryId") String dictionaryId);
}
