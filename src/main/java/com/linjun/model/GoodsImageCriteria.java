package com.linjun.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsImageCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsImageCriteria() {
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

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(Long value) {
            addCriterion("goodsID =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(Long value) {
            addCriterion("goodsID <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(Long value) {
            addCriterion("goodsID >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Long value) {
            addCriterion("goodsID >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(Long value) {
            addCriterion("goodsID <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(Long value) {
            addCriterion("goodsID <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<Long> values) {
            addCriterion("goodsID in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<Long> values) {
            addCriterion("goodsID not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(Long value1, Long value2) {
            addCriterion("goodsID between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(Long value1, Long value2) {
            addCriterion("goodsID not between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressIsNull() {
            addCriterion("IamgeAddress is null");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressIsNotNull() {
            addCriterion("IamgeAddress is not null");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressEqualTo(String value) {
            addCriterion("IamgeAddress =", value, "iamgeaddress");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressNotEqualTo(String value) {
            addCriterion("IamgeAddress <>", value, "iamgeaddress");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressGreaterThan(String value) {
            addCriterion("IamgeAddress >", value, "iamgeaddress");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressGreaterThanOrEqualTo(String value) {
            addCriterion("IamgeAddress >=", value, "iamgeaddress");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressLessThan(String value) {
            addCriterion("IamgeAddress <", value, "iamgeaddress");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressLessThanOrEqualTo(String value) {
            addCriterion("IamgeAddress <=", value, "iamgeaddress");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressLike(String value) {
            addCriterion("IamgeAddress like", value, "iamgeaddress");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressNotLike(String value) {
            addCriterion("IamgeAddress not like", value, "iamgeaddress");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressIn(List<String> values) {
            addCriterion("IamgeAddress in", values, "iamgeaddress");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressNotIn(List<String> values) {
            addCriterion("IamgeAddress not in", values, "iamgeaddress");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressBetween(String value1, String value2) {
            addCriterion("IamgeAddress between", value1, value2, "iamgeaddress");
            return (Criteria) this;
        }

        public Criteria andIamgeaddressNotBetween(String value1, String value2) {
            addCriterion("IamgeAddress not between", value1, value2, "iamgeaddress");
            return (Criteria) this;
        }

        public Criteria andIskeyiamgeIsNull() {
            addCriterion("isKeyIamge is null");
            return (Criteria) this;
        }

        public Criteria andIskeyiamgeIsNotNull() {
            addCriterion("isKeyIamge is not null");
            return (Criteria) this;
        }

        public Criteria andIskeyiamgeEqualTo(Byte value) {
            addCriterion("isKeyIamge =", value, "iskeyiamge");
            return (Criteria) this;
        }

        public Criteria andIskeyiamgeNotEqualTo(Byte value) {
            addCriterion("isKeyIamge <>", value, "iskeyiamge");
            return (Criteria) this;
        }

        public Criteria andIskeyiamgeGreaterThan(Byte value) {
            addCriterion("isKeyIamge >", value, "iskeyiamge");
            return (Criteria) this;
        }

        public Criteria andIskeyiamgeGreaterThanOrEqualTo(Byte value) {
            addCriterion("isKeyIamge >=", value, "iskeyiamge");
            return (Criteria) this;
        }

        public Criteria andIskeyiamgeLessThan(Byte value) {
            addCriterion("isKeyIamge <", value, "iskeyiamge");
            return (Criteria) this;
        }

        public Criteria andIskeyiamgeLessThanOrEqualTo(Byte value) {
            addCriterion("isKeyIamge <=", value, "iskeyiamge");
            return (Criteria) this;
        }

        public Criteria andIskeyiamgeIn(List<Byte> values) {
            addCriterion("isKeyIamge in", values, "iskeyiamge");
            return (Criteria) this;
        }

        public Criteria andIskeyiamgeNotIn(List<Byte> values) {
            addCriterion("isKeyIamge not in", values, "iskeyiamge");
            return (Criteria) this;
        }

        public Criteria andIskeyiamgeBetween(Byte value1, Byte value2) {
            addCriterion("isKeyIamge between", value1, value2, "iskeyiamge");
            return (Criteria) this;
        }

        public Criteria andIskeyiamgeNotBetween(Byte value1, Byte value2) {
            addCriterion("isKeyIamge not between", value1, value2, "iskeyiamge");
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