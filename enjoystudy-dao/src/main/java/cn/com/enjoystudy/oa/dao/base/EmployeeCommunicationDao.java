package cn.com.enjoystudy.oa.dao.base;

import cn.com.enjoystudy.oa.bean.base.EmployeeCommunication;
import cn.com.enjoystudy.oa.bean.base.EmployeeCommunicationSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCommunicationDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(EmployeeCommunication entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(EmployeeCommunication entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    EmployeeCommunication getById(String id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<EmployeeCommunication> list(EmployeeCommunicationSO so);
}
