package com.linjun.pojo;

public class AdminCreditOrder {
    private Long id;

    private Long userid;

    private  String name;
    private String goodsname;

    private Long goodsid;

    private Long addressid;

    private String address;

    private String tel;

    private String resvicePepple;

    private Long pricce;

    private String createtime;

    private String logistics;

    private Long logisticscode;

    private Byte ispay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public Long getAddressid() {
        return addressid;
    }

    public void setAddressid(Long addressid) {
        this.addressid = addressid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getResvicePepple() {
        return resvicePepple;
    }

    public void setResvicePepple(String resvicePepple) {
        this.resvicePepple = resvicePepple;
    }

    public Long getPricce() {
        return pricce;
    }

    public void setPricce(Long pricce) {
        this.pricce = pricce;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    public Long getLogisticscode() {
        return logisticscode;
    }

    public void setLogisticscode(Long logisticscode) {
        this.logisticscode = logisticscode;
    }

    public Byte getIspay() {
        return ispay;
    }

    public void setIspay(Byte ispay) {
        this.ispay = ispay;
    }
}
