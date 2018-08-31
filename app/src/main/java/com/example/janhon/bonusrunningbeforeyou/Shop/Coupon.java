package com.example.janhon.bonusrunningbeforeyou.Shop;

public class Coupon {
    private String couponid; // 優惠卷名稱
    private int image; // 優惠卷照片
    private String quantity; // 數量
    private String price; //價格


    public Coupon(String couponid, int image, String quantity, String price) {
        super();
        this.couponid = couponid;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCouponid() {
        return couponid;
    }

    public void setCouponid(String couponid) {
        this.couponid = couponid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
