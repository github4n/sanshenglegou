package com.linjun.model;

import java.util.ArrayList;
import java.util.List;

public class CoupanCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CoupanCriteria() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAvailableIsNull() {
            addCriterion("available is null");
            return (Criteria) this;
        }

        public Criteria andAvailableIsNotNull() {
            addCriterion("available is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableEqualTo(String value) {
            addCriterion("available =", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotEqualTo(String value) {
            addCriterion("available <>", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThan(String value) {
            addCriterion("available >", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThanOrEqualTo(String value) {
            addCriterion("available >=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThan(String value) {
            addCriterion("available <", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThanOrEqualTo(String value) {
            addCriterion("available <=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLike(String value) {
            addCriterion("available like", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotLike(String value) {
            addCriterion("available not like", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableIn(List<String> values) {
            addCriterion("available in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotIn(List<String> values) {
            addCriterion("available not in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableBetween(String value1, String value2) {
            addCriterion("available between", value1, value2, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotBetween(String value1, String value2) {
            addCriterion("available not between", value1, value2, "available");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(String value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(String value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(String value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(String value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(String value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLike(String value) {
            addCriterion("discount like", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotLike(String value) {
            addCriterion("discount not like", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<String> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<String> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(String value1, String value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(String value1, String value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDenominationsIsNull() {
            addCriterion("denominations is null");
            return (Criteria) this;
        }

        public Criteria andDenominationsIsNotNull() {
            addCriterion("denominations is not null");
            return (Criteria) this;
        }

        public Criteria andDenominationsEqualTo(String value) {
            addCriterion("denominations =", value, "denominations");
            return (Criteria) this;
        }

        public Criteria andDenominationsNotEqualTo(String value) {
            addCriterion("denominations <>", value, "denominations");
            return (Criteria) this;
        }

        public Criteria andDenominationsGreaterThan(String value) {
            addCriterion("denominations >", value, "denominations");
            return (Criteria) this;
        }

        public Criteria andDenominationsGreaterThanOrEqualTo(String value) {
            addCriterion("denominations >=", value, "denominations");
            return (Criteria) this;
        }

        public Criteria andDenominationsLessThan(String value) {
            addCriterion("denominations <", value, "denominations");
            return (Criteria) this;
        }

        public Criteria andDenominationsLessThanOrEqualTo(String value) {
            addCriterion("denominations <=", value, "denominations");
            return (Criteria) this;
        }

        public Criteria andDenominationsLike(String value) {
            addCriterion("denominations like", value, "denominations");
            return (Criteria) this;
        }

        public Criteria andDenominationsNotLike(String value) {
            addCriterion("denominations not like", value, "denominations");
            return (Criteria) this;
        }

        public Criteria andDenominationsIn(List<String> values) {
            addCriterion("denominations in", values, "denominations");
            return (Criteria) this;
        }

        public Criteria andDenominationsNotIn(List<String> values) {
            addCriterion("denominations not in", values, "denominations");
            return (Criteria) this;
        }

        public Criteria andDenominationsBetween(String value1, String value2) {
            addCriterion("denominations between", value1, value2, "denominations");
            return (Criteria) this;
        }

        public Criteria andDenominationsNotBetween(String value1, String value2) {
            addCriterion("denominations not between", value1, value2, "denominations");
            return (Criteria) this;
        }

        public Criteria andOriginConditionIsNull() {
            addCriterion("origin_condition is null");
            return (Criteria) this;
        }

        public Criteria andOriginConditionIsNotNull() {
            addCriterion("origin_condition is not null");
            return (Criteria) this;
        }

        public Criteria andOriginConditionEqualTo(String value) {
            addCriterion("origin_condition =", value, "originCondition");
            return (Criteria) this;
        }

        public Criteria andOriginConditionNotEqualTo(String value) {
            addCriterion("origin_condition <>", value, "originCondition");
            return (Criteria) this;
        }

        public Criteria andOriginConditionGreaterThan(String value) {
            addCriterion("origin_condition >", value, "originCondition");
            return (Criteria) this;
        }

        public Criteria andOriginConditionGreaterThanOrEqualTo(String value) {
            addCriterion("origin_condition >=", value, "originCondition");
            return (Criteria) this;
        }

        public Criteria andOriginConditionLessThan(String value) {
            addCriterion("origin_condition <", value, "originCondition");
            return (Criteria) this;
        }

        public Criteria andOriginConditionLessThanOrEqualTo(String value) {
            addCriterion("origin_condition <=", value, "originCondition");
            return (Criteria) this;
        }

        public Criteria andOriginConditionLike(String value) {
            addCriterion("origin_condition like", value, "originCondition");
            return (Criteria) this;
        }

        public Criteria andOriginConditionNotLike(String value) {
            addCriterion("origin_condition not like", value, "originCondition");
            return (Criteria) this;
        }

        public Criteria andOriginConditionIn(List<String> values) {
            addCriterion("origin_condition in", values, "originCondition");
            return (Criteria) this;
        }

        public Criteria andOriginConditionNotIn(List<String> values) {
            addCriterion("origin_condition not in", values, "originCondition");
            return (Criteria) this;
        }

        public Criteria andOriginConditionBetween(String value1, String value2) {
            addCriterion("origin_condition between", value1, value2, "originCondition");
            return (Criteria) this;
        }

        public Criteria andOriginConditionNotBetween(String value1, String value2) {
            addCriterion("origin_condition not between", value1, value2, "originCondition");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("value not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andConditionIsNull() {
            addCriterion("condition is null");
            return (Criteria) this;
        }

        public Criteria andConditionIsNotNull() {
            addCriterion("condition is not null");
            return (Criteria) this;
        }

        public Criteria andConditionEqualTo(String value) {
            addCriterion("condition =", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotEqualTo(String value) {
            addCriterion("condition <>", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThan(String value) {
            addCriterion("condition >", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThanOrEqualTo(String value) {
            addCriterion("condition >=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThan(String value) {
            addCriterion("condition <", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThanOrEqualTo(String value) {
            addCriterion("condition <=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLike(String value) {
            addCriterion("condition like", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotLike(String value) {
            addCriterion("condition not like", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionIn(List<String> values) {
            addCriterion("condition in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotIn(List<String> values) {
            addCriterion("condition not in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionBetween(String value1, String value2) {
            addCriterion("condition between", value1, value2, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotBetween(String value1, String value2) {
            addCriterion("condition not between", value1, value2, "condition");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andStartAtIsNull() {
            addCriterion("start_at is null");
            return (Criteria) this;
        }

        public Criteria andStartAtIsNotNull() {
            addCriterion("start_at is not null");
            return (Criteria) this;
        }

        public Criteria andStartAtEqualTo(String value) {
            addCriterion("start_at =", value, "startAt");
            return (Criteria) this;
        }

        public Criteria andStartAtNotEqualTo(String value) {
            addCriterion("start_at <>", value, "startAt");
            return (Criteria) this;
        }

        public Criteria andStartAtGreaterThan(String value) {
            addCriterion("start_at >", value, "startAt");
            return (Criteria) this;
        }

        public Criteria andStartAtGreaterThanOrEqualTo(String value) {
            addCriterion("start_at >=", value, "startAt");
            return (Criteria) this;
        }

        public Criteria andStartAtLessThan(String value) {
            addCriterion("start_at <", value, "startAt");
            return (Criteria) this;
        }

        public Criteria andStartAtLessThanOrEqualTo(String value) {
            addCriterion("start_at <=", value, "startAt");
            return (Criteria) this;
        }

        public Criteria andStartAtLike(String value) {
            addCriterion("start_at like", value, "startAt");
            return (Criteria) this;
        }

        public Criteria andStartAtNotLike(String value) {
            addCriterion("start_at not like", value, "startAt");
            return (Criteria) this;
        }

        public Criteria andStartAtIn(List<String> values) {
            addCriterion("start_at in", values, "startAt");
            return (Criteria) this;
        }

        public Criteria andStartAtNotIn(List<String> values) {
            addCriterion("start_at not in", values, "startAt");
            return (Criteria) this;
        }

        public Criteria andStartAtBetween(String value1, String value2) {
            addCriterion("start_at between", value1, value2, "startAt");
            return (Criteria) this;
        }

        public Criteria andStartAtNotBetween(String value1, String value2) {
            addCriterion("start_at not between", value1, value2, "startAt");
            return (Criteria) this;
        }

        public Criteria andEndAtIsNull() {
            addCriterion("end_at is null");
            return (Criteria) this;
        }

        public Criteria andEndAtIsNotNull() {
            addCriterion("end_at is not null");
            return (Criteria) this;
        }

        public Criteria andEndAtEqualTo(String value) {
            addCriterion("end_at =", value, "endAt");
            return (Criteria) this;
        }

        public Criteria andEndAtNotEqualTo(String value) {
            addCriterion("end_at <>", value, "endAt");
            return (Criteria) this;
        }

        public Criteria andEndAtGreaterThan(String value) {
            addCriterion("end_at >", value, "endAt");
            return (Criteria) this;
        }

        public Criteria andEndAtGreaterThanOrEqualTo(String value) {
            addCriterion("end_at >=", value, "endAt");
            return (Criteria) this;
        }

        public Criteria andEndAtLessThan(String value) {
            addCriterion("end_at <", value, "endAt");
            return (Criteria) this;
        }

        public Criteria andEndAtLessThanOrEqualTo(String value) {
            addCriterion("end_at <=", value, "endAt");
            return (Criteria) this;
        }

        public Criteria andEndAtLike(String value) {
            addCriterion("end_at like", value, "endAt");
            return (Criteria) this;
        }

        public Criteria andEndAtNotLike(String value) {
            addCriterion("end_at not like", value, "endAt");
            return (Criteria) this;
        }

        public Criteria andEndAtIn(List<String> values) {
            addCriterion("end_at in", values, "endAt");
            return (Criteria) this;
        }

        public Criteria andEndAtNotIn(List<String> values) {
            addCriterion("end_at not in", values, "endAt");
            return (Criteria) this;
        }

        public Criteria andEndAtBetween(String value1, String value2) {
            addCriterion("end_at between", value1, value2, "endAt");
            return (Criteria) this;
        }

        public Criteria andEndAtNotBetween(String value1, String value2) {
            addCriterion("end_at not between", value1, value2, "endAt");
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