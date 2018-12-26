package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.Teacher;
import cn.com.enjoystudy.oa.bean.study.TeacherSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TeacherService {
    int insert(Teacher entity);

    int update(Teacher entity);

    Teacher getById(String id);

    int deleteById(String id);

    List<Teacher> list(TeacherSO so);

    PageInfo<Teacher> findPag(TeacherSO so);
}
