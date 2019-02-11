package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseVideo;
import cn.com.enjoystudy.oa.bean.study.CourseVideoSO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CourseVideoService {
    int insert(CourseVideo entity);

    int update(CourseVideo entity);

    CourseVideo getById(String id);

    int deleteById(String id);

    List<CourseVideo> list(CourseVideoSO so);

    long getCount(CourseVideoSO so);

    int changeShowState(Boolean showState, String id);

    List<CourseVideo> videoList(CourseVideoSO so);

    PageInfo<CourseVideo> findVideoPage(CourseVideoSO so);

    int updateClickAmount(String id);

}
