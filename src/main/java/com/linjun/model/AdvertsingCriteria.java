package com.linjun.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvertsingCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvertsingCriteria() {
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

        public Criteria andBodyIsNull() {
            addCriterion("body is null");
            return (Criteria) this;
        }

        public Criteria andBodyIsNotNull() {
            addCriterion("body is not null");
            return (Criteria) this;
        }

        public Criteria andBodyEqualTo(String value) {
            addCriterion("body =", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotEqualTo(String value) {
            addCriterion("body <>", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThan(String value) {
            addCriterion("body >", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThanOrEqualTo(String value) {
            addCriterion("body >=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThan(String value) {
            addCriterion("body <", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThanOrEqualTo(String value) {
            addCriterion("body <=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLike(String value) {
            addCriterion("body like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotLike(String value) {
            addCriterion("body not like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyIn(List<String> values) {
            addCriterion("body in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotIn(List<String> values) {
            addCriterion("body not in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyBetween(String value1, String value2) {
            addCriterion("body between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotBetween(String value1, String value2) {
            addCriterion("body not between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andLinkurlIsNull() {
            addCriterion("linkUrl is null");
            return (Criteria) this;
        }

        public Criteria andLinkurlIsNotNull() {
            addCriterion("linkUrl is not null");
            return (Criteria) this;
        }

        public Criteria andLinkurlEqualTo(String value) {
            addCriterion("linkUrl =", value, "linkurl");
            return (Criteria) this;
        }

        public Criteria andLinkurlNotEqualTo(String value) {
            addCriterion("linkUrl <>", value, "linkurl");
            return (Criteria) this;
        }

        public Criteria andLinkurlGreaterThan(String value) {
            addCriterion("linkUrl >", value, "linkurl");
            return (Criteria) this;
        }

        public Criteria andLinkurlGreaterThanOrEqualTo(String value) {
            addCriterion("linkUrl >=", value, "linkurl");
            return (Criteria) this;
        }

        public Criteria andLinkurlLessThan(String value) {
            addCriterion("linkUrl <", value, "linkurl");
            return (Criteria) this;
        }

        public Criteria andLinkurlLessThanOrEqualTo(String value) {
            addCriterion("linkUrl <=", value, "linkurl");
            return (Criteria) this;
        }

        public Criteria andLinkurlLike(String value) {
            addCriterion("linkUrl like", value, "linkurl");
            return (Criteria) this;
        }

        public Criteria andLinkurlNotLike(String value) {
            addCriterion("linkUrl not like", value, "linkurl");
            return (Criteria) this;
        }

        public Criteria andLinkurlIn(List<String> values) {
            addCriterion("linkUrl in", values, "linkurl");
            return (Criteria) this;
        }

        public Criteria andLinkurlNotIn(List<String> values) {
            addCriterion("linkUrl not in", values, "linkurl");
            return (Criteria) this;
        }

        public Criteria andLinkurlBetween(String value1, String value2) {
            addCriterion("linkUrl between", value1, value2, "linkurl");
            return (Criteria) this;
        }

        public Criteria andLinkurlNotBetween(String value1, String value2) {
            addCriterion("linkUrl not between", value1, value2, "linkurl");
            return (Criteria) this;
        }

        public Criteria andImageidIsNull() {
            addCriterion("imageId is null");
            return (Criteria) this;
        }

        public Criteria andImageidIsNotNull() {
            addCriterion("imageId is not null");
            return (Criteria) this;
        }

        public Criteria andImageidEqualTo(Long value) {
            addCriterion("imageId =", value, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidNotEqualTo(Long value) {
            addCriterion("imageId <>", value, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidGreaterThan(Long value) {
            addCriterion("imageId >", value, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidGreaterThanOrEqualTo(Long value) {
            addCriterion("imageId >=", value, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidLessThan(Long value) {
            addCriterion("imageId <", value, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidLessThanOrEqualTo(Long value) {
            addCriterion("imageId <=", value, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidIn(List<Long> values) {
            addCriterion("imageId in", values, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidNotIn(List<Long> values) {
            addCriterion("imageId not in", values, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidBetween(Long value1, Long value2) {
            addCriterion("imageId between", value1, value2, "imageid");
            return (Criteria) this;
        }

        public Criteria andImageidNotBetween(Long value1, Long value2) {
            addCriterion("imageId not between", value1, value2, "imageid");
            return (Criteria) this;
        }

        public Criteria andStardateIsNull() {
            addCriterion("stardate is null");
            return (Criteria) this;
        }

        public Criteria andStardateIsNotNull() {
            addCriterion("stardate is not null");
            return (Criteria) this;
        }

        public Criteria andStardateEqualTo(Date value) {
            addCriterion("stardate =", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateNotEqualTo(Date value) {
            addCriterion("stardate <>", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateGreaterThan(Date value) {
            addCriterion("stardate >", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateGreaterThanOrEqualTo(Date value) {
            addCriterion("stardate >=", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateLessThan(Date value) {
            addCriterion("stardate <", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateLessThanOrEqualTo(Date value) {
            addCriterion("stardate <=", value, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateIn(List<Date> values) {
            addCriterion("stardate in", values, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateNotIn(List<Date> values) {
            addCriterion("stardate not in", values, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateBetween(Date value1, Date value2) {
            addCriterion("stardate between", value1, value2, "stardate");
            return (Criteria) this;
        }

        public Criteria andStardateNotBetween(Date value1, Date value2) {
            addCriterion("stardate not between", value1, value2, "stardate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("enddate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("enddate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterion("enddate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterion("enddate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterion("enddate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterion("enddate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterion("enddate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterion("enddate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterion("enddate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterion("enddate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterion("enddate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterion("enddate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andDatacreateIsNull() {
            addCriterion("dataCreate is null");
            return (Criteria) this;
        }

        public Criteria andDatacreateIsNotNull() {
            addCriterion("dataCreate is not null");
            return (Criteria) this;
        }

        public Criteria andDatacreateEqualTo(Date value) {
            addCriterion("dataCreate =", value, "datacreate");
            return (Criteria) this;
        }

        public Criteria andDatacreateNotEqualTo(Date value) {
            addCriterion("dataCreate <>", value, "datacreate");
            return (Criteria) this;
        }

        public Criteria andDatacreateGreaterThan(Date value) {
            addCriterion("dataCreate >", value, "datacreate");
            return (Criteria) this;
        }

        public Criteria andDatacreateGreaterThanOrEqualTo(Date value) {
            addCriterion("dataCreate >=", value, "datacreate");
            return (Criteria) this;
        }

        public Criteria andDatacreateLessThan(Date value) {
            addCriterion("dataCreate <", value, "datacreate");
            return (Criteria) this;
        }

        public Criteria andDatacreateLessThanOrEqualTo(Date value) {
            addCriterion("dataCreate <=", value, "datacreate");
            return (Criteria) this;
        }

        public Criteria andDatacreateIn(List<Date> values) {
            addCriterion("dataCreate in", values, "datacreate");
            return (Criteria) this;
        }

        public Criteria andDatacreateNotIn(List<Date> values) {
            addCriterion("dataCreate not in", values, "datacreate");
            return (Criteria) this;
        }

        public Criteria andDatacreateBetween(Date value1, Date value2) {
            addCriterion("dataCreate between", value1, value2, "datacreate");
            return (Criteria) this;
        }

        public Criteria andDatacreateNotBetween(Date value1, Date value2) {
            addCriterion("dataCreate not between", value1, value2, "datacreate");
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