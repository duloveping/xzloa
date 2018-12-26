package cn.com.enjoystudy.oa.dao.base;

import cn.com.enjoystudy.oa.bean.base.Department;
import cn.com.enjoystudy.oa.bean.base.DepartmentSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 部门DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface DepartmentDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(Department entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(Department entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    Department getById(@Param("id") String id);

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
    List<Department> list(DepartmentSO so);

    long count(DepartmentSO so);
}
