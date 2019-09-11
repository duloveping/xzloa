package cn.com.enjoystudy.oa.dao.base;

import cn.com.enjoystudy.oa.bean.base.Student;
import cn.com.enjoystudy.oa.bean.base.StudentSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
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
    Student getById(@Param("id") String id);

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(@Param("id") String id);

    /**
     * 列表查询
     * @param so
     * @return
     */
    List<Student> list(StudentSO so);

    List<String> findStudentIdsNotExistsCourseList(String courseId);

    List<String> findStudentIdsExistsCourseList(String courseId);
}
