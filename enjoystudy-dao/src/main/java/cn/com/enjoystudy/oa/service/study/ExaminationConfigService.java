package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.ExaminationConfig;
import cn.com.enjoystudy.oa.bean.study.ExaminationConfigSO;

import java.util.List;

public interface ExaminationConfigService {
    int insert(ExaminationConfig entity);

    int update(ExaminationConfig entity);

    ExaminationConfig getById(String id);

    int deleteById(String id);

    List<ExaminationConfig> list(ExaminationConfigSO so);
}
