package cn.com.enjoystudy.oa.service.base;

import cn.com.enjoystudy.oa.bean.base.BaseOrganization;
import cn.com.enjoystudy.oa.bean.base.BaseOrganizationSO;
import cn.com.enjoystudy.oa.bean.base.EmployeeAccount;
import cn.com.enjoystudy.oa.dao.base.BaseOrganizationDao;
import cn.com.enjoystudy.oa.dao.base.EmployeeAccountDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true, rollbackFor = Exception.class)
public class BaseOrganizationServiceImpl implements BaseOrganizationService {
    @Autowired
    private BaseOrganizationDao baseOrganizationDao;
    @Autowired
    private EmployeeAccountDao employeeAccountDao;

    @Override
    public BaseOrganization getById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new NullPointerException("id is null.");
        }
        return baseOrganizationDao.getById(id);
    }

    @Override
    public List<BaseOrganization> list(BaseOrganizationSO so) {
        return baseOrganizationDao.list(so);
    }

    @Override
    public List<BaseOrganization> parents(String organizationId, List<BaseOrganization> list) {
        BaseOrganization organization = baseOrganizationDao.getById(organizationId);
        if (null != organization) {
            if (StringUtils.isNotBlank(organization.getParentId())) {
                parents(organization.getParentId(), list);
            }
            list.add(organization);
        }
        return list;
    }

    @Override
    public List<BaseOrganization> childs(String organizationId, List<BaseOrganization> list) {
        BaseOrganizationSO so = new BaseOrganizationSO();
        so.setParentId(organizationId);
        List<BaseOrganization> organizations = baseOrganizationDao.list(so);
        if (null != organizations && organizations.size() > 0) {
            for (BaseOrganization organization : organizations) {
                list.add(organization);
                childs(organization.getId(), list);
            }
        }
        return list;
    }

    @Override
    public List<BaseOrganization> getCurrentEmployeeFullOrganization(String employeeId) {
        if (StringUtils.isBlank(employeeId)) {
            throw new NullPointerException("id is null.");
        }

        EmployeeAccount account = employeeAccountDao.getById(employeeId);

        if (null ==  account) {
            throw new NullPointerException("employee is null.");
        }

        List<BaseOrganization> plist = new ArrayList<BaseOrganization>();
        plist = parents(account.getDepartmentId(), plist);
        return plist;
    }
}
