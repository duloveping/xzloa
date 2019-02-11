package cn.com.enjoystudy.oa.service.web;

import cn.com.enjoystudy.oa.bean.web.AdvertisementPlace;
import cn.com.enjoystudy.oa.bean.web.AdvertisementPlaceSO;
import cn.com.enjoystudy.oa.dao.web.AdvertisementPlaceDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class AdvertisementPlaceServiceImpl implements AdvertisementPlaceService {
    @Autowired
    private AdvertisementPlaceDao advertisementPlaceDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(AdvertisementPlace entity) {
        entity.preInsert();
        return advertisementPlaceDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(AdvertisementPlace entity) {
        entity.preUpdate();
        return advertisementPlaceDao.update(entity);
    }

    @Override
    public AdvertisementPlace getById(String id) {
        if (StringUtils.isBlank(id)) {
            throw new NullPointerException("id is null.");
        }
        return advertisementPlaceDao.getById(StringUtils.trim(id));
    }

    @Override
    public AdvertisementPlace getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            throw new NullPointerException("code is null.");
        }
        return advertisementPlaceDao.getByCode(StringUtils.trim(code));
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return advertisementPlaceDao.deleteById(id);
    }

    @Override
    public List<AdvertisementPlace> list(AdvertisementPlaceSO so) {
        return advertisementPlaceDao.list(so);
    }

    @Override
    public long count(AdvertisementPlaceSO so) {
        return advertisementPlaceDao.count(so);
    }

    @Override
    public PageInfo<AdvertisementPlace> findPag(AdvertisementPlaceSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<AdvertisementPlace> pageInfo = new PageInfo(advertisementPlaceDao.list(so));
        return pageInfo;
    }
}
