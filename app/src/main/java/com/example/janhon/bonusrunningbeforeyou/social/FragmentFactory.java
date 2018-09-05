package com.example.janhon.bonusrunningbeforeyou.social;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.janhon.bonusrunningbeforeyou.social.main_friend.GoFriendsFragment;
import com.example.janhon.bonusrunningbeforeyou.social.main_game.GameFragment;

import java.util.ArrayList;

/*
 *
 * justin
 * 生成fragment
 *
 *
 */

public class FragmentFactory {
    private static ArrayList<Fragment> fragments;

    /**
     * 創建首頁子Fragment列表
     */
    public static ArrayList<Fragment> createIndexFragments() {
        fragments = new ArrayList<>();
        fragments.add(new GameFragment());
        fragments.add(new GoFriendsFragment());
        return fragments;
    }
}