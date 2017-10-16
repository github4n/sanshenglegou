package com.linjun.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsCriteria() {
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

        public Criteria andGoodsbandidIsNull() {
            addCriterion("goodsBandID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsbandidIsNotNull() {
            addCriterion("goodsBandID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsbandidEqualTo(Long value) {
            addCriterion("goodsBandID =", value, "goodsbandid");
            return (Criteria) this;
        }

        public Criteria andGoodsbandidNotEqualTo(Long value) {
            addCriterion("goodsBandID <>", value, "goodsbandid");
            return (Criteria) this;
        }

        public Criteria andGoodsbandidGreaterThan(Long value) {
            addCriterion("goodsBandID >", value, "goodsbandid");
            return (Criteria) this;
        }

        public Criteria andGoodsbandidGreaterThanOrEqualTo(Long value) {
            addCriterion("goodsBandID >=", value, "goodsbandid");
            return (Criteria) this;
        }

        public Criteria andGoodsbandidLessThan(Long value) {
            addCriterion("goodsBandID <", value, "goodsbandid");
            return (Criteria) this;
        }

        public Criteria andGoodsbandidLessThanOrEqualTo(Long value) {
            addCriterion("goodsBandID <=", value, "goodsbandid");
            return (Criteria) this;
        }

        public Criteria andGoodsbandidIn(List<Long> values) {
            addCriterion("goodsBandID in", values, "goodsbandid");
            return (Criteria) this;
        }

        public Criteria andGoodsbandidNotIn(List<Long> values) {
            addCriterion("goodsBandID not in", values, "goodsbandid");
            return (Criteria) this;
        }

        public Criteria andGoodsbandidBetween(Long value1, Long value2) {
            addCriterion("goodsBandID between", value1, value2, "goodsbandid");
            return (Criteria) this;
        }

        public Criteria andGoodsbandidNotBetween(Long value1, Long value2) {
            addCriterion("goodsBandID not between", value1, value2, "goodsbandid");
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

        public Criteria andGoodssumIsNull() {
            addCriterion("goodsSum is null");
            return (Criteria) this;
        }

        public Criteria andGoodssumIsNotNull() {
            addCriterion("goodsSum is not null");
            return (Criteria) this;
        }

        public Criteria andGoodssumEqualTo(Long value) {
            addCriterion("goodsSum =", value, "goodssum");
            return (Criteria) this;
        }

        public Criteria andGoodssumNotEqualTo(Long value) {
            addCriterion("goodsSum <>", value, "goodssum");
            return (Criteria) this;
        }

        public Criteria andGoodssumGreaterThan(Long value) {
            addCriterion("goodsSum >", value, "goodssum");
            return (Criteria) this;
        }

        public Criteria andGoodssumGreaterThanOrEqualTo(Long value) {
            addCriterion("goodsSum >=", value, "goodssum");
            return (Criteria) this;
        }

        public Criteria andGoodssumLessThan(Long value) {
            addCriterion("goodsSum <", value, "goodssum");
            return (Criteria) this;
        }

        public Criteria andGoodssumLessThanOrEqualTo(Long value) {
            addCriterion("goodsSum <=", value, "goodssum");
            return (Criteria) this;
        }

        public Criteria andGoodssumIn(List<Long> values) {
            addCriterion("goodsSum in", values, "goodssum");
            return (Criteria) this;
        }

        public Criteria andGoodssumNotIn(List<Long> values) {
            addCriterion("goodsSum not in", values, "goodssum");
            return (Criteria) this;
        }

        public Criteria andGoodssumBetween(Long value1, Long value2) {
            addCriterion("goodsSum between", value1, value2, "goodssum");
            return (Criteria) this;
        }

        public Criteria andGoodssumNotBetween(Long value1, Long value2) {
            addCriterion("goodsSum not between", value1, value2, "goodssum");
            return (Criteria) this;
        }

        public Criteria andMarketpriveIsNull() {
            addCriterion("marketPrive is null");
            return (Criteria) this;
        }

        public Criteria andMarketpriveIsNotNull() {
            addCriterion("marketPrive is not null");
            return (Criteria) this;
        }

        public Criteria andMarketpriveEqualTo(Float value) {
            addCriterion("marketPrive =", value, "marketprive");
            return (Criteria) this;
        }

        public Criteria andMarketpriveNotEqualTo(Float value) {
            addCriterion("marketPrive <>", value, "marketprive");
            return (Criteria) this;
        }

        public Criteria andMarketpriveGreaterThan(Float value) {
            addCriterion("marketPrive >", value, "marketprive");
            return (Criteria) this;
        }

        public Criteria andMarketpriveGreaterThanOrEqualTo(Float value) {
            addCriterion("marketPrive >=", value, "marketprive");
            return (Criteria) this;
        }

        public Criteria andMarketpriveLessThan(Float value) {
            addCriterion("marketPrive <", value, "marketprive");
            return (Criteria) this;
        }

        public Criteria andMarketpriveLessThanOrEqualTo(Float value) {
            addCriterion("marketPrive <=", value, "marketprive");
            return (Criteria) this;
        }

        public Criteria andMarketpriveIn(List<Float> values) {
            addCriterion("marketPrive in", values, "marketprive");
            return (Criteria) this;
        }

        public Criteria andMarketpriveNotIn(List<Float> values) {
            addCriterion("marketPrive not in", values, "marketprive");
            return (Criteria) this;
        }

        public Criteria andMarketpriveBetween(Float value1, Float value2) {
            addCriterion("marketPrive between", value1, value2, "marketprive");
            return (Criteria) this;
        }

        public Criteria andMarketpriveNotBetween(Float value1, Float value2) {
            addCriterion("marketPrive not between", value1, value2, "marketprive");
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

        public Criteria andMemberpriceEqualTo(Float value) {
            addCriterion("memberPrice =", value, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceNotEqualTo(Float value) {
            addCriterion("memberPrice <>", value, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceGreaterThan(Float value) {
            addCriterion("memberPrice >", value, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceGreaterThanOrEqualTo(Float value) {
            addCriterion("memberPrice >=", value, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceLessThan(Float value) {
            addCriterion("memberPrice <", value, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceLessThanOrEqualTo(Float value) {
            addCriterion("memberPrice <=", value, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceIn(List<Float> values) {
            addCriterion("memberPrice in", values, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceNotIn(List<Float> values) {
            addCriterion("memberPrice not in", values, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceBetween(Float value1, Float value2) {
            addCriterion("memberPrice between", value1, value2, "memberprice");
            return (Criteria) this;
        }

        public Criteria andMemberpriceNotBetween(Float value1, Float value2) {
            addCriterion("memberPrice not between", value1, value2, "memberprice");
            return (Criteria) this;
        }

        public Criteria andSendcreditIsNull() {
            addCriterion("sendCredit is null");
            return (Criteria) this;
        }

        public Criteria andSendcreditIsNotNull() {
            addCriterion("sendCredit is not null");
            return (Criteria) this;
        }

        public Criteria andSendcreditEqualTo(Integer value) {
            addCriterion("sendCredit =", value, "sendcredit");
            return (Criteria) this;
        }

        public Criteria andSendcreditNotEqualTo(Integer value) {
            addCriterion("sendCredit <>", value, "sendcredit");
            return (Criteria) this;
        }

        public Criteria andSendcreditGreaterThan(Integer value) {
            addCriterion("sendCredit >", value, "sendcredit");
            return (Criteria) this;
        }

        public Criteria andSendcreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("sendCredit >=", value, "sendcredit");
            return (Criteria) this;
        }

        public Criteria andSendcreditLessThan(Integer value) {
            addCriterion("sendCredit <", value, "sendcredit");
            return (Criteria) this;
        }

        public Criteria andSendcreditLessThanOrEqualTo(Integer value) {
            addCriterion("sendCredit <=", value, "sendcredit");
            return (Criteria) this;
        }

        public Criteria andSendcreditIn(List<Integer> values) {
            addCriterion("sendCredit in", values, "sendcredit");
            return (Criteria) this;
        }

        public Criteria andSendcreditNotIn(List<Integer> values) {
            addCriterion("sendCredit not in", values, "sendcredit");
            return (Criteria) this;
        }

        public Criteria andSendcreditBetween(Integer value1, Integer value2) {
            addCriterion("sendCredit between", value1, value2, "sendcredit");
            return (Criteria) this;
        }

        public Criteria andSendcreditNotBetween(Integer value1, Integer value2) {
            addCriterion("sendCredit not between", value1, value2, "sendcredit");
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

        public Criteria andShopIsNull() {
            addCriterion("shop is null");
            return (Criteria) this;
        }

        public Criteria andShopIsNotNull() {
            addCriterion("shop is not null");
            return (Criteria) this;
        }

        public Criteria andShopEqualTo(String value) {
            addCriterion("shop =", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopNotEqualTo(String value) {
            addCriterion("shop <>", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopGreaterThan(String value) {
            addCriterion("shop >", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopGreaterThanOrEqualTo(String value) {
            addCriterion("shop >=", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopLessThan(String value) {
            addCriterion("shop <", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopLessThanOrEqualTo(String value) {
            addCriterion("shop <=", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopLike(String value) {
            addCriterion("shop like", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopNotLike(String value) {
            addCriterion("shop not like", value, "shop");
            return (Criteria) this;
        }

        public Criteria andShopIn(List<String> values) {
            addCriterion("shop in", values, "shop");
            return (Criteria) this;
        }

        public Criteria andShopNotIn(List<String> values) {
            addCriterion("shop not in", values, "shop");
            return (Criteria) this;
        }

        public Criteria andShopBetween(String value1, String value2) {
            addCriterion("shop between", value1, value2, "shop");
            return (Criteria) this;
        }

        public Criteria andShopNotBetween(String value1, String value2) {
            addCriterion("shop not between", value1, value2, "shop");
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