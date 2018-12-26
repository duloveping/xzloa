package cn.com.enjoystudy.oa.service.common;

import cn.com.enjoystudy.oa.bean.common.SearchCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectService {
    List<Map<String, String>> findEmployeesByIds(String[] employeeIds);

    List<Map<String, String>> findDepartmentList(String[] departmentIds);

    /**
     *
     * @param ids
     * @param target: 目标，为0表示要获取用户，其它值表示获取单位
     * @return 返回结果的id, name的顺序和提供的参数一致
     */
    Map<String, String[]> getData(String[] ids, Integer target);

    Object zTreefindSubOrgs(SearchCriteria criteria, boolean... expand);

    Object zTreefindThroughOrg(SearchCriteria criteria);
}
