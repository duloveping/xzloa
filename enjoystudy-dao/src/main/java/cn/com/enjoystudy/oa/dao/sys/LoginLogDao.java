package cn.com.enjoystudy.oa.dao.sys;

import cn.com.enjoystudy.oa.bean.sys.LoginLog;
import cn.com.enjoystudy.oa.bean.sys.LoginLogSO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 登录日志
 *
 * @author 广州新咨力科技有限公司-杜永生
 */
@Repository
public interface LoginLogDao {
    /**
     * 插入
     *
     * @param po
     * @return
     */
    int insert(LoginLog po);

    /**
     * 列表查询
     *
     * @param so
     * @return
     */
    List<LoginLog> list(LoginLogSO so);

    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    int deleteById(String id);
}
