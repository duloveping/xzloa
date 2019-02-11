package cn.com.enjoystudy.oa.service.web;

import cn.com.enjoystudy.oa.bean.web.NewsType;
import cn.com.enjoystudy.oa.bean.web.NewsTypeSO;
import cn.com.enjoystudy.oa.dao.web.NewsTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class NewsTypeServiceImpl implements NewsTypeService {
    @Autowired
    private NewsTypeDao newsTypeDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(NewsType entity) {
        entity.preInsert();
        return newsTypeDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(NewsType entity) {
        entity.preUpdate();
        return newsTypeDao.update(entity);
    }

    @Override
    public NewsType getById(String id) {
        return newsTypeDao.getById(id);
    }

    @Override
    public NewsType getByCode(String code) {
        return newsTypeDao.getByCode(code);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return newsTypeDao.deleteById(id);
    }

    @Override
    public List<NewsType> list(NewsTypeSO so) {
        return newsTypeDao.list(so);
    }

    @Override
    public List<NewsType> recursionFindMenu(NewsTypeSO so, List<NewsType> types) {
        List<NewsType> list = newsTypeDao.list(so);
        if (null != list && list.size() > 0) {
            for (NewsType type : list) {
                types.add(type);
                so.setParentId(type.getId());
                recursionFindMenu(so, types);
            }
        }
        return types;
    }
}
