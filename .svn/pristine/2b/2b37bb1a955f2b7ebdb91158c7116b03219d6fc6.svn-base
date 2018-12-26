package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.StorePaper;
import cn.com.enjoystudy.oa.bean.study.StorePaperSO;
import cn.com.enjoystudy.oa.dao.study.StorePaperDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class StorePaperServiceImpl implements StorePaperService {
    @Autowired
    private StorePaperDao storePaperDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(StorePaper entity) {
        entity.preInsert();
        return storePaperDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(StorePaper entity) {
        entity.preUpdate();
        return storePaperDao.update(entity);
    }

    @Override
    public StorePaper getById(String id) {
        return storePaperDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return storePaperDao.deleteById(id);
    }

    @Override
    public List<StorePaper> list(StorePaperSO so) {
        return storePaperDao.list(so);
    }

    @Override
    public long count(StorePaperSO so) {
        return storePaperDao.count(so);
    }

    @Override
    public PageInfo<StorePaper> findPag(StorePaperSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<StorePaper> pageInfo = new PageInfo(storePaperDao.list(so));
        return pageInfo;
    }
}
