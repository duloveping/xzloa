package cn.com.enjoystudy.oa.dao.sys;

import cn.com.enjoystudy.oa.bean.sys.SysRolePosition;
import cn.com.enjoystudy.oa.bean.sys.SysRolePositionSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRolePositionDao {
    int insert(SysRolePosition entity);

    int update(SysRolePosition entity);

    List<SysRolePosition> list(SysRolePositionSO so);

    SysRolePosition getById(String id);

    int deleteById(String id);

    List<SysRolePosition> findByRoleId(String roleId);

    List<SysRolePosition> findByPositionId(String positionId);

    int deleteByRoleId(String roleId);

    int deleteByPositionId(String positionId);

    SysRolePosition getRole(String roleId);

    SysRolePosition getPosition(String positionId);
}
