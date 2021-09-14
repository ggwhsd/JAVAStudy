package com.example.demo.db;

import com.example.demo.db.orderReqSpeedBean;
import com.example.demo.db.orderReqSpeedBeanExample;
import com.example.demo.entity.OrderSpeedDateSum;

import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface orderReqSpeedBeanMapper {
    @SelectProvider(type=orderReqSpeedBeanSqlProvider.class, method="countByExample")
    long countByExample(orderReqSpeedBeanExample example);

    @DeleteProvider(type=orderReqSpeedBeanSqlProvider.class, method="deleteByExample")
    int deleteByExample(orderReqSpeedBeanExample example);

    @Insert({
        "insert into staordvolbyid (ActionDate, InstrumentID, ",
        "Order_volume, Sec_volume, ",
        "Sec_max_volume, Order_ref, ",
        "Sec_min_volume)",
        "values (#{actiondate,jdbcType=VARCHAR}, #{instrumentid,jdbcType=VARCHAR}, ",
        "#{orderVolume,jdbcType=DOUBLE}, #{secVolume,jdbcType=DOUBLE}, ",
        "#{secMaxVolume,jdbcType=DOUBLE}, #{orderRef,jdbcType=VARCHAR}, ",
        "#{secMinVolume,jdbcType=DOUBLE})"
    })
    int insert(orderReqSpeedBean record);

    @InsertProvider(type=orderReqSpeedBeanSqlProvider.class, method="insertSelective")
    int insertSelective(orderReqSpeedBean record);

    @SelectProvider(type=orderReqSpeedBeanSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ActionDate", property="actiondate", jdbcType=JdbcType.VARCHAR),
        @Result(column="InstrumentID", property="instrumentid", jdbcType=JdbcType.VARCHAR),
        @Result(column="Order_volume", property="orderVolume", jdbcType=JdbcType.DOUBLE),
        @Result(column="Sec_volume", property="secVolume", jdbcType=JdbcType.DOUBLE),
        @Result(column="Sec_max_volume", property="secMaxVolume", jdbcType=JdbcType.DOUBLE),
        @Result(column="Order_ref", property="orderRef", jdbcType=JdbcType.VARCHAR),
        @Result(column="Sec_min_volume", property="secMinVolume", jdbcType=JdbcType.DOUBLE)
    })
    List<orderReqSpeedBean> selectByExample(orderReqSpeedBeanExample example);

    @UpdateProvider(type=orderReqSpeedBeanSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") orderReqSpeedBean record, @Param("example") orderReqSpeedBeanExample example);

    @UpdateProvider(type=orderReqSpeedBeanSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") orderReqSpeedBean record, @Param("example") orderReqSpeedBeanExample example);
    
    @Select({"select sum(Order_volume) as SumOrder from staordvolbyid where ActionDate = #{actionDay,jdbcType=VARCHAR}"})
	String selectSumByactionDay(String actionDay);
    
    @Select({"select sum(Order_volume) as SumOrder, ActionDate as ActionDay from staordvolbyid where ActionDate between #{beginactionDay,jdbcType=VARCHAR} and #{endactionDay,jdbcType=VARCHAR} group by  ActionDate"})
	List<OrderSpeedDateSum> selectSumBetweenActionDayRange(String beginactionDay,String endactionDay);
    
    
    
}