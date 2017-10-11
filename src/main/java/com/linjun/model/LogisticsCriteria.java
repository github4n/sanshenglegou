package com.linjun.model;

import java.util.ArrayList;
import java.util.List;

public class LogisticsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogisticsCriteria() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Long value) {
            addCriterion("orderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Long value) {
            addCriterion("orderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Long value) {
            addCriterion("orderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Long value) {
            addCriterion("orderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Long value) {
            addCriterion("orderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Long value) {
            addCriterion("orderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Long> values) {
            addCriterion("orderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Long> values) {
            addCriterion("orderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Long value1, Long value2) {
            addCriterion("orderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Long value1, Long value2) {
            addCriterion("orderId not between", value1, value2, "orderid");
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

        public Criteria andLogisticsnameIsNull() {
            addCriterion("logisticsName is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsnameIsNotNull() {
            addCriterion("logisticsName is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsnameEqualTo(String value) {
            addCriterion("logisticsName =", value, "logisticsname");
            return (Criteria) this;
        }

        public Criteria andLogisticsnameNotEqualTo(String value) {
            addCriterion("logisticsName <>", value, "logisticsname");
            return (Criteria) this;
        }

        public Criteria andLogisticsnameGreaterThan(String value) {
            addCriterion("logisticsName >", value, "logisticsname");
            return (Criteria) this;
        }

        public Criteria andLogisticsnameGreaterThanOrEqualTo(String value) {
            addCriterion("logisticsName >=", value, "logisticsname");
            return (Criteria) this;
        }

        public Criteria andLogisticsnameLessThan(String value) {
            addCriterion("logisticsName <", value, "logisticsname");
            return (Criteria) this;
        }

        public Criteria andLogisticsnameLessThanOrEqualTo(String value) {
            addCriterion("logisticsName <=", value, "logisticsname");
            return (Criteria) this;
        }

        public Criteria andLogisticsnameLike(String value) {
            addCriterion("logisticsName like", value, "logisticsname");
            return (Criteria) this;
        }

        public Criteria andLogisticsnameNotLike(String value) {
            addCriterion("logisticsName not like", value, "logisticsname");
            return (Criteria) this;
        }

        public Criteria andLogisticsnameIn(List<String> values) {
            addCriterion("logisticsName in", values, "logisticsname");
            return (Criteria) this;
        }

        public Criteria andLogisticsnameNotIn(List<String> values) {
            addCriterion("logisticsName not in", values, "logisticsname");
            return (Criteria) this;
        }

        public Criteria andLogisticsnameBetween(String value1, String value2) {
            addCriterion("logisticsName between", value1, value2, "logisticsname");
            return (Criteria) this;
        }

        public Criteria andLogisticsnameNotBetween(String value1, String value2) {
            addCriterion("logisticsName not between", value1, value2, "logisticsname");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateIsNull() {
            addCriterion("logisticsState is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateIsNotNull() {
            addCriterion("logisticsState is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateEqualTo(String value) {
            addCriterion("logisticsState =", value, "logisticsstate");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateNotEqualTo(String value) {
            addCriterion("logisticsState <>", value, "logisticsstate");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateGreaterThan(String value) {
            addCriterion("logisticsState >", value, "logisticsstate");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateGreaterThanOrEqualTo(String value) {
            addCriterion("logisticsState >=", value, "logisticsstate");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateLessThan(String value) {
            addCriterion("logisticsState <", value, "logisticsstate");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateLessThanOrEqualTo(String value) {
            addCriterion("logisticsState <=", value, "logisticsstate");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateLike(String value) {
            addCriterion("logisticsState like", value, "logisticsstate");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateNotLike(String value) {
            addCriterion("logisticsState not like", value, "logisticsstate");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateIn(List<String> values) {
            addCriterion("logisticsState in", values, "logisticsstate");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateNotIn(List<String> values) {
            addCriterion("logisticsState not in", values, "logisticsstate");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateBetween(String value1, String value2) {
            addCriterion("logisticsState between", value1, value2, "logisticsstate");
            return (Criteria) this;
        }

        public Criteria andLogisticsstateNotBetween(String value1, String value2) {
            addCriterion("logisticsState not between", value1, value2, "logisticsstate");
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