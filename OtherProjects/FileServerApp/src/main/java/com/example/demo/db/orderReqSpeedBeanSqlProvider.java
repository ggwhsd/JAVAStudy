package com.example.demo.db;

import com.example.demo.db.orderReqSpeedBean;
import com.example.demo.db.orderReqSpeedBeanExample.Criteria;
import com.example.demo.db.orderReqSpeedBeanExample.Criterion;
import com.example.demo.db.orderReqSpeedBeanExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

public class orderReqSpeedBeanSqlProvider {
    public String countByExample(orderReqSpeedBeanExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("staordvolbyid");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(orderReqSpeedBeanExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("staordvolbyid");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(orderReqSpeedBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("staordvolbyid");
        
        if (record.getActiondate() != null) {
            sql.VALUES("ActionDate", "#{actiondate,jdbcType=VARCHAR}");
        }
        
        if (record.getInstrumentid() != null) {
            sql.VALUES("InstrumentID", "#{instrumentid,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderVolume() != null) {
            sql.VALUES("Order_volume", "#{orderVolume,jdbcType=DOUBLE}");
        }
        
        if (record.getSecVolume() != null) {
            sql.VALUES("Sec_volume", "#{secVolume,jdbcType=DOUBLE}");
        }
        
        if (record.getSecMaxVolume() != null) {
            sql.VALUES("Sec_max_volume", "#{secMaxVolume,jdbcType=DOUBLE}");
        }
        
        if (record.getOrderRef() != null) {
            sql.VALUES("Order_ref", "#{orderRef,jdbcType=VARCHAR}");
        }
        
        if (record.getSecMinVolume() != null) {
            sql.VALUES("Sec_min_volume", "#{secMinVolume,jdbcType=DOUBLE}");
        }
        
        return sql.toString();
    }

    public String selectByExample(orderReqSpeedBeanExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ActionDate");
        } else {
            sql.SELECT("ActionDate");
        }
        sql.SELECT("InstrumentID");
        sql.SELECT("Order_volume");
        sql.SELECT("Sec_volume");
        sql.SELECT("Sec_max_volume");
        sql.SELECT("Order_ref");
        sql.SELECT("Sec_min_volume");
        sql.FROM("staordvolbyid");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }
    
    
	

    public String updateByExampleSelective(Map<String, Object> parameter) {
        orderReqSpeedBean record = (orderReqSpeedBean) parameter.get("record");
        orderReqSpeedBeanExample example = (orderReqSpeedBeanExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("staordvolbyid");
        
        if (record.getActiondate() != null) {
            sql.SET("ActionDate = #{record.actiondate,jdbcType=VARCHAR}");
        }
        
        if (record.getInstrumentid() != null) {
            sql.SET("InstrumentID = #{record.instrumentid,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderVolume() != null) {
            sql.SET("Order_volume = #{record.orderVolume,jdbcType=DOUBLE}");
        }
        
        if (record.getSecVolume() != null) {
            sql.SET("Sec_volume = #{record.secVolume,jdbcType=DOUBLE}");
        }
        
        if (record.getSecMaxVolume() != null) {
            sql.SET("Sec_max_volume = #{record.secMaxVolume,jdbcType=DOUBLE}");
        }
        
        if (record.getOrderRef() != null) {
            sql.SET("Order_ref = #{record.orderRef,jdbcType=VARCHAR}");
        }
        
        if (record.getSecMinVolume() != null) {
            sql.SET("Sec_min_volume = #{record.secMinVolume,jdbcType=DOUBLE}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("staordvolbyid");
        
        sql.SET("ActionDate = #{record.actiondate,jdbcType=VARCHAR}");
        sql.SET("InstrumentID = #{record.instrumentid,jdbcType=VARCHAR}");
        sql.SET("Order_volume = #{record.orderVolume,jdbcType=DOUBLE}");
        sql.SET("Sec_volume = #{record.secVolume,jdbcType=DOUBLE}");
        sql.SET("Sec_max_volume = #{record.secMaxVolume,jdbcType=DOUBLE}");
        sql.SET("Order_ref = #{record.orderRef,jdbcType=VARCHAR}");
        sql.SET("Sec_min_volume = #{record.secMinVolume,jdbcType=DOUBLE}");
        
        orderReqSpeedBeanExample example = (orderReqSpeedBeanExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    protected void applyWhere(SQL sql, orderReqSpeedBeanExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}