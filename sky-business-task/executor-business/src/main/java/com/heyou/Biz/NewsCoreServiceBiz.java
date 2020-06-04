package com.heyou.Biz;

import com.heyou.dao.sms.NewsCoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: task
 * @description
 * @author: hjl
 * @create: 2020-03-11 16:18
 **/
@Component
public class NewsCoreServiceBiz {

    @Autowired
    private NewsCoreDao newsCoreDao;

    public int updateNewsCoreToInvalid(String date){
        return newsCoreDao.updateNewsCoreToInvalid(date);
    }
}
