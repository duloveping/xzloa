package cn.com.enjoystudy.oa.dao.base;

import cn.com.enjoystudy.oa.bean.base.BasePosition;
import cn.com.enjoystudy.oa.bean.base.Department;
import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.bean.base.EmployeeAccountSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 员工账号DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface EmployeeAccountDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(EmployeeAccount entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(EmployeeAccount entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    EmployeeAccount getById(@Param("id") String id);

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
    List<EmployeeAccount> list(EmployeeAccountSO so);

    Department getDepartment(String departmentId);

    BasePosition getPosition(String positionId);

    long count(EmployeeAccountSO so);

    void updateLoginPassword(@Param("password")String password, @Param("id")String id);
}
