package com.heyou.entity.flowmaster;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qiang.chao
 * @date 2020/3/6
 **/
@Data
public class UserFlowMaster implements Serializable {

    private static final long serialVersionUID = 7114039330671716126L;


    private Integer userId;

    private Integer flowMasterId;
}
