package com.example.demo.db;

import java.util.ArrayList;
import java.util.List;

public class orderReqSpeedBeanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public orderReqSpeedBeanExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andActiondateIsNull() {
            addCriterion("ActionDate is null");
            return (Criteria) this;
        }

        public Criteria andActiondateIsNotNull() {
            addCriterion("ActionDate is not null");
            return (Criteria) this;
        }

        public Criteria andActiondateEqualTo(String value) {
            addCriterion("ActionDate =", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateNotEqualTo(String value) {
            addCriterion("ActionDate <>", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateGreaterThan(String value) {
            addCriterion("ActionDate >", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateGreaterThanOrEqualTo(String value) {
            addCriterion("ActionDate >=", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateLessThan(String value) {
            addCriterion("ActionDate <", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateLessThanOrEqualTo(String value) {
            addCriterion("ActionDate <=", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateLike(String value) {
            addCriterion("ActionDate like", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateNotLike(String value) {
            addCriterion("ActionDate not like", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateIn(List<String> values) {
            addCriterion("ActionDate in", values, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateNotIn(List<String> values) {
            addCriterion("ActionDate not in", values, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateBetween(String value1, String value2) {
            addCriterion("ActionDate between", value1, value2, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateNotBetween(String value1, String value2) {
            addCriterion("ActionDate not between", value1, value2, "actiondate");
            return (Criteria) this;
        }

        public Criteria andInstrumentidIsNull() {
            addCriterion("InstrumentID is null");
            return (Criteria) this;
        }

        public Criteria andInstrumentidIsNotNull() {
            addCriterion("InstrumentID is not null");
            return (Criteria) this;
        }

        public Criteria andInstrumentidEqualTo(String value) {
            addCriterion("InstrumentID =", value, "instrumentid");
            return (Criteria) this;
        }

        public Criteria andInstrumentidNotEqualTo(String value) {
            addCriterion("InstrumentID <>", value, "instrumentid");
            return (Criteria) this;
        }

        public Criteria andInstrumentidGreaterThan(String value) {
            addCriterion("InstrumentID >", value, "instrumentid");
            return (Criteria) this;
        }

        public Criteria andInstrumentidGreaterThanOrEqualTo(String value) {
            addCriterion("InstrumentID >=", value, "instrumentid");
            return (Criteria) this;
        }

        public Criteria andInstrumentidLessThan(String value) {
            addCriterion("InstrumentID <", value, "instrumentid");
            return (Criteria) this;
        }

        public Criteria andInstrumentidLessThanOrEqualTo(String value) {
            addCriterion("InstrumentID <=", value, "instrumentid");
            return (Criteria) this;
        }

        public Criteria andInstrumentidLike(String value) {
            addCriterion("InstrumentID like", value, "instrumentid");
            return (Criteria) this;
        }

        public Criteria andInstrumentidNotLike(String value) {
            addCriterion("InstrumentID not like", value, "instrumentid");
            return (Criteria) this;
        }

        public Criteria andInstrumentidIn(List<String> values) {
            addCriterion("InstrumentID in", values, "instrumentid");
            return (Criteria) this;
        }

        public Criteria andInstrumentidNotIn(List<String> values) {
            addCriterion("InstrumentID not in", values, "instrumentid");
            return (Criteria) this;
        }

        public Criteria andInstrumentidBetween(String value1, String value2) {
            addCriterion("InstrumentID between", value1, value2, "instrumentid");
            return (Criteria) this;
        }

        public Criteria andInstrumentidNotBetween(String value1, String value2) {
            addCriterion("InstrumentID not between", value1, value2, "instrumentid");
            return (Criteria) this;
        }

        public Criteria andOrderVolumeIsNull() {
            addCriterion("Order_volume is null");
            return (Criteria) this;
        }

        public Criteria andOrderVolumeIsNotNull() {
            addCriterion("Order_volume is not null");
            return (Criteria) this;
        }

        public Criteria andOrderVolumeEqualTo(Double value) {
            addCriterion("Order_volume =", value, "orderVolume");
            return (Criteria) this;
        }

        public Criteria andOrderVolumeNotEqualTo(Double value) {
            addCriterion("Order_volume <>", value, "orderVolume");
            return (Criteria) this;
        }

        public Criteria andOrderVolumeGreaterThan(Double value) {
            addCriterion("Order_volume >", value, "orderVolume");
            return (Criteria) this;
        }

        public Criteria andOrderVolumeGreaterThanOrEqualTo(Double value) {
            addCriterion("Order_volume >=", value, "orderVolume");
            return (Criteria) this;
        }

        public Criteria andOrderVolumeLessThan(Double value) {
            addCriterion("Order_volume <", value, "orderVolume");
            return (Criteria) this;
        }

        public Criteria andOrderVolumeLessThanOrEqualTo(Double value) {
            addCriterion("Order_volume <=", value, "orderVolume");
            return (Criteria) this;
        }

        public Criteria andOrderVolumeIn(List<Double> values) {
            addCriterion("Order_volume in", values, "orderVolume");
            return (Criteria) this;
        }

        public Criteria andOrderVolumeNotIn(List<Double> values) {
            addCriterion("Order_volume not in", values, "orderVolume");
            return (Criteria) this;
        }

        public Criteria andOrderVolumeBetween(Double value1, Double value2) {
            addCriterion("Order_volume between", value1, value2, "orderVolume");
            return (Criteria) this;
        }

        public Criteria andOrderVolumeNotBetween(Double value1, Double value2) {
            addCriterion("Order_volume not between", value1, value2, "orderVolume");
            return (Criteria) this;
        }

        public Criteria andSecVolumeIsNull() {
            addCriterion("Sec_volume is null");
            return (Criteria) this;
        }

        public Criteria andSecVolumeIsNotNull() {
            addCriterion("Sec_volume is not null");
            return (Criteria) this;
        }

        public Criteria andSecVolumeEqualTo(Double value) {
            addCriterion("Sec_volume =", value, "secVolume");
            return (Criteria) this;
        }

        public Criteria andSecVolumeNotEqualTo(Double value) {
            addCriterion("Sec_volume <>", value, "secVolume");
            return (Criteria) this;
        }

        public Criteria andSecVolumeGreaterThan(Double value) {
            addCriterion("Sec_volume >", value, "secVolume");
            return (Criteria) this;
        }

        public Criteria andSecVolumeGreaterThanOrEqualTo(Double value) {
            addCriterion("Sec_volume >=", value, "secVolume");
            return (Criteria) this;
        }

        public Criteria andSecVolumeLessThan(Double value) {
            addCriterion("Sec_volume <", value, "secVolume");
            return (Criteria) this;
        }

        public Criteria andSecVolumeLessThanOrEqualTo(Double value) {
            addCriterion("Sec_volume <=", value, "secVolume");
            return (Criteria) this;
        }

        public Criteria andSecVolumeIn(List<Double> values) {
            addCriterion("Sec_volume in", values, "secVolume");
            return (Criteria) this;
        }

        public Criteria andSecVolumeNotIn(List<Double> values) {
            addCriterion("Sec_volume not in", values, "secVolume");
            return (Criteria) this;
        }

        public Criteria andSecVolumeBetween(Double value1, Double value2) {
            addCriterion("Sec_volume between", value1, value2, "secVolume");
            return (Criteria) this;
        }

        public Criteria andSecVolumeNotBetween(Double value1, Double value2) {
            addCriterion("Sec_volume not between", value1, value2, "secVolume");
            return (Criteria) this;
        }

        public Criteria andSecMaxVolumeIsNull() {
            addCriterion("Sec_max_volume is null");
            return (Criteria) this;
        }

        public Criteria andSecMaxVolumeIsNotNull() {
            addCriterion("Sec_max_volume is not null");
            return (Criteria) this;
        }

        public Criteria andSecMaxVolumeEqualTo(Double value) {
            addCriterion("Sec_max_volume =", value, "secMaxVolume");
            return (Criteria) this;
        }

        public Criteria andSecMaxVolumeNotEqualTo(Double value) {
            addCriterion("Sec_max_volume <>", value, "secMaxVolume");
            return (Criteria) this;
        }

        public Criteria andSecMaxVolumeGreaterThan(Double value) {
            addCriterion("Sec_max_volume >", value, "secMaxVolume");
            return (Criteria) this;
        }

        public Criteria andSecMaxVolumeGreaterThanOrEqualTo(Double value) {
            addCriterion("Sec_max_volume >=", value, "secMaxVolume");
            return (Criteria) this;
        }

        public Criteria andSecMaxVolumeLessThan(Double value) {
            addCriterion("Sec_max_volume <", value, "secMaxVolume");
            return (Criteria) this;
        }

        public Criteria andSecMaxVolumeLessThanOrEqualTo(Double value) {
            addCriterion("Sec_max_volume <=", value, "secMaxVolume");
            return (Criteria) this;
        }

        public Criteria andSecMaxVolumeIn(List<Double> values) {
            addCriterion("Sec_max_volume in", values, "secMaxVolume");
            return (Criteria) this;
        }

        public Criteria andSecMaxVolumeNotIn(List<Double> values) {
            addCriterion("Sec_max_volume not in", values, "secMaxVolume");
            return (Criteria) this;
        }

        public Criteria andSecMaxVolumeBetween(Double value1, Double value2) {
            addCriterion("Sec_max_volume between", value1, value2, "secMaxVolume");
            return (Criteria) this;
        }

        public Criteria andSecMaxVolumeNotBetween(Double value1, Double value2) {
            addCriterion("Sec_max_volume not between", value1, value2, "secMaxVolume");
            return (Criteria) this;
        }

        public Criteria andOrderRefIsNull() {
            addCriterion("Order_ref is null");
            return (Criteria) this;
        }

        public Criteria andOrderRefIsNotNull() {
            addCriterion("Order_ref is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRefEqualTo(String value) {
            addCriterion("Order_ref =", value, "orderRef");
            return (Criteria) this;
        }

        public Criteria andOrderRefNotEqualTo(String value) {
            addCriterion("Order_ref <>", value, "orderRef");
            return (Criteria) this;
        }

        public Criteria andOrderRefGreaterThan(String value) {
            addCriterion("Order_ref >", value, "orderRef");
            return (Criteria) this;
        }

        public Criteria andOrderRefGreaterThanOrEqualTo(String value) {
            addCriterion("Order_ref >=", value, "orderRef");
            return (Criteria) this;
        }

        public Criteria andOrderRefLessThan(String value) {
            addCriterion("Order_ref <", value, "orderRef");
            return (Criteria) this;
        }

        public Criteria andOrderRefLessThanOrEqualTo(String value) {
            addCriterion("Order_ref <=", value, "orderRef");
            return (Criteria) this;
        }

        public Criteria andOrderRefLike(String value) {
            addCriterion("Order_ref like", value, "orderRef");
            return (Criteria) this;
        }

        public Criteria andOrderRefNotLike(String value) {
            addCriterion("Order_ref not like", value, "orderRef");
            return (Criteria) this;
        }

        public Criteria andOrderRefIn(List<String> values) {
            addCriterion("Order_ref in", values, "orderRef");
            return (Criteria) this;
        }

        public Criteria andOrderRefNotIn(List<String> values) {
            addCriterion("Order_ref not in", values, "orderRef");
            return (Criteria) this;
        }

        public Criteria andOrderRefBetween(String value1, String value2) {
            addCriterion("Order_ref between", value1, value2, "orderRef");
            return (Criteria) this;
        }

        public Criteria andOrderRefNotBetween(String value1, String value2) {
            addCriterion("Order_ref not between", value1, value2, "orderRef");
            return (Criteria) this;
        }

        public Criteria andSecMinVolumeIsNull() {
            addCriterion("Sec_min_volume is null");
            return (Criteria) this;
        }

        public Criteria andSecMinVolumeIsNotNull() {
            addCriterion("Sec_min_volume is not null");
            return (Criteria) this;
        }

        public Criteria andSecMinVolumeEqualTo(Double value) {
            addCriterion("Sec_min_volume =", value, "secMinVolume");
            return (Criteria) this;
        }

        public Criteria andSecMinVolumeNotEqualTo(Double value) {
            addCriterion("Sec_min_volume <>", value, "secMinVolume");
            return (Criteria) this;
        }

        public Criteria andSecMinVolumeGreaterThan(Double value) {
            addCriterion("Sec_min_volume >", value, "secMinVolume");
            return (Criteria) this;
        }

        public Criteria andSecMinVolumeGreaterThanOrEqualTo(Double value) {
            addCriterion("Sec_min_volume >=", value, "secMinVolume");
            return (Criteria) this;
        }

        public Criteria andSecMinVolumeLessThan(Double value) {
            addCriterion("Sec_min_volume <", value, "secMinVolume");
            return (Criteria) this;
        }

        public Criteria andSecMinVolumeLessThanOrEqualTo(Double value) {
            addCriterion("Sec_min_volume <=", value, "secMinVolume");
            return (Criteria) this;
        }

        public Criteria andSecMinVolumeIn(List<Double> values) {
            addCriterion("Sec_min_volume in", values, "secMinVolume");
            return (Criteria) this;
        }

        public Criteria andSecMinVolumeNotIn(List<Double> values) {
            addCriterion("Sec_min_volume not in", values, "secMinVolume");
            return (Criteria) this;
        }

        public Criteria andSecMinVolumeBetween(Double value1, Double value2) {
            addCriterion("Sec_min_volume between", value1, value2, "secMinVolume");
            return (Criteria) this;
        }

        public Criteria andSecMinVolumeNotBetween(Double value1, Double value2) {
            addCriterion("Sec_min_volume not between", value1, value2, "secMinVolume");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}