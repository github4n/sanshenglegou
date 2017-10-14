package com.linjun.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderCriteria() {
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

        public Criteria andStoreidIsNull() {
            addCriterion("storeID is null");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNotNull() {
            addCriterion("storeID is not null");
            return (Criteria) this;
        }

        public Criteria andStoreidEqualTo(Long value) {
            addCriterion("storeID =", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotEqualTo(Long value) {
            addCriterion("storeID <>", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThan(Long value) {
            addCriterion("storeID >", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThanOrEqualTo(Long value) {
            addCriterion("storeID >=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThan(Long value) {
            addCriterion("storeID <", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThanOrEqualTo(Long value) {
            addCriterion("storeID <=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidIn(List<Long> values) {
            addCriterion("storeID in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotIn(List<Long> values) {
            addCriterion("storeID not in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidBetween(Long value1, Long value2) {
            addCriterion("storeID between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotBetween(Long value1, Long value2) {
            addCriterion("storeID not between", value1, value2, "storeid");
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

        public Criteria andGoodsnameIsNull() {
            addCriterion("goodsName is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNotNull() {
            addCriterion("goodsName is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameEqualTo(String value) {
            addCriterion("goodsName =", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotEqualTo(String value) {
            addCriterion("goodsName <>", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThan(String value) {
            addCriterion("goodsName >", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThanOrEqualTo(String value) {
            addCriterion("goodsName >=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThan(String value) {
            addCriterion("goodsName <", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThanOrEqualTo(String value) {
            addCriterion("goodsName <=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLike(String value) {
            addCriterion("goodsName like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotLike(String value) {
            addCriterion("goodsName not like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIn(List<String> values) {
            addCriterion("goodsName in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotIn(List<String> values) {
            addCriterion("goodsName not in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameBetween(String value1, String value2) {
            addCriterion("goodsName between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotBetween(String value1, String value2) {
            addCriterion("goodsName not between", value1, value2, "goodsname");
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

        public Criteria andMarketpricceIsNull() {
            addCriterion("marketPricce is null");
            return (Criteria) this;
        }

        public Criteria andMarketpricceIsNotNull() {
            addCriterion("marketPricce is not null");
            return (Criteria) this;
        }

        public Criteria andMarketpricceEqualTo(Long value) {
            addCriterion("marketPricce =", value, "marketpricce");
            return (Criteria) this;
        }

        public Criteria andMarketpricceNotEqualTo(Long value) {
            addCriterion("marketPricce <>", value, "marketpricce");
            return (Criteria) this;
        }

        public Criteria andMarketpricceGreaterThan(Long value) {
            addCriterion("marketPricce >", value, "marketpricce");
            return (Criteria) this;
        }

        public Criteria andMarketpricceGreaterThanOrEqualTo(Long value) {
            addCriterion("marketPricce >=", value, "marketpricce");
            return (Criteria) this;
        }

        public Criteria andMarketpricceLessThan(Long value) {
            addCriterion("marketPricce <", value, "marketpricce");
            return (Criteria) this;
        }

        public Criteria andMarketpricceLessThanOrEqualTo(Long value) {
            addCriterion("marketPricce <=", value, "marketpricce");
            return (Criteria) this;
        }

        public Criteria andMarketpricceIn(List<Long> values) {
            addCriterion("marketPricce in", values, "marketpricce");
            return (Criteria) this;
        }

        public Criteria andMarketpricceNotIn(List<Long> values) {
            addCriterion("marketPricce not in", values, "marketpricce");
            return (Criteria) this;
        }

        public Criteria andMarketpricceBetween(Long value1, Long value2) {
            addCriterion("marketPricce between", value1, value2, "marketpricce");
            return (Criteria) this;
        }

        public Criteria andMarketpricceNotBetween(Long value1, Long value2) {
            addCriterion("marketPricce not between", value1, value2, "marketpricce");
            return (Criteria) this;
        }

        public Criteria andMemberpriceIsNull() {
            addCriterion("memberPrice is null");
            return (Criteria) this;
        }

        public Criteria andMemberpriceIsNotNull() {
            addCriterion("memberPrice is not null");
            return (Criteria) this;
        }

        public Criteria andMemberpriceEqualTo(Long value) {
            addCriterion("memberPrice =", value, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceNotEqualTo(Long value) {
            addCriterion("memberPrice <>", value, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceGreaterThan(Long value) {
            addCriterion("memberPrice >", value, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("memberPrice >=", value, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceLessThan(Long value) {
            addCriterion("memberPrice <", value, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceLessThanOrEqualTo(Long value) {
            addCriterion("memberPrice <=", value, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceIn(List<Long> values) {
            addCriterion("memberPrice in", values, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceNotIn(List<Long> values) {
            addCriterion("memberPrice not in", values, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceBetween(Long value1, Long value2) {
            addCriterion("memberPrice between", value1, value2, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceNotBetween(Long value1, Long value2) {
            addCriterion("memberPrice not between", value1, value2, "memberprice");
            return (Criteria) this;
        }

        public Criteria andGoodsumIsNull() {
            addCriterion("goodSum is null");
            return (Criteria) this;
        }

        public Criteria andGoodsumIsNotNull() {
            addCriterion("goodSum is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsumEqualTo(Integer value) {
            addCriterion("goodSum =", value, "goodsum");
            return (Criteria) this;
        }

        public Criteria andGoodsumNotEqualTo(Integer value) {
            addCriterion("goodSum <>", value, "goodsum");
            return (Criteria) this;
        }

        public Criteria andGoodsumGreaterThan(Integer value) {
            addCriterion("goodSum >", value, "goodsum");
            return (Criteria) this;
        }

        public Criteria andGoodsumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodSum >=", value, "goodsum");
            return (Criteria) this;
        }

        public Criteria andGoodsumLessThan(Integer value) {
            addCriterion("goodSum <", value, "goodsum");
            return (Criteria) this;
        }

        public Criteria andGoodsumLessThanOrEqualTo(Integer value) {
            addCriterion("goodSum <=", value, "goodsum");
            return (Criteria) this;
        }

        public Criteria andGoodsumIn(List<Integer> values) {
            addCriterion("goodSum in", values, "goodsum");
            return (Criteria) this;
        }

        public Criteria andGoodsumNotIn(List<Integer> values) {
            addCriterion("goodSum not in", values, "goodsum");
            return (Criteria) this;
        }

        public Criteria andGoodsumBetween(Integer value1, Integer value2) {
            addCriterion("goodSum between", value1, value2, "goodsum");
            return (Criteria) this;
        }

        public Criteria andGoodsumNotBetween(Integer value1, Integer value2) {
            addCriterion("goodSum not between", value1, value2, "goodsum");
            return (Criteria) this;
        }

        public Criteria andPricesumIsNull() {
            addCriterion("priceSum is null");
            return (Criteria) this;
        }

        public Criteria andPricesumIsNotNull() {
            addCriterion("priceSum is not null");
            return (Criteria) this;
        }

        public Criteria andPricesumEqualTo(Integer value) {
            addCriterion("priceSum =", value, "pricesum");
            return (Criteria) this;
        }

        public Criteria andPricesumNotEqualTo(Integer value) {
            addCriterion("priceSum <>", value, "pricesum");
            return (Criteria) this;
        }

        public Criteria andPricesumGreaterThan(Integer value) {
            addCriterion("priceSum >", value, "pricesum");
            return (Criteria) this;
        }

        public Criteria andPricesumGreaterThanOrEqualTo(Integer value) {
            addCriterion("priceSum >=", value, "pricesum");
            return (Criteria) this;
        }

        public Criteria andPricesumLessThan(Integer value) {
            addCriterion("priceSum <", value, "pricesum");
            return (Criteria) this;
        }

        public Criteria andPricesumLessThanOrEqualTo(Integer value) {
            addCriterion("priceSum <=", value, "pricesum");
            return (Criteria) this;
        }

        public Criteria andPricesumIn(List<Integer> values) {
            addCriterion("priceSum in", values, "pricesum");
            return (Criteria) this;
        }

        public Criteria andPricesumNotIn(List<Integer> values) {
            addCriterion("priceSum not in", values, "pricesum");
            return (Criteria) this;
        }

        public Criteria andPricesumBetween(Integer value1, Integer value2) {
            addCriterion("priceSum between", value1, value2, "pricesum");
            return (Criteria) this;
        }

        public Criteria andPricesumNotBetween(Integer value1, Integer value2) {
            addCriterion("priceSum not between", value1, value2, "pricesum");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendTime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendTime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("sendTime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("sendTime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("sendTime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendTime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("sendTime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("sendTime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("sendTime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("sendTime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("sendTime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("sendTime not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andLogisticsIsNull() {
            addCriterion("logistics is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIsNotNull() {
            addCriterion("logistics is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsEqualTo(String value) {
            addCriterion("logistics =", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsNotEqualTo(String value) {
            addCriterion("logistics <>", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsGreaterThan(String value) {
            addCriterion("logistics >", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsGreaterThanOrEqualTo(String value) {
            addCriterion("logistics >=", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsLessThan(String value) {
            addCriterion("logistics <", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsLessThanOrEqualTo(String value) {
            addCriterion("logistics <=", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsLike(String value) {
            addCriterion("logistics like", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsNotLike(String value) {
            addCriterion("logistics not like", value, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsIn(List<String> values) {
            addCriterion("logistics in", values, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsNotIn(List<String> values) {
            addCriterion("logistics not in", values, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsBetween(String value1, String value2) {
            addCriterion("logistics between", value1, value2, "logistics");
            return (Criteria) this;
        }

        public Criteria andLogisticsNotBetween(String value1, String value2) {
            addCriterion("logistics not between", value1, value2, "logistics");
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

        public Criteria andIsreceiveIsNull() {
            addCriterion("isreceive is null");
            return (Criteria) this;
        }

        public Criteria andIsreceiveIsNotNull() {
            addCriterion("isreceive is not null");
            return (Criteria) this;
        }

        public Criteria andIsreceiveEqualTo(Byte value) {
            addCriterion("isreceive =", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveNotEqualTo(Byte value) {
            addCriterion("isreceive <>", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveGreaterThan(Byte value) {
            addCriterion("isreceive >", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveGreaterThanOrEqualTo(Byte value) {
            addCriterion("isreceive >=", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveLessThan(Byte value) {
            addCriterion("isreceive <", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveLessThanOrEqualTo(Byte value) {
            addCriterion("isreceive <=", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveIn(List<Byte> values) {
            addCriterion("isreceive in", values, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveNotIn(List<Byte> values) {
            addCriterion("isreceive not in", values, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveBetween(Byte value1, Byte value2) {
            addCriterion("isreceive between", value1, value2, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveNotBetween(Byte value1, Byte value2) {
            addCriterion("isreceive not between", value1, value2, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIspayIsNull() {
            addCriterion("isPay is null");
            return (Criteria) this;
        }

        public Criteria andIspayIsNotNull() {
            addCriterion("isPay is not null");
            return (Criteria) this;
        }

        public Criteria andIspayEqualTo(Byte value) {
            addCriterion("isPay =", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayNotEqualTo(Byte value) {
            addCriterion("isPay <>", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayGreaterThan(Byte value) {
            addCriterion("isPay >", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayGreaterThanOrEqualTo(Byte value) {
            addCriterion("isPay >=", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayLessThan(Byte value) {
            addCriterion("isPay <", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayLessThanOrEqualTo(Byte value) {
            addCriterion("isPay <=", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayIn(List<Byte> values) {
            addCriterion("isPay in", values, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayNotIn(List<Byte> values) {
            addCriterion("isPay not in", values, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayBetween(Byte value1, Byte value2) {
            addCriterion("isPay between", value1, value2, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayNotBetween(Byte value1, Byte value2) {
            addCriterion("isPay not between", value1, value2, "ispay");
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