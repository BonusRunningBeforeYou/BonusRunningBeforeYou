package com.example.janhon.bonusrunningbeforeyou.Target;

public class Target {
    private String tv_target_dare, tv_target_time,
            target_km1, target_km2, target_km3;
    private double tv_target_km_one;
    private int tv_target_km_two;
    private int target_bonus_1;
    private int target_bonus_2;
    private int target_bonus_3;
    // target_ellipse_1, target_ellipse_2, target_ellipse_3, target_ellipse_4, target_line_1, target_line_2, target_line_3;
    // 之後達成需換色
    //public int getImage() {
    //        return image;
    //    }
    //
    //    public void setImage(int image) {
    //        this.image = image;
    //    }

    public Target(String tv_target_dare, String tv_target_time, String target_km1,
                  String target_km2, String target_km3, double tv_target_km_one,
                  int tv_target_km_two, int target_bonus_1, int target_bonus_2, int target_bonus_3) {
        super();
        this.tv_target_dare = tv_target_dare;
        this.tv_target_time = tv_target_time;
        this.target_km1 = target_km1;
        this.target_km2 = target_km2;
        this.target_km3 = target_km3;

        this.tv_target_km_one = tv_target_km_one;
        this.tv_target_km_two = tv_target_km_two;
        this.target_bonus_1 = target_bonus_1;
        this.target_bonus_2 = target_bonus_2;
        this.target_bonus_3 = target_bonus_3;
    }

    public String getTv_target_dare() {
        return tv_target_dare;
    }

    public void setTv_target_dare(String tv_target_dare) {
        this.tv_target_dare = tv_target_dare;
    }

    public String getTv_target_time() {
        return tv_target_time;
    }

    public void setTv_target_time(String tv_target_time) {
        this.tv_target_time = tv_target_time;
    }

    public String getTarget_km1() {
        return target_km1;
    }

    public void setTarget_km1(String target_km1) {
        this.target_km1 = target_km1;
    }

    public String getTarget_km2() {
        return target_km2;
    }

    public void setTarget_km2(String target_km2) {
        this.target_km2 = target_km2;
    }

    public String getTarget_km3() {
        return target_km3;
    }

    public void setTarget_km3(String target_km3) {
        this.target_km3 = target_km3;
    }


    public double getTv_target_km_one() {
        return tv_target_km_one;
    }

    public void setTv_target_km_one(int tv_target_km_one) {
        this.tv_target_km_one = tv_target_km_one;
    }

    public int getTv_target_km_two() {
        return tv_target_km_two;
    }

    public void setTv_target_km_two(int tv_target_km_two) {
        this.tv_target_km_two = tv_target_km_two;
    }

    public int getTarget_bonus_1() {
        return target_bonus_1;
    }

    public void setTarget_bonus_1(int target_bonus_1) {
        this.target_bonus_1 = target_bonus_1;
    }

    public int getTarget_bonus_2() {
        return target_bonus_2;
    }

    public void setTarget_bonus_2(int target_bonus_2) {
        this.target_bonus_2 = target_bonus_2;
    }

    public int getTarget_bonus_3() {
        return target_bonus_3;
    }

    public void setTarget_bonus_3(int target_bonus_3) {
        this.target_bonus_3 = target_bonus_3;
    }
}
