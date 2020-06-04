package com.heyou.dao.flowmaster;

import com.heyou.entity.flowmaster.FlowMaster;
import com.heyou.entity.flowmaster.FlowMasterVO;
import com.heyou.entity.flowmaster.UserFlowMaster;
import com.heyou.entity.housebase.vo.JielvSourceData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author qiang.chao
 * @date 2020/3/6
 **/
@Repository
public interface UserFlowMasterDAO  extends Mapper<FlowMaster> {

    List<Map<String, Integer>> getAllBrokerUser();

    List<Map<String, Integer>> getMemberRecommends(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    /**
     * 插入流量表
     * @param superiorId :
     * @param userId :
     * @param i :
     * @param date :
     * @param date1 :
     * @return int :
     **/
    int insertFlowMaster(@Param("flowMasterId") Integer superiorId, @Param("flowId") Integer userId, @Param("state") int i, @Param("createDate") Date date, @Param("updateDate") Date date1);

    /**
     * 查找推荐人
     *
    **/
    Map<String, Integer> findReferrer(@Param("userId") Integer userId);

    /**
     * 查找流量主
     * @param userId :
     * @return com.heyou.entity.user.UserFlowMaster :
    **/
    List<UserFlowMaster> getFlowMasterByUserId(@Param("userId") Integer userId);

    /**
     * 查找流量主的子集
     * @param flowMasterId
     * @return
     */
    List<Integer> selectFlowByMaster(@Param("flowMasterId") Integer flowMasterId);

    /**
     * 当前用户是不是B(含大B小B)
     * @param userId :
     * @return int :
    **/
    int isBrokerRoleByUserId(Integer userId);

    /**
     * 当前用户是不是流量主（小B）
     * @param userId
     * @return
     */
    int isMinBrokerRoleByUserId(Integer userId);

    void insertFlowMasters(List<Map<String, Object>> valuesList);

    /**
     * 查询流量主的流量
     * @param flowMasterId
     * @param bindingTime
     * @return
     */
    List<FlowMasterVO> getFlowMasterFlow(@Param("flowMasterId") int flowMasterId, @Param("bindingTime") String bindingTime);

    /**
     * 根据流量主id 和流量id 查询出绑定时间
     * @param flowMasterId
     * @param flowId
     * @return
     */
    Date getFlowTime(@Param("flowMasterId") Integer flowMasterId, @Param("flowId") Integer flowId);

    List<Map<String, Integer>> getMemberRecommendsByDate(@Param("dateBegin") Date date, @Param("dateEnd") Date time);

    void updateMemberRecommend(@Param("superiorId") Integer superiorId, @Param("userId") Integer userId, @Param("testField") String testField, @Param("testField2") String testField2);

    Integer countMemberRecommend();
}
