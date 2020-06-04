package com.heyou.entity.flowmaster;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: zxe
 * @Time: 2020/4/9 17:56
 * @Version: 1.0
 */
@Data
public class FlowMasterVO implements Serializable {

    private String nickname;
    private Date bindingTime;
    private String phoneNumber;
    private String headPortrait;

}
