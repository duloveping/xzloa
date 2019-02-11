package cn.com.enjoystudy.oa.dao.study;

import cn.com.enjoystudy.oa.bean.study.CourseAttachment;
import cn.com.enjoystudy.oa.bean.study.CourseVideo;
import cn.com.enjoystudy.oa.bean.study.CourseVideoSO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseVideoDao {
    int insert(CourseVideo entity);

    int update(CourseVideo entity);

    CourseVideo getById(@Param("id") String id);

    int deleteById(@Param("id") String id);

    List<CourseVideo> list(CourseVideoSO so);

    List<CourseAttachment> findAttachmentsByVideoId(String videoId);

    long getCount(CourseVideoSO so);

    /**
     * 改变视频显示状态
     * @param showState: 显示状态
     * @param id: 视频ID
     * @return
     */
    int changeShowState(@Param("showState") Boolean showState, @Param("id") String id);

    List<CourseVideo> videoList(CourseVideoSO so);

    int updateClickAmount(String id);
}
