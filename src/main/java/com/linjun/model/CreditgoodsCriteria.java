package com.linjun.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreditgoodsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CreditgoodsCriteria() {
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

        public Criteria andCreditgoodIsNull() {
            addCriterion("creditgood is null");
            return (Criteria) this;
        }

        public Criteria andCreditgoodIsNotNull() {
            addCriterion("creditgood is not null");
            return (Criteria) this;
        }

        public Criteria andCreditgoodEqualTo(String value) {
            addCriterion("creditgood =", value, "creditgood");
            return (Criteria) this;
        }

        public Criteria andCreditgoodNotEqualTo(String value) {
            addCriterion("creditgood <>", value, "creditgood");
            return (Criteria) this;
        }

        public Criteria andCreditgoodGreaterThan(String value) {
            addCriterion("creditgood >", value, "creditgood");
            return (Criteria) this;
        }

        public Criteria andCreditgoodGreaterThanOrEqualTo(String value) {
            addCriterion("creditgood >=", value, "creditgood");
            return (Criteria) this;
        }

        public Criteria andCreditgoodLessThan(String value) {
            addCriterion("creditgood <", value, "creditgood");
            return (Criteria) this;
        }

        public Criteria andCreditgoodLessThanOrEqualTo(String value) {
            addCriterion("creditgood <=", value, "creditgood");
            return (Criteria) this;
        }

        public Criteria andCreditgoodLike(String value) {
            addCriterion("creditgood like", value, "creditgood");
            return (Criteria) this;
        }

        public Criteria andCreditgoodNotLike(String value) {
            addCriterion("creditgood not like", value, "creditgood");
            return (Criteria) this;
        }

        public Criteria andCreditgoodIn(List<String> values) {
            addCriterion("creditgood in", values, "creditgood");
            return (Criteria) this;
        }

        public Criteria andCreditgoodNotIn(List<String> values) {
            addCriterion("creditgood not in", values, "creditgood");
            return (Criteria) this;
        }

        public Criteria andCreditgoodBetween(String value1, String value2) {
            addCriterion("creditgood between", value1, value2, "creditgood");
            return (Criteria) this;
        }

        public Criteria andCreditgoodNotBetween(String value1, String value2) {
            addCriterion("creditgood not between", value1, value2, "creditgood");
            return (Criteria) this;
        }

        public Criteria andImageurlIsNull() {
            addCriterion("imageurl is null");
            return (Criteria) this;
        }

        public Criteria andImageurlIsNotNull() {
            addCriterion("imageurl is not null");
            return (Criteria) this;
        }

        public Criteria andImageurlEqualTo(String value) {
            addCriterion("imageurl =", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotEqualTo(String value) {
            addCriterion("imageurl <>", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThan(String value) {
            addCriterion("imageurl >", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThanOrEqualTo(String value) {
            addCriterion("imageurl >=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThan(String value) {
            addCriterion("imageurl <", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThanOrEqualTo(String value) {
            addCriterion("imageurl <=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLike(String value) {
            addCriterion("imageurl like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotLike(String value) {
            addCriterion("imageurl not like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlIn(List<String> values) {
            addCriterion("imageurl in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotIn(List<String> values) {
            addCriterion("imageurl not in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlBetween(String value1, String value2) {
            addCriterion("imageurl between", value1, value2, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotBetween(String value1, String value2) {
            addCriterion("imageurl not between", value1, value2, "imageurl");
            return (Criteria) this;
        }

        public Criteria andCregoodssumIsNull() {
            addCriterion("cregoodsSum is null");
            return (Criteria) this;
        }

        public Criteria andCregoodssumIsNotNull() {
            addCriterion("cregoodsSum is not null");
            return (Criteria) this;
        }

        public Criteria andCregoodssumEqualTo(Long value) {
            addCriterion("cregoodsSum =", value, "cregoodssum");
            return (Criteria) this;
        }

        public Criteria andCregoodssumNotEqualTo(Long value) {
            addCriterion("cregoodsSum <>", value, "cregoodssum");
            return (Criteria) this;
        }

        public Criteria andCregoodssumGreaterThan(Long value) {
            addCriterion("cregoodsSum >", value, "cregoodssum");
            return (Criteria) this;
        }

        public Criteria andCregoodssumGreaterThanOrEqualTo(Long value) {
            addCriterion("cregoodsSum >=", value, "cregoodssum");
            return (Criteria) this;
        }

        public Criteria andCregoodssumLessThan(Long value) {
            addCriterion("cregoodsSum <", value, "cregoodssum");
            return (Criteria) this;
        }

        public Criteria andCregoodssumLessThanOrEqualTo(Long value) {
            addCriterion("cregoodsSum <=", value, "cregoodssum");
            return (Criteria) this;
        }

        public Criteria andCregoodssumIn(List<Long> values) {
            addCriterion("cregoodsSum in", values, "cregoodssum");
            return (Criteria) this;
        }

        public Criteria andCregoodssumNotIn(List<Long> values) {
            addCriterion("cregoodsSum not in", values, "cregoodssum");
            return (Criteria) this;
        }

        public Criteria andCregoodssumBetween(Long value1, Long value2) {
            addCriterion("cregoodsSum between", value1, value2, "cregoodssum");
            return (Criteria) this;
        }

        public Criteria andCregoodssumNotBetween(Long value1, Long value2) {
            addCriterion("cregoodsSum not between", value1, value2, "cregoodssum");
            return (Criteria) this;
        }

        public Criteria andSoldamountIsNull() {
            addCriterion("soldamount is null");
            return (Criteria) this;
        }

        public Criteria andSoldamountIsNotNull() {
            addCriterion("soldamount is not null");
            return (Criteria) this;
        }

        public Criteria andSoldamountEqualTo(Long value) {
            addCriterion("soldamount =", value, "soldamount");
            return (Criteria) this;
        }

        public Criteria andSoldamountNotEqualTo(Long value) {
            addCriterion("soldamount <>", value, "soldamount");
            return (Criteria) this;
        }

        public Criteria andSoldamountGreaterThan(Long value) {
            addCriterion("soldamount >", value, "soldamount");
            return (Criteria) this;
        }

        public Criteria andSoldamountGreaterThanOrEqualTo(Long value) {
            addCriterion("soldamount >=", value, "soldamount");
            return (Criteria) this;
        }

        public Criteria andSoldamountLessThan(Long value) {
            addCriterion("soldamount <", value, "soldamount");
            return (Criteria) this;
        }

        public Criteria andSoldamountLessThanOrEqualTo(Long value) {
            addCriterion("soldamount <=", value, "soldamount");
            return (Criteria) this;
        }

        public Criteria andSoldamountIn(List<Long> values) {
            addCriterion("soldamount in", values, "soldamount");
            return (Criteria) this;
        }

        public Criteria andSoldamountNotIn(List<Long> values) {
            addCriterion("soldamount not in", values, "soldamount");
            return (Criteria) this;
        }

        public Criteria andSoldamountBetween(Long value1, Long value2) {
            addCriterion("soldamount between", value1, value2, "soldamount");
            return (Criteria) this;
        }

        public Criteria andSoldamountNotBetween(Long value1, Long value2) {
            addCriterion("soldamount not between", value1, value2, "soldamount");
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

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andIsstartIsNull() {
            addCriterion("isstart is null");
            return (Criteria) this;
        }

        public Criteria andIsstartIsNotNull() {
            addCriterion("isstart is not null");
            return (Criteria) this;
        }

        public Criteria andIsstartEqualTo(Byte value) {
            addCriterion("isstart =", value, "isstart");
            return (Criteria) this;
        }

        public Criteria andIsstartNotEqualTo(Byte value) {
            addCriterion("isstart <>", value, "isstart");
            return (Criteria) this;
        }

        public Criteria andIsstartGreaterThan(Byte value) {
            addCriterion("isstart >", value, "isstart");
            return (Criteria) this;
        }

        public Criteria andIsstartGreaterThanOrEqualTo(Byte value) {
            addCriterion("isstart >=", value, "isstart");
            return (Criteria) this;
        }

        public Criteria andIsstartLessThan(Byte value) {
            addCriterion("isstart <", value, "isstart");
            return (Criteria) this;
        }

        public Criteria andIsstartLessThanOrEqualTo(Byte value) {
            addCriterion("isstart <=", value, "isstart");
            return (Criteria) this;
        }

        public Criteria andIsstartIn(List<Byte> values) {
            addCriterion("isstart in", values, "isstart");
            return (Criteria) this;
        }

        public Criteria andIsstartNotIn(List<Byte> values) {
            addCriterion("isstart not in", values, "isstart");
            return (Criteria) this;
        }

        public Criteria andIsstartBetween(Byte value1, Byte value2) {
            addCriterion("isstart between", value1, value2, "isstart");
            return (Criteria) this;
        }

        public Criteria andIsstartNotBetween(Byte value1, Byte value2) {
            addCriterion("isstart not between", value1, value2, "isstart");
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