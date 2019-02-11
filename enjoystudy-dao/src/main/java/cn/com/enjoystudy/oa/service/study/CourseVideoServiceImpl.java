package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseAttachmentSO;
import cn.com.enjoystudy.oa.bean.study.CourseVideo;
import cn.com.enjoystudy.oa.bean.study.CourseVideoSO;
import cn.com.enjoystudy.oa.dao.study.CourseAttachmentDao;
import cn.com.enjoystudy.oa.dao.study.CourseVideoDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CourseVideoServiceImpl implements CourseVideoService {
    @Autowired
    private CourseVideoDao courseVideoDao;
    @Autowired
    private CourseAttachmentDao courseAttachmentDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(CourseVideo entity) {
        entity.preInsert();
        return courseVideoDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(CourseVideo entity) {
        entity.preUpdate();
        return courseVideoDao.update(entity);
    }

    @Override
    public CourseVideo getById(String id) {
        return courseVideoDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        CourseAttachmentSO attachmentSO = new CourseAttachmentSO();
        attachmentSO.setVideoId(id);
        courseAttachmentDao.delete(attachmentSO);
        return courseVideoDao.deleteById(id);
    }

    @Override
    public List<CourseVideo> list(CourseVideoSO so) {
        return courseVideoDao.list(so);
    }

    @Override
    public long getCount(CourseVideoSO so) {
        return courseVideoDao.getCount(so);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int changeShowState(Boolean showState, String id) {
        if (null == showState) {
            throw new NullPointerException("showState is null.");
        }
        if (StringUtils.isBlank(id)) {
            throw new NullPointerException("id is null.");
        }
        return courseVideoDao.changeShowState(showState, id);
    }

    @Override
    public List<CourseVideo> videoList(CourseVideoSO so) {
        return courseVideoDao.videoList(so);
    }

    @Override
    public PageInfo<CourseVideo> findVideoPage(CourseVideoSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<CourseVideo> pageInfo = new PageInfo(courseVideoDao.videoList(so));
        return pageInfo;
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int updateClickAmount(String id) {
        if (StringUtils.isBlank(id)) {
            throw new NullPointerException("id is null.");
        }
        return courseVideoDao.updateClickAmount(id);
    }
}
