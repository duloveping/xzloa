package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.base.Student;
import cn.com.enjoystudy.oa.bean.base.StudentSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StudentService {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(Student entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(Student entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    Student getById(String id);

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
    List<Student> list(StudentSO so);

    /**
     * 分页查询
     * @param so
     * @return
     */
    PageInfo<Student> findPage(StudentSO so);
}
