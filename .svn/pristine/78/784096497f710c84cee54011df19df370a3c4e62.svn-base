package cn.com.enjoystudy.oa.dao.base;

import cn.com.enjoystudy.oa.bean.base.EmployeePosition;
import cn.com.enjoystudy.oa.bean.base.EmployeePositionSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 职务DAO
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface EmployeePositionDao {
    int insert(EmployeePosition entity);

    int update(EmployeePosition entity);

    EmployeePosition getById(@Param("id") String id);

    int deleteById(@Param("id") String id);

    List<EmployeePosition> list(EmployeePositionSO so);

    List<EmployeePosition> findByEmployeeId(@Param("employeeId") String employeeId);

    List<EmployeePosition> finidByPositionId(@Param("positionId") String positionId);

    int deleteByEmployeeId(@Param("employeeId") String employeeId);

    int deleteByPositionId(@Param("positionId") String positionId);

}
