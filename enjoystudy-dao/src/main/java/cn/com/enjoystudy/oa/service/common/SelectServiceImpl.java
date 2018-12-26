package cn.com.enjoystudy.oa.service.common;

import cn.com.enjoystudy.oa.bean.common.SearchCriteria;
import cn.com.enjoystudy.oa.dao.common.SelectDao;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SelectServiceImpl implements SelectService {
    @Autowired
    private SelectDao selectDao;

    @Override
    public List<Map<String, String>> findEmployeesByIds(String[] employeeIds) {
        return selectDao.findEmployeesByIds(employeeIds);
    }

    @Override
    public List<Map<String, String>> findDepartmentList(String[] departmentIds) {
        return selectDao.findDepartmentsByIds(departmentIds);
    }

    @Override
    public Object zTreefindSubOrgs(SearchCriteria criteria, boolean... expand) {
        return null;
    }

    @Override
    public Map<String, String[]> getData(String[] ids, Integer target) {
        String[] id = null;
        String[] name = null;


        if (target.equals(0)) {
            List<Map<String, String>> list = selectDao.findEmployeesByIds(ids);

            if (null != list && list.size() > 0) {
                id = new String[list.size()];
                name = new String[list.size()];

                int i = 0;
                for (Map<String, String> map : list) {
                    id[i] = MapUtils.getString(map, "employeeId");
                    name[i] = MapUtils.getString(map, "employeeName") + "（" + MapUtils.getString(map, "departmentName") + "）";
                }
            }
        } else {
            List<Map<String, String>> list = selectDao.findDepartmentsByIds(ids);
            if (null != list && list.size() > 0) {
                id = new String[list.size()];
                name = new String[list.size()];

                int i = 0;
                for (Map<String, String> map : list) {
                    id[i] = MapUtils.getString(map, "departmentId");
                    name[i] = MapUtils.getString(map, "departmentName");
                }
            }
        }

        Map<String, String[]> data = new HashMap<String, String[]>();
        data.put("id", id);
        data.put("name", name);
        return data;
    }

    @Override
    public Object zTreefindThroughOrg(SearchCriteria criteria) {
        return null;
    }
}
