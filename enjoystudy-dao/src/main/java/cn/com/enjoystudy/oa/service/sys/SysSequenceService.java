package cn.com.enjoystudy.oa.service.sys;

import cn.com.enjoystudy.oa.bean.sys.SysSequence;

public interface SysSequenceService {
    int insert(SysSequence entity);

    int update(SysSequence entity);

    SysSequence getSequenceValue(String code);

//    String getSequenceValue(String code, int digit);
//
//    String getYearSeqVal(String enname, int digit);
//
//    String getMonthSeqVal(String enname, int digit);
//
//    String getDateSeqVal(String enname, int digit);

    String fillZero(String num,int digit);
}
