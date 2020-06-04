package com.heyou.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/22 13:31
 * @Version: 1.0
 */
public class CardAge {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 18位身份证获取性别和年龄
     * @param CardCode
     * @return
     * @throws Exception
     */
    public static Map<String, Object> identityCard18(String CardCode) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        // 得到年份
        String year = CardCode.substring(6).substring(0, 4);
        // 得到月份
        String month = CardCode.substring(10).substring(0, 2);
        //得到日
        //String day=CardCode.substring(12).substring(0,2);
        int sex;
        // 判断性别 1. 男 2. 女
        if (Integer.parseInt(CardCode.substring(16).substring(0, 1)) % 2 == 0) {
            sex = 2;
        } else {
            sex = 1;
        }
        // 得到当前的系统时间
        Date date = new Date();
        // 当前年份
        String currentYear = format.format(date).substring(0, 4);
        // 月份
        String currentMonth = format.format(date).substring(5, 7);
        //String currentdDay=format.format(date).substring(8,10);
        int age = 0;
        // 当前月份大于用户出身的月份表示已过生日
        if (Integer.parseInt(month) <= Integer.parseInt(currentMonth)) {
            age = Integer.parseInt(currentYear) - Integer.parseInt(year) + 1;
        } else {
            // 当前用户还没过生日
            age = Integer.parseInt(currentYear) - Integer.parseInt(year);
        }
        map.put("sex", sex);
        map.put("age", age);
        return map;
    }

    /**
     * 15位身份证获取性别和年龄
     * @param card
     * @return
     * @throws Exception
     */
    public static Map<String, Object> identityCard15(String card) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        //年份
        String year = "19" + card.substring(6, 8);
        //月份
        String yue = card.substring(8, 10);
        //日
        //String day=card.substring(10, 12);
        int sex = 0;
        if (Integer.parseInt(card.substring(14, 15)) % 2 == 0) {
            sex = 2;
        } else {
            sex = 1;
        }
        // 得到当前的系统时间
        Date date = new Date();
        //当前年份
        String currentYear = format.format(date).substring(0, 4);
        //月份
        String currentMonth = format.format(date).substring(5, 7);
        //String fday=format.format(date).substring(8,10);
        int age = 0;
        //当前月份大于用户出身的月份表示已过生日
        if (Integer.parseInt(yue) <= Integer.parseInt(currentMonth)) {
            age = Integer.parseInt(currentYear) - Integer.parseInt(year) + 1;
        } else {
            // 当前用户还没过生日
            age = Integer.parseInt(currentYear) - Integer.parseInt(year);
        }
        map.put("sex", sex);
        map.put("age", age);
        return map;
    }

}
