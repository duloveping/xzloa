package cn.com.enjoystudy.oa.service.shop;

import cn.com.enjoystudy.oa.bean.shop.StudentCourseList;
import cn.com.enjoystudy.oa.bean.shop.StudentCourseListSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StudentCourseListService {
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

    PageInfo<StudentCourseList> findPage(StudentCourseListSO so);
}
