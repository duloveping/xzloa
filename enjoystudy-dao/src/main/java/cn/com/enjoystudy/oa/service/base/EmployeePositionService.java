package cn.com.enjoystudy.oa.service.base;

import cn.com.enjoystudy.oa.bean.base.EmployeePosition;
import cn.com.enjoystudy.oa.bean.base.EmployeePositionSO;

import java.util.List;

/**
 * 职务Service
 * @author 广州新咨力科技有限公司-杜永生
 */
public interface EmployeePositionService {
    int insert(EmployeePosition entity);

    int update(EmployeePosition entity);

    EmployeePosition getById(String id);

    int deleteById(String id);

    List<EmployeePosition> list(EmployeePositionSO so);

    List<EmployeePosition> findByEmployeeId(String employeeId);

    List<EmployeePosition> finidByPositionId(String positionId);

    int deleteByEmployeeId(String employeeId);

    int deleteByPositionId(String positionId);
}
