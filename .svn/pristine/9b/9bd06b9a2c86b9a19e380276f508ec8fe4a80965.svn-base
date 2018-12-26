package cn.com.enjoystudy.oa.service.sys;

import cn.com.enjoystudy.oa.bean.sys.LoginLog;
import cn.com.enjoystudy.oa.bean.sys.LoginLogSO;
import cn.com.enjoystudy.oa.dao.sys.LoginLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 登录日志Service实现
 *
 * @author 广州新咨力科技有限公司-杜永生
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    private LoginLogDao loginLogDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(LoginLog po) {
        po.preInsert();
        return loginLogDao.insert(po);
    }

    @Override
    public List<LoginLog> list(LoginLogSO so) {
        return loginLogDao.list(so);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return loginLogDao.deleteById(id);
    }
}
