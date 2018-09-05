package com.example.janhon.bonusrunningbeforeyou.social.main_game;

/*
*
* justin
* 賽事內容項目
*
*
 */

public class GameItem {
    private int medal;
    private String gameName;
    private String joinPeople;
    private String days;
    private String signUpStatus;
    private String gameDetail;
    private String gameDetailText;

    public GameItem(int medal, String gameName, String joinPeople, String days, String signUpStatus, String gameDetail, String gameDetailText) {
        this.medal = medal;
        this.gameName = gameName;
        this.joinPeople = joinPeople;
        this.days = days;
        this.signUpStatus = signUpStatus;
        this.gameDetail = gameDetail;
        this.gameDetailText = gameDetailText;
    }

    public int getMedal() {
        return medal;
    }

    public void setMedal(int medal) {
        this.medal = medal;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getJoinPeople() {
        return joinPeople;
    }

    public void setJoinPeople(String joinPeople) {
        this.joinPeople = joinPeople;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getSignUpStatus() {
        return signUpStatus;
    }

    public void setSignUpStatus(String signUpStatus) {
        this.signUpStatus = signUpStatus;
    }

    public String getGameDetail() {
        return gameDetail;
    }

    public void setGameDetail(String gameDetail) {
        this.gameDetail = gameDetail;
    }

    public String getGameDetailText() {
        return gameDetailText;
    }

    public void setGameDetailText(String gameDetailText) {
        this.gameDetailText = gameDetailText;
    }
}