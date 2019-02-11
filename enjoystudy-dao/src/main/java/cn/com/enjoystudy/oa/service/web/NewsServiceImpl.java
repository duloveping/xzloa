package cn.com.enjoystudy.oa.service.web;

import cn.com.enjoystudy.oa.bean.web.News;
import cn.com.enjoystudy.oa.bean.web.NewsSO;
import cn.com.enjoystudy.oa.dao.web.NewsDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(News entity) {
        entity.preInsert();
        return newsDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(News entity) {
        entity.preUpdate();
        return newsDao.update(entity);
    }

    @Override
    public News getById(String id) {
        return newsDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return newsDao.deleteById(id);
    }

    @Override
    public List<News> list(NewsSO so) {
        return newsDao.list(so);
    }

    @Override
    public PageInfo<News> findPage(NewsSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<News> pageInfo = new PageInfo(newsDao.list(so));
        return pageInfo;
    }
}
