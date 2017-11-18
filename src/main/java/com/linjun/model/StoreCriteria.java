package com.linjun.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreCriteria() {
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

        public Criteria andStorenameIsNull() {
            addCriterion("storeName is null");
            return (Criteria) this;
        }

        public Criteria andStorenameIsNotNull() {
            addCriterion("storeName is not null");
            return (Criteria) this;
        }

        public Criteria andStorenameEqualTo(String value) {
            addCriterion("storeName =", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotEqualTo(String value) {
            addCriterion("storeName <>", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameGreaterThan(String value) {
            addCriterion("storeName >", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameGreaterThanOrEqualTo(String value) {
            addCriterion("storeName >=", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLessThan(String value) {
            addCriterion("storeName <", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLessThanOrEqualTo(String value) {
            addCriterion("storeName <=", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLike(String value) {
            addCriterion("storeName like", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotLike(String value) {
            addCriterion("storeName not like", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameIn(List<String> values) {
            addCriterion("storeName in", values, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotIn(List<String> values) {
            addCriterion("storeName not in", values, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameBetween(String value1, String value2) {
            addCriterion("storeName between", value1, value2, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotBetween(String value1, String value2) {
            addCriterion("storeName not between", value1, value2, "storename");
            return (Criteria) this;
        }

        public Criteria andStoreaddressIsNull() {
            addCriterion("storeAddress is null");
            return (Criteria) this;
        }

        public Criteria andStoreaddressIsNotNull() {
            addCriterion("storeAddress is not null");
            return (Criteria) this;
        }

        public Criteria andStoreaddressEqualTo(String value) {
            addCriterion("storeAddress =", value, "storeaddress");
            return (Criteria) this;
        }

        public Criteria andStoreaddressNotEqualTo(String value) {
            addCriterion("storeAddress <>", value, "storeaddress");
            return (Criteria) this;
        }

        public Criteria andStoreaddressGreaterThan(String value) {
            addCriterion("storeAddress >", value, "storeaddress");
            return (Criteria) this;
        }

        public Criteria andStoreaddressGreaterThanOrEqualTo(String value) {
            addCriterion("storeAddress >=", value, "storeaddress");
            return (Criteria) this;
        }

        public Criteria andStoreaddressLessThan(String value) {
            addCriterion("storeAddress <", value, "storeaddress");
            return (Criteria) this;
        }

        public Criteria andStoreaddressLessThanOrEqualTo(String value) {
            addCriterion("storeAddress <=", value, "storeaddress");
            return (Criteria) this;
        }

        public Criteria andStoreaddressLike(String value) {
            addCriterion("storeAddress like", value, "storeaddress");
            return (Criteria) this;
        }

        public Criteria andStoreaddressNotLike(String value) {
            addCriterion("storeAddress not like", value, "storeaddress");
            return (Criteria) this;
        }

        public Criteria andStoreaddressIn(List<String> values) {
            addCriterion("storeAddress in", values, "storeaddress");
            return (Criteria) this;
        }

        public Criteria andStoreaddressNotIn(List<String> values) {
            addCriterion("storeAddress not in", values, "storeaddress");
            return (Criteria) this;
        }

        public Criteria andStoreaddressBetween(String value1, String value2) {
            addCriterion("storeAddress between", value1, value2, "storeaddress");
            return (Criteria) this;
        }

        public Criteria andStoreaddressNotBetween(String value1, String value2) {
            addCriterion("storeAddress not between", value1, value2, "storeaddress");
            return (Criteria) this;
        }

        public Criteria andStoretypeIsNull() {
            addCriterion("storeType is null");
            return (Criteria) this;
        }

        public Criteria andStoretypeIsNotNull() {
            addCriterion("storeType is not null");
            return (Criteria) this;
        }

        public Criteria andStoretypeEqualTo(String value) {
            addCriterion("storeType =", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeNotEqualTo(String value) {
            addCriterion("storeType <>", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeGreaterThan(String value) {
            addCriterion("storeType >", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeGreaterThanOrEqualTo(String value) {
            addCriterion("storeType >=", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeLessThan(String value) {
            addCriterion("storeType <", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeLessThanOrEqualTo(String value) {
            addCriterion("storeType <=", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeLike(String value) {
            addCriterion("storeType like", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeNotLike(String value) {
            addCriterion("storeType not like", value, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeIn(List<String> values) {
            addCriterion("storeType in", values, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeNotIn(List<String> values) {
            addCriterion("storeType not in", values, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeBetween(String value1, String value2) {
            addCriterion("storeType between", value1, value2, "storetype");
            return (Criteria) this;
        }

        public Criteria andStoretypeNotBetween(String value1, String value2) {
            addCriterion("storeType not between", value1, value2, "storetype");
            return (Criteria) this;
        }

        public Criteria andStorerIsNull() {
            addCriterion("storer is null");
            return (Criteria) this;
        }

        public Criteria andStorerIsNotNull() {
            addCriterion("storer is not null");
            return (Criteria) this;
        }

        public Criteria andStorerEqualTo(String value) {
            addCriterion("storer =", value, "storer");
            return (Criteria) this;
        }

        public Criteria andStorerNotEqualTo(String value) {
            addCriterion("storer <>", value, "storer");
            return (Criteria) this;
        }

        public Criteria andStorerGreaterThan(String value) {
            addCriterion("storer >", value, "storer");
            return (Criteria) this;
        }

        public Criteria andStorerGreaterThanOrEqualTo(String value) {
            addCriterion("storer >=", value, "storer");
            return (Criteria) this;
        }

        public Criteria andStorerLessThan(String value) {
            addCriterion("storer <", value, "storer");
            return (Criteria) this;
        }

        public Criteria andStorerLessThanOrEqualTo(String value) {
            addCriterion("storer <=", value, "storer");
            return (Criteria) this;
        }

        public Criteria andStorerLike(String value) {
            addCriterion("storer like", value, "storer");
            return (Criteria) this;
        }

        public Criteria andStorerNotLike(String value) {
            addCriterion("storer not like", value, "storer");
            return (Criteria) this;
        }

        public Criteria andStorerIn(List<String> values) {
            addCriterion("storer in", values, "storer");
            return (Criteria) this;
        }

        public Criteria andStorerNotIn(List<String> values) {
            addCriterion("storer not in", values, "storer");
            return (Criteria) this;
        }

        public Criteria andStorerBetween(String value1, String value2) {
            addCriterion("storer between", value1, value2, "storer");
            return (Criteria) this;
        }

        public Criteria andStorerNotBetween(String value1, String value2) {
            addCriterion("storer not between", value1, value2, "storer");
            return (Criteria) this;
        }

        public Criteria andStroelogoIsNull() {
            addCriterion("stroelogo is null");
            return (Criteria) this;
        }

        public Criteria andStroelogoIsNotNull() {
            addCriterion("stroelogo is not null");
            return (Criteria) this;
        }

        public Criteria andStroelogoEqualTo(String value) {
            addCriterion("stroelogo =", value, "stroelogo");
            return (Criteria) this;
        }

        public Criteria andStroelogoNotEqualTo(String value) {
            addCriterion("stroelogo <>", value, "stroelogo");
            return (Criteria) this;
        }

        public Criteria andStroelogoGreaterThan(String value) {
            addCriterion("stroelogo >", value, "stroelogo");
            return (Criteria) this;
        }

        public Criteria andStroelogoGreaterThanOrEqualTo(String value) {
            addCriterion("stroelogo >=", value, "stroelogo");
            return (Criteria) this;
        }

        public Criteria andStroelogoLessThan(String value) {
            addCriterion("stroelogo <", value, "stroelogo");
            return (Criteria) this;
        }

        public Criteria andStroelogoLessThanOrEqualTo(String value) {
            addCriterion("stroelogo <=", value, "stroelogo");
            return (Criteria) this;
        }

        public Criteria andStroelogoLike(String value) {
            addCriterion("stroelogo like", value, "stroelogo");
            return (Criteria) this;
        }

        public Criteria andStroelogoNotLike(String value) {
            addCriterion("stroelogo not like", value, "stroelogo");
            return (Criteria) this;
        }

        public Criteria andStroelogoIn(List<String> values) {
            addCriterion("stroelogo in", values, "stroelogo");
            return (Criteria) this;
        }

        public Criteria andStroelogoNotIn(List<String> values) {
            addCriterion("stroelogo not in", values, "stroelogo");
            return (Criteria) this;
        }

        public Criteria andStroelogoBetween(String value1, String value2) {
            addCriterion("stroelogo between", value1, value2, "stroelogo");
            return (Criteria) this;
        }

        public Criteria andStroelogoNotBetween(String value1, String value2) {
            addCriterion("stroelogo not between", value1, value2, "stroelogo");
            return (Criteria) this;
        }

        public Criteria andScopeIsNull() {
            addCriterion("scope is null");
            return (Criteria) this;
        }

        public Criteria andScopeIsNotNull() {
            addCriterion("scope is not null");
            return (Criteria) this;
        }

        public Criteria andScopeEqualTo(String value) {
            addCriterion("scope =", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotEqualTo(String value) {
            addCriterion("scope <>", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThan(String value) {
            addCriterion("scope >", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThanOrEqualTo(String value) {
            addCriterion("scope >=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThan(String value) {
            addCriterion("scope <", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThanOrEqualTo(String value) {
            addCriterion("scope <=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLike(String value) {
            addCriterion("scope like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotLike(String value) {
            addCriterion("scope not like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeIn(List<String> values) {
            addCriterion("scope in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotIn(List<String> values) {
            addCriterion("scope not in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeBetween(String value1, String value2) {
            addCriterion("scope between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotBetween(String value1, String value2) {
            addCriterion("scope not between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andIsauthIsNull() {
            addCriterion("isAuth is null");
            return (Criteria) this;
        }

        public Criteria andIsauthIsNotNull() {
            addCriterion("isAuth is not null");
            return (Criteria) this;
        }

        public Criteria andIsauthEqualTo(Byte value) {
            addCriterion("isAuth =", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthNotEqualTo(Byte value) {
            addCriterion("isAuth <>", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthGreaterThan(Byte value) {
            addCriterion("isAuth >", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthGreaterThanOrEqualTo(Byte value) {
            addCriterion("isAuth >=", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthLessThan(Byte value) {
            addCriterion("isAuth <", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthLessThanOrEqualTo(Byte value) {
            addCriterion("isAuth <=", value, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthIn(List<Byte> values) {
            addCriterion("isAuth in", values, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthNotIn(List<Byte> values) {
            addCriterion("isAuth not in", values, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthBetween(Byte value1, Byte value2) {
            addCriterion("isAuth between", value1, value2, "isauth");
            return (Criteria) this;
        }

        public Criteria andIsauthNotBetween(Byte value1, Byte value2) {
            addCriterion("isAuth not between", value1, value2, "isauth");
            return (Criteria) this;
        }

        public Criteria andStoreuseridIsNull() {
            addCriterion("storeUserID is null");
            return (Criteria) this;
        }

        public Criteria andStoreuseridIsNotNull() {
            addCriterion("storeUserID is not null");
            return (Criteria) this;
        }

        public Criteria andStoreuseridEqualTo(Long value) {
            addCriterion("storeUserID =", value, "storeuserid");
            return (Criteria) this;
        }

        public Criteria andStoreuseridNotEqualTo(Long value) {
            addCriterion("storeUserID <>", value, "storeuserid");
            return (Criteria) this;
        }

        public Criteria andStoreuseridGreaterThan(Long value) {
            addCriterion("storeUserID >", value, "storeuserid");
            return (Criteria) this;
        }

        public Criteria andStoreuseridGreaterThanOrEqualTo(Long value) {
            addCriterion("storeUserID >=", value, "storeuserid");
            return (Criteria) this;
        }

        public Criteria andStoreuseridLessThan(Long value) {
            addCriterion("storeUserID <", value, "storeuserid");
            return (Criteria) this;
        }

        public Criteria andStoreuseridLessThanOrEqualTo(Long value) {
            addCriterion("storeUserID <=", value, "storeuserid");
            return (Criteria) this;
        }

        public Criteria andStoreuseridIn(List<Long> values) {
            addCriterion("storeUserID in", values, "storeuserid");
            return (Criteria) this;
        }

        public Criteria andStoreuseridNotIn(List<Long> values) {
            addCriterion("storeUserID not in", values, "storeuserid");
            return (Criteria) this;
        }

        public Criteria andStoreuseridBetween(Long value1, Long value2) {
            addCriterion("storeUserID between", value1, value2, "storeuserid");
            return (Criteria) this;
        }

        public Criteria andStoreuseridNotBetween(Long value1, Long value2) {
            addCriterion("storeUserID not between", value1, value2, "storeuserid");
            return (Criteria) this;
        }

        public Criteria andPassworldIsNull() {
            addCriterion("passworld is null");
            return (Criteria) this;
        }

        public Criteria andPassworldIsNotNull() {
            addCriterion("passworld is not null");
            return (Criteria) this;
        }

        public Criteria andPassworldEqualTo(String value) {
            addCriterion("passworld =", value, "passworld");
            return (Criteria) this;
        }

        public Criteria andPassworldNotEqualTo(String value) {
            addCriterion("passworld <>", value, "passworld");
            return (Criteria) this;
        }

        public Criteria andPassworldGreaterThan(String value) {
            addCriterion("passworld >", value, "passworld");
            return (Criteria) this;
        }

        public Criteria andPassworldGreaterThanOrEqualTo(String value) {
            addCriterion("passworld >=", value, "passworld");
            return (Criteria) this;
        }

        public Criteria andPassworldLessThan(String value) {
            addCriterion("passworld <", value, "passworld");
            return (Criteria) this;
        }

        public Criteria andPassworldLessThanOrEqualTo(String value) {
            addCriterion("passworld <=", value, "passworld");
            return (Criteria) this;
        }

        public Criteria andPassworldLike(String value) {
            addCriterion("passworld like", value, "passworld");
            return (Criteria) this;
        }

        public Criteria andPassworldNotLike(String value) {
            addCriterion("passworld not like", value, "passworld");
            return (Criteria) this;
        }

        public Criteria andPassworldIn(List<String> values) {
            addCriterion("passworld in", values, "passworld");
            return (Criteria) this;
        }

        public Criteria andPassworldNotIn(List<String> values) {
            addCriterion("passworld not in", values, "passworld");
            return (Criteria) this;
        }

        public Criteria andPassworldBetween(String value1, String value2) {
            addCriterion("passworld between", value1, value2, "passworld");
            return (Criteria) this;
        }

        public Criteria andPassworldNotBetween(String value1, String value2) {
            addCriterion("passworld not between", value1, value2, "passworld");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("introduce is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("introduce is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("introduce =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("introduce <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("introduce >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("introduce >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("introduce <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("introduce <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("introduce like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("introduce not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("introduce in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("introduce not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("introduce between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("introduce not between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
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