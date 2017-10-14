package com.linjun.model;

import java.util.ArrayList;
import java.util.List;

public class CreditDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CreditDetailCriteria() {
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

        public Criteria andCreditidIsNull() {
            addCriterion("creditID is null");
            return (Criteria) this;
        }

        public Criteria andCreditidIsNotNull() {
            addCriterion("creditID is not null");
            return (Criteria) this;
        }

        public Criteria andCreditidEqualTo(Long value) {
            addCriterion("creditID =", value, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidNotEqualTo(Long value) {
            addCriterion("creditID <>", value, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidGreaterThan(Long value) {
            addCriterion("creditID >", value, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidGreaterThanOrEqualTo(Long value) {
            addCriterion("creditID >=", value, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidLessThan(Long value) {
            addCriterion("creditID <", value, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidLessThanOrEqualTo(Long value) {
            addCriterion("creditID <=", value, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidIn(List<Long> values) {
            addCriterion("creditID in", values, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidNotIn(List<Long> values) {
            addCriterion("creditID not in", values, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidBetween(Long value1, Long value2) {
            addCriterion("creditID between", value1, value2, "creditid");
            return (Criteria) this;
        }

        public Criteria andCreditidNotBetween(Long value1, Long value2) {
            addCriterion("creditID not between", value1, value2, "creditid");
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

        public Criteria andAddcreditIsNull() {
            addCriterion("addCredit is null");
            return (Criteria) this;
        }

        public Criteria andAddcreditIsNotNull() {
            addCriterion("addCredit is not null");
            return (Criteria) this;
        }

        public Criteria andAddcreditEqualTo(Long value) {
            addCriterion("addCredit =", value, "addcredit");
            return (Criteria) this;
        }

        public Criteria andAddcreditNotEqualTo(Long value) {
            addCriterion("addCredit <>", value, "addcredit");
            return (Criteria) this;
        }

        public Criteria andAddcreditGreaterThan(Long value) {
            addCriterion("addCredit >", value, "addcredit");
            return (Criteria) this;
        }

        public Criteria andAddcreditGreaterThanOrEqualTo(Long value) {
            addCriterion("addCredit >=", value, "addcredit");
            return (Criteria) this;
        }

        public Criteria andAddcreditLessThan(Long value) {
            addCriterion("addCredit <", value, "addcredit");
            return (Criteria) this;
        }

        public Criteria andAddcreditLessThanOrEqualTo(Long value) {
            addCriterion("addCredit <=", value, "addcredit");
            return (Criteria) this;
        }

        public Criteria andAddcreditIn(List<Long> values) {
            addCriterion("addCredit in", values, "addcredit");
            return (Criteria) this;
        }

        public Criteria andAddcreditNotIn(List<Long> values) {
            addCriterion("addCredit not in", values, "addcredit");
            return (Criteria) this;
        }

        public Criteria andAddcreditBetween(Long value1, Long value2) {
            addCriterion("addCredit between", value1, value2, "addcredit");
            return (Criteria) this;
        }

        public Criteria andAddcreditNotBetween(Long value1, Long value2) {
            addCriterion("addCredit not between", value1, value2, "addcredit");
            return (Criteria) this;
        }

        public Criteria andConsumcreditIsNull() {
            addCriterion("consumCredit is null");
            return (Criteria) this;
        }

        public Criteria andConsumcreditIsNotNull() {
            addCriterion("consumCredit is not null");
            return (Criteria) this;
        }

        public Criteria andConsumcreditEqualTo(Long value) {
            addCriterion("consumCredit =", value, "consumcredit");
            return (Criteria) this;
        }

        public Criteria andConsumcreditNotEqualTo(Long value) {
            addCriterion("consumCredit <>", value, "consumcredit");
            return (Criteria) this;
        }

        public Criteria andConsumcreditGreaterThan(Long value) {
            addCriterion("consumCredit >", value, "consumcredit");
            return (Criteria) this;
        }

        public Criteria andConsumcreditGreaterThanOrEqualTo(Long value) {
            addCriterion("consumCredit >=", value, "consumcredit");
            return (Criteria) this;
        }

        public Criteria andConsumcreditLessThan(Long value) {
            addCriterion("consumCredit <", value, "consumcredit");
            return (Criteria) this;
        }

        public Criteria andConsumcreditLessThanOrEqualTo(Long value) {
            addCriterion("consumCredit <=", value, "consumcredit");
            return (Criteria) this;
        }

        public Criteria andConsumcreditIn(List<Long> values) {
            addCriterion("consumCredit in", values, "consumcredit");
            return (Criteria) this;
        }

        public Criteria andConsumcreditNotIn(List<Long> values) {
            addCriterion("consumCredit not in", values, "consumcredit");
            return (Criteria) this;
        }

        public Criteria andConsumcreditBetween(Long value1, Long value2) {
            addCriterion("consumCredit between", value1, value2, "consumcredit");
            return (Criteria) this;
        }

        public Criteria andConsumcreditNotBetween(Long value1, Long value2) {
            addCriterion("consumCredit not between", value1, value2, "consumcredit");
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