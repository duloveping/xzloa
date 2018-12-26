package cn.com.enjoystudy.oa.service.sys;

import cn.com.enjoystudy.oa.bean.sys.BaseDictionary;
import cn.com.enjoystudy.oa.bean.sys.BaseDictionarySO;

import java.util.List;

/**
 * 数字字典Service
 * @author 广州新咨力科技有限公司-杜永生
 */
public interface BaseDictionaryService {
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
    BaseDictionary getById(String id);

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
    List<BaseDictionary> list(BaseDictionarySO so);

    long count(BaseDictionarySO so);
}
