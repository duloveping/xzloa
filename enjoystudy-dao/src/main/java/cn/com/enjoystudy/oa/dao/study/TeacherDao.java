package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.Teacher;
import cn.com.enjoystudy.oa.bean.study.TeacherSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {
    int insert(Teacher entity);

    int update(Teacher entity);

    Teacher getById(@Param("id") String id);

    int deleteById(@Param("id") String id);

    List<Teacher> list(TeacherSO so);
}
