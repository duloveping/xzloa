package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseAttachment;
import cn.com.enjoystudy.oa.bean.study.CourseAttachmentSO;
import cn.com.enjoystudy.oa.dao.study.CourseAttachmentDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CourseAttachmentServiceImpl implements CourseAttachmentService {
    @Autowired
    private CourseAttachmentDao courseAttachmentDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(CourseAttachment entity) {
        entity.preInsert();
        return courseAttachmentDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(CourseAttachment entity) {
        entity.preUpdate();
        return courseAttachmentDao.update(entity);
    }

    @Override
    public CourseAttachment getById(String id) {
        return courseAttachmentDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return courseAttachmentDao.deleteById(id);
    }

    @Override
    public List<CourseAttachment> list(CourseAttachmentSO so) {
        return courseAttachmentDao.list(so);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int delete(CourseAttachmentSO so) {
        return courseAttachmentDao.delete(so);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByVideoId(String videoId) {
        if (StringUtils.isBlank(videoId)) {
            throw new NullPointerException("videoId is null.");
        }
        return courseAttachmentDao.deleteByVideoId(videoId);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteByCourseId(String courseId) {
        if (StringUtils.isBlank(courseId)) {
            throw new NullPointerException("courseId is null.");
        }
        return courseAttachmentDao.deleteByCourseId(courseId);
    }
}
