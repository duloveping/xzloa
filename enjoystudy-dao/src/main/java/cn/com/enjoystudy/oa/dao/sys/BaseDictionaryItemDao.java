package cn.com.enjoystudy.oa.dao.sys;

import cn.com.enjoystudy.oa.bean.sys.BaseDictionaryItem;
import cn.com.enjoystudy.oa.bean.sys.BaseDictionaryItemSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数字字典选项DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface BaseDictionaryItemDao {
    /**
     * 插入
     * @param entity
     * @return
     */
        int insert(BaseDictionaryItem entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(BaseDictionaryItem entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    BaseDictionaryItem getById(@Param("id") String id);

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
    List<BaseDictionaryItem> list(BaseDictionaryItemSO so);

    int deleteByDictionaryId(@Param("dictionaryId")String dictionaryId);

}
