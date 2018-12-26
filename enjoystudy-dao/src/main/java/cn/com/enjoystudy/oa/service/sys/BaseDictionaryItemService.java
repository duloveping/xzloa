package cn.com.enjoystudy.oa.service.sys;

import cn.com.enjoystudy.oa.bean.sys.BaseDictionaryItem;
import cn.com.enjoystudy.oa.bean.sys.BaseDictionaryItemSO;

import java.util.List;

/**
 * 数字字典Service
 * @author 广州新咨力科技有限公司-杜永生
 */
public interface BaseDictionaryItemService {
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
    BaseDictionaryItem getById(String id);

    /**
     * 根据ID删除
     * @param id
     */
    void deleteById(String id);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<BaseDictionaryItem> list(BaseDictionaryItemSO so);

    int deleteByDictionaryId(String dictionaryId);
}
