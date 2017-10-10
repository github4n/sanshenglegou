package com.linjun.model;

import java.util.ArrayList;
import java.util.List;

public class GoodsAttributeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsAttributeCriteria() {
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

        public Criteria andAttributenameIsNull() {
            addCriterion("attributeName is null");
            return (Criteria) this;
        }

        public Criteria andAttributenameIsNotNull() {
            addCriterion("attributeName is not null");
            return (Criteria) this;
        }

        public Criteria andAttributenameEqualTo(String value) {
            addCriterion("attributeName =", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameNotEqualTo(String value) {
            addCriterion("attributeName <>", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameGreaterThan(String value) {
            addCriterion("attributeName >", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameGreaterThanOrEqualTo(String value) {
            addCriterion("attributeName >=", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameLessThan(String value) {
            addCriterion("attributeName <", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameLessThanOrEqualTo(String value) {
            addCriterion("attributeName <=", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameLike(String value) {
            addCriterion("attributeName like", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameNotLike(String value) {
            addCriterion("attributeName not like", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameIn(List<String> values) {
            addCriterion("attributeName in", values, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameNotIn(List<String> values) {
            addCriterion("attributeName not in", values, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameBetween(String value1, String value2) {
            addCriterion("attributeName between", value1, value2, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameNotBetween(String value1, String value2) {
            addCriterion("attributeName not between", value1, value2, "attributename");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("TypeID is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("TypeID is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Long value) {
            addCriterion("TypeID =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Long value) {
            addCriterion("TypeID <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Long value) {
            addCriterion("TypeID >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Long value) {
            addCriterion("TypeID >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Long value) {
            addCriterion("TypeID <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Long value) {
            addCriterion("TypeID <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Long> values) {
            addCriterion("TypeID in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Long> values) {
            addCriterion("TypeID not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Long value1, Long value2) {
            addCriterion("TypeID between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Long value1, Long value2) {
            addCriterion("TypeID not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andIskeyIsNull() {
            addCriterion("isKey is null");
            return (Criteria) this;
        }

        public Criteria andIskeyIsNotNull() {
            addCriterion("isKey is not null");
            return (Criteria) this;
        }

        public Criteria andIskeyEqualTo(Byte value) {
            addCriterion("isKey =", value, "iskey");
            return (Criteria) this;
        }

        public Criteria andIskeyNotEqualTo(Byte value) {
            addCriterion("isKey <>", value, "iskey");
            return (Criteria) this;
        }

        public Criteria andIskeyGreaterThan(Byte value) {
            addCriterion("isKey >", value, "iskey");
            return (Criteria) this;
        }

        public Criteria andIskeyGreaterThanOrEqualTo(Byte value) {
            addCriterion("isKey >=", value, "iskey");
            return (Criteria) this;
        }

        public Criteria andIskeyLessThan(Byte value) {
            addCriterion("isKey <", value, "iskey");
            return (Criteria) this;
        }

        public Criteria andIskeyLessThanOrEqualTo(Byte value) {
            addCriterion("isKey <=", value, "iskey");
            return (Criteria) this;
        }

        public Criteria andIskeyIn(List<Byte> values) {
            addCriterion("isKey in", values, "iskey");
            return (Criteria) this;
        }

        public Criteria andIskeyNotIn(List<Byte> values) {
            addCriterion("isKey not in", values, "iskey");
            return (Criteria) this;
        }

        public Criteria andIskeyBetween(Byte value1, Byte value2) {
            addCriterion("isKey between", value1, value2, "iskey");
            return (Criteria) this;
        }

        public Criteria andIskeyNotBetween(Byte value1, Byte value2) {
            addCriterion("isKey not between", value1, value2, "iskey");
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