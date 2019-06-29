package cn.com.enjoystudy.oa.service.study;

import cn.com.enjoystudy.oa.bean.study.CourseType;
import cn.com.enjoystudy.oa.bean.study.CourseTypeSO;
import cn.com.enjoystudy.oa.dao.study.CourseTypeDao;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CourseTypeServiceImpl implements CourseTypeService {
    @Autowired
    private CourseTypeDao courseTypeDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insert(CourseType entity) {
        entity.preInsert();
        return courseTypeDao.insert(entity);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int update(CourseType entity) {
        entity.preUpdate();
        return courseTypeDao.update(entity);
    }

    @Override
    public CourseType getById(String id) {
        return courseTypeDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int deleteById(String id) {
        return courseTypeDao.deleteById(id);
    }

    @Override
    public List<CourseType> list(CourseTypeSO so) {
        return courseTypeDao.list(so);
    }

    @Override
    public long count(CourseTypeSO so) {
        return courseTypeDao.count(so);
    }

    @Override
    public JSONArray listToJsonArray(List<CourseType> types) {
        JSONArray array = new JSONArray();
        if (null != types && types.size() > 0) {
            for (CourseType bean : types) {
                JSONObject obj = new JSONObject();
                obj.put("id", bean.getId());
                obj.put("code", bean.getCode());
                obj.put("name", bean.getName());
                if (StringUtils.isNotBlank(bean.getParentId())) {
                    obj.put("parentId", bean.getParentId());
                } else {
                    obj.put("parentId", "0");
                }
                array.add(obj);
            }
        }
        return array;
    }

    @Override
    public List<CourseType> tree(CourseTypeSO so, List<CourseType> types) {
        List<CourseType> list = courseTypeDao.list(so);
        if (null != list && list.size() > 0) {
            for (CourseType type : list) {
                types.add(type);

                CourseTypeSO typeSO = new CourseTypeSO();
                typeSO.setParentId(type.getId());
                tree(typeSO, types);
            }
        }
        return types;
    }

    @Override
    public List<CourseType> findRecursive(CourseTypeSO so) {
        return courseTypeDao.findRecursive(so);
    }
}
