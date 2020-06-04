package com.heyou.dao.sms;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: task
 * @description
 * @author: hjl
 * @create: 2020-03-11 16:18
 **/
@Repository
public interface NewsCoreDao {

    int updateNewsCoreToInvalid(@Param("date")String date);
}
