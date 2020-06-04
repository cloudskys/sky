package com.heyou.dao.houseorder;

import com.heyou.entity.houseorder.po.ExceptionRecord;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface ExceptionRecordDao extends Mapper<ExceptionRecord> {
    public  int insertExceptionRecord(ExceptionRecord exceptionRecord);
}
