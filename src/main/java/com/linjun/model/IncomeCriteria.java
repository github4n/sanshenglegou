package com.linjun.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IncomeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IncomeCriteria() {
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

        public Criteria andOrdercodeIsNull() {
            addCriterion("orderCode is null");
            return (Criteria) this;
        }

        public Criteria andOrdercodeIsNotNull() {
            addCriterion("orderCode is not null");
            return (Criteria) this;
        }

        public Criteria andOrdercodeEqualTo(Long value) {
            addCriterion("orderCode =", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotEqualTo(Long value) {
            addCriterion("orderCode <>", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeGreaterThan(Long value) {
            addCriterion("orderCode >", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeGreaterThanOrEqualTo(Long value) {
            addCriterion("orderCode >=", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeLessThan(Long value) {
            addCriterion("orderCode <", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeLessThanOrEqualTo(Long value) {
            addCriterion("orderCode <=", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeIn(List<Long> values) {
            addCriterion("orderCode in", values, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotIn(List<Long> values) {
            addCriterion("orderCode not in", values, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeBetween(Long value1, Long value2) {
            addCriterion("orderCode between", value1, value2, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotBetween(Long value1, Long value2) {
            addCriterion("orderCode not between", value1, value2, "ordercode");
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

        public Criteria andPaynameIsNull() {
            addCriterion("payName is null");
            return (Criteria) this;
        }

        public Criteria andPaynameIsNotNull() {
            addCriterion("payName is not null");
            return (Criteria) this;
        }

        public Criteria andPaynameEqualTo(String value) {
            addCriterion("payName =", value, "payname");
            return (Criteria) this;
        }

        public Criteria andPaynameNotEqualTo(String value) {
            addCriterion("payName <>", value, "payname");
            return (Criteria) this;
        }

        public Criteria andPaynameGreaterThan(String value) {
            addCriterion("payName >", value, "payname");
            return (Criteria) this;
        }

        public Criteria andPaynameGreaterThanOrEqualTo(String value) {
            addCriterion("payName >=", value, "payname");
            return (Criteria) this;
        }

        public Criteria andPaynameLessThan(String value) {
            addCriterion("payName <", value, "payname");
            return (Criteria) this;
        }

        public Criteria andPaynameLessThanOrEqualTo(String value) {
            addCriterion("payName <=", value, "payname");
            return (Criteria) this;
        }

        public Criteria andPaynameLike(String value) {
            addCriterion("payName like", value, "payname");
            return (Criteria) this;
        }

        public Criteria andPaynameNotLike(String value) {
            addCriterion("payName not like", value, "payname");
            return (Criteria) this;
        }

        public Criteria andPaynameIn(List<String> values) {
            addCriterion("payName in", values, "payname");
            return (Criteria) this;
        }

        public Criteria andPaynameNotIn(List<String> values) {
            addCriterion("payName not in", values, "payname");
            return (Criteria) this;
        }

        public Criteria andPaynameBetween(String value1, String value2) {
            addCriterion("payName between", value1, value2, "payname");
            return (Criteria) this;
        }

        public Criteria andPaynameNotBetween(String value1, String value2) {
            addCriterion("payName not between", value1, value2, "payname");
            return (Criteria) this;
        }

        public Criteria andPayidIsNull() {
            addCriterion("payID is null");
            return (Criteria) this;
        }

        public Criteria andPayidIsNotNull() {
            addCriterion("payID is not null");
            return (Criteria) this;
        }

        public Criteria andPayidEqualTo(Long value) {
            addCriterion("payID =", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotEqualTo(Long value) {
            addCriterion("payID <>", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThan(Long value) {
            addCriterion("payID >", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThanOrEqualTo(Long value) {
            addCriterion("payID >=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThan(Long value) {
            addCriterion("payID <", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThanOrEqualTo(Long value) {
            addCriterion("payID <=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidIn(List<Long> values) {
            addCriterion("payID in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotIn(List<Long> values) {
            addCriterion("payID not in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidBetween(Long value1, Long value2) {
            addCriterion("payID between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotBetween(Long value1, Long value2) {
            addCriterion("payID not between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNull() {
            addCriterion("payTime is null");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNotNull() {
            addCriterion("payTime is not null");
            return (Criteria) this;
        }

        public Criteria andPaytimeEqualTo(Date value) {
            addCriterion("payTime =", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotEqualTo(Date value) {
            addCriterion("payTime <>", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThan(Date value) {
            addCriterion("payTime >", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payTime >=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThan(Date value) {
            addCriterion("payTime <", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThanOrEqualTo(Date value) {
            addCriterion("payTime <=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeIn(List<Date> values) {
            addCriterion("payTime in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotIn(List<Date> values) {
            addCriterion("payTime not in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeBetween(Date value1, Date value2) {
            addCriterion("payTime between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotBetween(Date value1, Date value2) {
            addCriterion("payTime not between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andStutasIsNull() {
            addCriterion("stutas is null");
            return (Criteria) this;
        }

        public Criteria andStutasIsNotNull() {
            addCriterion("stutas is not null");
            return (Criteria) this;
        }

        public Criteria andStutasEqualTo(Byte value) {
            addCriterion("stutas =", value, "stutas");
            return (Criteria) this;
        }

        public Criteria andStutasNotEqualTo(Byte value) {
            addCriterion("stutas <>", value, "stutas");
            return (Criteria) this;
        }

        public Criteria andStutasGreaterThan(Byte value) {
            addCriterion("stutas >", value, "stutas");
            return (Criteria) this;
        }

        public Criteria andStutasGreaterThanOrEqualTo(Byte value) {
            addCriterion("stutas >=", value, "stutas");
            return (Criteria) this;
        }

        public Criteria andStutasLessThan(Byte value) {
            addCriterion("stutas <", value, "stutas");
            return (Criteria) this;
        }

        public Criteria andStutasLessThanOrEqualTo(Byte value) {
            addCriterion("stutas <=", value, "stutas");
            return (Criteria) this;
        }

        public Criteria andStutasIn(List<Byte> values) {
            addCriterion("stutas in", values, "stutas");
            return (Criteria) this;
        }

        public Criteria andStutasNotIn(List<Byte> values) {
            addCriterion("stutas not in", values, "stutas");
            return (Criteria) this;
        }

        public Criteria andStutasBetween(Byte value1, Byte value2) {
            addCriterion("stutas between", value1, value2, "stutas");
            return (Criteria) this;
        }

        public Criteria andStutasNotBetween(Byte value1, Byte value2) {
            addCriterion("stutas not between", value1, value2, "stutas");
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