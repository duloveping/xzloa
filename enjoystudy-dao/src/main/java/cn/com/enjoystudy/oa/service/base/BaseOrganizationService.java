package cn.com.enjoystudy.oa.service.base;

import cn.com.enjoystudy.oa.bean.base.BaseOrganization;
import cn.com.enjoystudy.oa.bean.base.BaseOrganizationSO;

import java.util.List;

public interface BaseOrganizationService {
    BaseOrganization getById(String id);

    List<BaseOrganization> list(BaseOrganizationSO so);

    List<BaseOrganization> parents(String organizationId, List<BaseOrganization> list);

    List<BaseOrganization> childs(String organizationId, List<BaseOrganization> list);

    List<BaseOrganization> getCurrentEmployeeFullOrganization(String employeeId);




}
