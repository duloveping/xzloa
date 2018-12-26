package cn.com.enjoystudy.oa.test;

import cn.com.enjoystudy.oa.bean.sys.LoginLog;
import cn.com.enjoystudy.oa.bean.sys.LoginLogSO;
import cn.com.enjoystudy.oa.dao.sys.LoginLogDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class JunitTestLoginLog {
    @Autowired
    private LoginLogDao loginLogDao;

    @Test
    public void testInsertLoginLog() {
        LoginLog log = new LoginLog();
        log.preInsert();
        log.setUsername("admin");
        log.setRequestTime(new Date());
        log.setSessionid("42DEB3AA23DDC96A9CA23E58D3E47297");
        log.setIpAddress("0:0:0:0:0:0:0:1");
        log.setDeviceType("Computer");
        log.setBrowserType("Chrome");
        log.setLoginState(false);
        log.setCaption("测试信息");

        loginLogDao.insert(log);

        List<LoginLog> list = loginLogDao.list(new LoginLogSO());
        for (LoginLog data : list) {
            System.out.println(data.getCaption());
        }

    }
}
