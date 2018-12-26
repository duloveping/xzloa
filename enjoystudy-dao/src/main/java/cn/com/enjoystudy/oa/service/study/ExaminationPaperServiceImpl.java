package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.ExaminationPaper;
import cn.com.enjoystudy.oa.bean.study.ExaminationPaperSO;
import cn.com.enjoystudy.oa.dao.study.ExaminationPaperDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ExaminationPaperServiceImpl implements ExaminationPaperService {
    @Autowired
    private ExaminationPaperDao examinationPaperDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(ExaminationPaper entity) {
        entity.preInsert();
        return examinationPaperDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(ExaminationPaper entity) {
        entity.preUpdate();
        return examinationPaperDao.update(entity);
    }

    @Override
    public ExaminationPaper getById(String id) {
        return examinationPaperDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return examinationPaperDao.deleteById(id);
    }

    @Override
    public List<ExaminationPaper> list(ExaminationPaperSO so) {
        return examinationPaperDao.list(so);
    }

    @Override
    public PageInfo<ExaminationPaper> findPag(ExaminationPaperSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<ExaminationPaper> pageInfo = new PageInfo(examinationPaperDao.list(so));
        return pageInfo;
    }
}
