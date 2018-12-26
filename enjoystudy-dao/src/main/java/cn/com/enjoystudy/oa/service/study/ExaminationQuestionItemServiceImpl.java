package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.ExaminationQuestionItem;
import cn.com.enjoystudy.oa.bean.study.ExaminationQuestionItemSO;
import cn.com.enjoystudy.oa.dao.study.ExaminationQuestionItemDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExaminationQuestionItemServiceImpl implements ExaminationQuestionItemService {
    @Autowired
    private ExaminationQuestionItemDao examinationQuestionItemDao;

    @Override
    public int insert(ExaminationQuestionItem entity) {
        entity.preInsert();
        return examinationQuestionItemDao.insert(entity);
    }

    @Override
    public int update(ExaminationQuestionItem entity) {
        entity.preUpdate();
        return examinationQuestionItemDao.update(entity);
    }

    @Override
    public ExaminationQuestionItem getById(String id) {
        return examinationQuestionItemDao.getById(id);
    }

    @Override
    public int deleteById(String id) {
        return examinationQuestionItemDao.deleteById(id);
    }

    @Override
    public List<ExaminationQuestionItem> list(ExaminationQuestionItemSO so) {
        return examinationQuestionItemDao.list(so);
    }

    @Override
    public int deleteByQuestionId(String questionId) {
        return examinationQuestionItemDao.deleteByQuestionId(questionId);
    }
}
