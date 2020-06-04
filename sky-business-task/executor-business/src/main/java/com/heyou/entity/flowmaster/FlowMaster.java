package com.heyou.entity.flowmaster;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author qiang.chao
 * @date 2020/3/6
 **/
@Data
public class FlowMaster implements Serializable {

    private static final long serialVersionUID = 8481169859315558609L;

    @Id
    private Integer id;

    private Integer flowMasterId;

    private Integer flowId;

    private Integer state;

    private Date validDate;

    private Date createDate;

    private Date updateDate;
}
