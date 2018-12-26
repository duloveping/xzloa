package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.ExaminationQuestion;
import cn.com.enjoystudy.oa.bean.study.ExaminationQuestionItem;
import cn.com.enjoystudy.oa.bean.study.ExaminationQuestionSO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ExaminationQuestionServiceImpl implements ExaminationQuestionService {
    @Autowired
    private ExaminationQuestionService examinationQuestionService;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(ExaminationQuestion entity) {
        entity.preInsert();
        return examinationQuestionService.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(ExaminationQuestion entity) {
        entity.preUpdate();
        return examinationQuestionService.update(entity);
    }

    @Override
    public ExaminationQuestion getById(String id) {
        return examinationQuestionService.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return examinationQuestionService.deleteById(id);
    }

    @Override
    public List<ExaminationQuestion> list(ExaminationQuestionSO so) {
        return examinationQuestionService.list(so);
    }

    @Override
    public List<ExaminationQuestionItem> findItemsByQuestionId(String questionId) {
        return examinationQuestionService.findItemsByQuestionId(questionId);
    }

    @Override
    public int deleteByQuestionId(String questionId) {
        return examinationQuestionService.deleteByQuestionId(questionId);
    }

    @Override
    public String getAnalysis(String questionId) {
        return examinationQuestionService.getAnalysis(questionId);
    }
}
