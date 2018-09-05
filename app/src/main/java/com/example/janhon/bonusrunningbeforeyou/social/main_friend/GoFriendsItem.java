package com.example.janhon.bonusrunningbeforeyou.social.main_friend;

/*
*justin
* 揪團跑內容項目
*
*
*
 */
public class GoFriendsItem {
    private int goFriends;
    private String goFriendsName;
    private String goFriendsJoinPeople;
    private String startDay;
    private String goFriendsSignUpStatus;
    private String goFriendsRunPlace;

    public GoFriendsItem(int goFriends, String goFriendsName, String goFriendsJoinPeople, String startDay, String goFriendsSignUpStatus, String goFriendsRunPlace) {
        this.goFriends = goFriends;
        this.goFriendsName = goFriendsName;
        this.goFriendsJoinPeople = goFriendsJoinPeople;
        this.startDay = startDay;
        this.goFriendsSignUpStatus = goFriendsSignUpStatus;
        this.goFriendsRunPlace = goFriendsRunPlace;
    }

    public int getGoFriends() {
        return goFriends;
    }

    public void setGoFriends(int goFriends) {
        this.goFriends = goFriends;
    }

    public String getGoFriendsName() {
        return goFriendsName;
    }

    public void setGoFriendsName(String goFriendsName) {
        this.goFriendsName = goFriendsName;
    }

    public String getGoFriendsJoinPeople() {
        return goFriendsJoinPeople;
    }

    public void setGoFriendsJoinPeople(String goFriendsJoinPeople) {
        this.goFriendsJoinPeople = goFriendsJoinPeople;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getGoFriendsSignUpStatus() {
        return goFriendsSignUpStatus;
    }

    public void setGoFriendsSignUpStatus(String goFriendsSignUpStatus) {
        this.goFriendsSignUpStatus = goFriendsSignUpStatus;
    }

    public String getGoFriendsRunPlace() {
        return goFriendsRunPlace;
    }

    public void setGoFriendsRunPlace(String goFriendsRunPlace) {
        this.goFriendsRunPlace = goFriendsRunPlace;
    }
}
