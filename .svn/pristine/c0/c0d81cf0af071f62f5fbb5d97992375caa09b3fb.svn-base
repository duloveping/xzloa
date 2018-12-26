package cn.com.enjoystudy.oa.service.base;

import cn.com.enjoystudy.oa.bean.base.BasePosition;
import cn.com.enjoystudy.oa.bean.base.BasePositionSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 职务Service
 * @author 广州新咨力科技有限公司-杜永生
 */
public interface BasePositionService {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(BasePosition entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(BasePosition entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    BasePosition getById(String id);

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
    List<BasePosition> list(BasePositionSO so);

    long count(BasePositionSO so);

    PageInfo<BasePosition> findPag(BasePositionSO so);
}
