package cn.com.enjoystudy.oa.service.base;

import cn.com.enjoystudy.oa.bean.base.Department;
import cn.com.enjoystudy.oa.bean.base.DepartmentSO;
import cn.com.enjoystudy.oa.dao.base.DepartmentDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门Service
 * @author 广州新咨力科技有限公司-杜永生
 */
public interface DepartmentService {
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
    Department getById(String id);

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
    List<Department> list(DepartmentSO so);

    List<Department> tree(DepartmentSO so, List<Department> departments);

    long count(DepartmentSO so);
}
