package com.example.janhon.bonusrunningbeforeyou.social;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/*
*
* justin
*把fragment綁在一起
*
 */
public class TestFragmentAdapter extends FragmentStatePagerAdapter {
    private String mTabTitles[];
    private List<Fragment> mList;

    public TestFragmentAdapter(FragmentManager fm, String tabTitles[],
                               List<Fragment> list) {
        super(fm);
        this.mList = list;
        this.mTabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }
}
