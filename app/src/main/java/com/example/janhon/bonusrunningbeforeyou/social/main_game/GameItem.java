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


    public GameItem(int medal, String gameName, String joinPeople, String days, String signUpStatus) {
        this.medal = medal;
        this.gameName = gameName;
        this.joinPeople = joinPeople;
        this.days = days;
        this.signUpStatus = signUpStatus;
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
}
