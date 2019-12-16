package cn.com.enjoystudy.oa.dao.shop;

import cn.com.enjoystudy.oa.bean.shop.StudentCourseList;
import cn.com.enjoystudy.oa.bean.shop.StudentCourseListSO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseListDao {
    /**
     * 插入
     * @param entity
     * @return
     */
    int insert(StudentCourseList entity);

    /**
     * 更新
     * @param entity
     * @return
     */
    int update(StudentCourseList entity);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    StudentCourseList getById(String id);

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
    List<StudentCourseList> list(StudentCourseListSO so);
}
