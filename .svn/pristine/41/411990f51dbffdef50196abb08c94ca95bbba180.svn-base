package cn.com.enjoystudy.oa.service.sys;

import cn.com.enjoystudy.oa.bean.sys.SysSequence;
import cn.com.enjoystudy.oa.bean.sys.SysSequenceSO;
import cn.com.enjoystudy.oa.dao.sys.SysSequenceDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SysSequenceServiceImpl implements SysSequenceService {
    @Autowired
    private SysSequenceDao sysSequenceDao;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public Integer getSequenceValue(String code) {
        if (StringUtils.isBlank(code)) {
            throw new NullPointerException("code is null.");
        }
        SysSequenceSO so = new SysSequenceSO();
        so.setSeqCode(code);

        Integer value = 0;
        List<SysSequence> list = sysSequenceDao.list(so);
        if (null != list && list.size() > 0) {
            SysSequence sequence = list.get(0);
            value = sequence.getSeqValue();
            sequence.setSeqValue(sequence.getSeqValue() + 1);
            sequence.preUpdate();
            sysSequenceDao.update(sequence);
        } else {
            SysSequence sequence = new SysSequence();
            sequence.setSeqValue(value + 1);
            sequence.preInsert();
            sysSequenceDao.insert(sequence);
        }
        return value;
    }

    @Override
    public String getSequenceValue(String code, int digit) {
        Integer val = getSequenceValue(code);
        return fillZero(val.toString(), digit);
    }

    @Override
    public String getYearSeqVal(String enname, int digit) {
        String date = DateFormatUtils.format(new Date(), "yyyy");
        String code = (enname + "_" + date).toUpperCase();
        Integer val = getSequenceValue(code);
        return date + fillZero(val.toString(), digit);
    }

    @Override
    public String getMonthSeqVal(String enname, int digit) {
        String date = DateFormatUtils.format(new Date(), "yyyyMM");
        String code = (enname + "_" + date).toUpperCase();
        Integer val = getSequenceValue(code);
        return date + fillZero(val.toString(), digit);
    }

    @Override
    public String getDateSeqVal(String enname, int digit) {
        String date = DateFormatUtils.format(new Date(), "yyyyMMdd");
        String code = (enname + "_" + date).toUpperCase();
        Integer val = getSequenceValue(code);
        return date + fillZero(val.toString(), digit);
    }


    /**
     * 填充零（最多能填充50个0）
     * @param num
     * @param digit
     * @return
     */
    public static String fillZero(String num,int digit){
        if(num.length() < digit){
            // 最多这么50位
            String zero = "00000000000000000000000000000000000000000000000000";
            String str = zero.substring(0,digit-num.length()) + num;
            return str;
        }
        return num;
    }

}
