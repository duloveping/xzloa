package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseType;
import cn.com.enjoystudy.oa.bean.study.CourseTypeSO;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

public interface CourseTypeService {
    int insert(CourseType entity);

    int update(CourseType entity);

    CourseType getById(String id);

    int deleteById(String id);

    List<CourseType> list(CourseTypeSO so);

    long count(CourseTypeSO so);

    List<CourseType> tree(CourseTypeSO so, List<CourseType> types);

    JSONArray listToJsonArray(List<CourseType> types);

    List<CourseType> findRecursive(CourseTypeSO so);
}
