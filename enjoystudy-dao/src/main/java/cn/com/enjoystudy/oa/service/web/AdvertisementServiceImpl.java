package cn.com.enjoystudy.oa.service.web;

import cn.com.enjoystudy.oa.bean.web.Advertisement;
import cn.com.enjoystudy.oa.bean.web.AdvertisementPlace;
import cn.com.enjoystudy.oa.bean.web.AdvertisementSO;
import cn.com.enjoystudy.oa.dao.web.AdvertisementDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementDao advertisementDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(Advertisement entity) {
        entity.preInsert();
        return advertisementDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(Advertisement entity) {
        entity.preUpdate();
        return advertisementDao.update(entity);
    }

    @Override
    public Advertisement getById(String id) {
        return advertisementDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return advertisementDao.deleteById(id);
    }

    @Override
    public List<Advertisement> list(AdvertisementSO so) {
        return advertisementDao.list(so);
    }

    @Override
    public PageInfo<Advertisement> findPag(AdvertisementSO so) {
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        PageInfo<Advertisement> pageInfo = new PageInfo(advertisementDao.list(so));
        return pageInfo;
    }
}
