package com.example.janhon.bonusrunningbeforeyou.social.gamedetail;


/*
*
*
* @justin
* @9/2
*   賽事的參加頁面項目資料
*
*
 */

public class GameDetailItem {
    private String topNum;
    private int topImage;
    private String topName;
    private String topKm;

    public GameDetailItem(String topNum, int topImage, String topName, String topKm) {
        this.topNum = topNum;
        this.topImage = topImage;
        this.topName = topName;
        this.topKm = topKm;
    }

    public String getTopNum() {
        return topNum;
    }

    public void setTopNum(String topNum) {
        this.topNum = topNum;
    }

    public int getTopImage() {
        return topImage;
    }

    public void setTopImage(int topImage) {
        this.topImage = topImage;
    }

    public String getTopName() {
        return topName;
    }

    public void setTopName(String topName) {
        this.topName = topName;
    }

    public String getTopKm() {
        return topKm;
    }

    public void setTopKm(String topKm) {
        this.topKm = topKm;
    }
}
