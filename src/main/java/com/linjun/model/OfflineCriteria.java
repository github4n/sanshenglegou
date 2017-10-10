package com.linjun.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfflineCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OfflineCriteria() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andOfflinruseridIsNull() {
            addCriterion("offlinrUserID is null");
            return (Criteria) this;
        }

        public Criteria andOfflinruseridIsNotNull() {
            addCriterion("offlinrUserID is not null");
            return (Criteria) this;
        }

        public Criteria andOfflinruseridEqualTo(Long value) {
            addCriterion("offlinrUserID =", value, "offlinruserid");
            return (Criteria) this;
        }

        public Criteria andOfflinruseridNotEqualTo(Long value) {
            addCriterion("offlinrUserID <>", value, "offlinruserid");
            return (Criteria) this;
        }

        public Criteria andOfflinruseridGreaterThan(Long value) {
            addCriterion("offlinrUserID >", value, "offlinruserid");
            return (Criteria) this;
        }

        public Criteria andOfflinruseridGreaterThanOrEqualTo(Long value) {
            addCriterion("offlinrUserID >=", value, "offlinruserid");
            return (Criteria) this;
        }

        public Criteria andOfflinruseridLessThan(Long value) {
            addCriterion("offlinrUserID <", value, "offlinruserid");
            return (Criteria) this;
        }

        public Criteria andOfflinruseridLessThanOrEqualTo(Long value) {
            addCriterion("offlinrUserID <=", value, "offlinruserid");
            return (Criteria) this;
        }

        public Criteria andOfflinruseridIn(List<Long> values) {
            addCriterion("offlinrUserID in", values, "offlinruserid");
            return (Criteria) this;
        }

        public Criteria andOfflinruseridNotIn(List<Long> values) {
            addCriterion("offlinrUserID not in", values, "offlinruserid");
            return (Criteria) this;
        }

        public Criteria andOfflinruseridBetween(Long value1, Long value2) {
            addCriterion("offlinrUserID between", value1, value2, "offlinruserid");
            return (Criteria) this;
        }

        public Criteria andOfflinruseridNotBetween(Long value1, Long value2) {
            addCriterion("offlinrUserID not between", value1, value2, "offlinruserid");
            return (Criteria) this;
        }

        public Criteria andFatheruseridIsNull() {
            addCriterion("fatherUserID is null");
            return (Criteria) this;
        }

        public Criteria andFatheruseridIsNotNull() {
            addCriterion("fatherUserID is not null");
            return (Criteria) this;
        }

        public Criteria andFatheruseridEqualTo(Long value) {
            addCriterion("fatherUserID =", value, "fatheruserid");
            return (Criteria) this;
        }

        public Criteria andFatheruseridNotEqualTo(Long value) {
            addCriterion("fatherUserID <>", value, "fatheruserid");
            return (Criteria) this;
        }

        public Criteria andFatheruseridGreaterThan(Long value) {
            addCriterion("fatherUserID >", value, "fatheruserid");
            return (Criteria) this;
        }

        public Criteria andFatheruseridGreaterThanOrEqualTo(Long value) {
            addCriterion("fatherUserID >=", value, "fatheruserid");
            return (Criteria) this;
        }

        public Criteria andFatheruseridLessThan(Long value) {
            addCriterion("fatherUserID <", value, "fatheruserid");
            return (Criteria) this;
        }

        public Criteria andFatheruseridLessThanOrEqualTo(Long value) {
            addCriterion("fatherUserID <=", value, "fatheruserid");
            return (Criteria) this;
        }

        public Criteria andFatheruseridIn(List<Long> values) {
            addCriterion("fatherUserID in", values, "fatheruserid");
            return (Criteria) this;
        }

        public Criteria andFatheruseridNotIn(List<Long> values) {
            addCriterion("fatherUserID not in", values, "fatheruserid");
            return (Criteria) this;
        }

        public Criteria andFatheruseridBetween(Long value1, Long value2) {
            addCriterion("fatherUserID between", value1, value2, "fatheruserid");
            return (Criteria) this;
        }

        public Criteria andFatheruseridNotBetween(Long value1, Long value2) {
            addCriterion("fatherUserID not between", value1, value2, "fatheruserid");
            return (Criteria) this;
        }

        public Criteria andIsfatherIsNull() {
            addCriterion("isFather is null");
            return (Criteria) this;
        }

        public Criteria andIsfatherIsNotNull() {
            addCriterion("isFather is not null");
            return (Criteria) this;
        }

        public Criteria andIsfatherEqualTo(Byte value) {
            addCriterion("isFather =", value, "isfather");
            return (Criteria) this;
        }

        public Criteria andIsfatherNotEqualTo(Byte value) {
            addCriterion("isFather <>", value, "isfather");
            return (Criteria) this;
        }

        public Criteria andIsfatherGreaterThan(Byte value) {
            addCriterion("isFather >", value, "isfather");
            return (Criteria) this;
        }

        public Criteria andIsfatherGreaterThanOrEqualTo(Byte value) {
            addCriterion("isFather >=", value, "isfather");
            return (Criteria) this;
        }

        public Criteria andIsfatherLessThan(Byte value) {
            addCriterion("isFather <", value, "isfather");
            return (Criteria) this;
        }

        public Criteria andIsfatherLessThanOrEqualTo(Byte value) {
            addCriterion("isFather <=", value, "isfather");
            return (Criteria) this;
        }

        public Criteria andIsfatherIn(List<Byte> values) {
            addCriterion("isFather in", values, "isfather");
            return (Criteria) this;
        }

        public Criteria andIsfatherNotIn(List<Byte> values) {
            addCriterion("isFather not in", values, "isfather");
            return (Criteria) this;
        }

        public Criteria andIsfatherBetween(Byte value1, Byte value2) {
            addCriterion("isFather between", value1, value2, "isfather");
            return (Criteria) this;
        }

        public Criteria andIsfatherNotBetween(Byte value1, Byte value2) {
            addCriterion("isFather not between", value1, value2, "isfather");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
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