package com.example.janhon.bonusrunningbeforeyou.social;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.janhon.bonusrunningbeforeyou.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *justin
 * 生成tablayout和viewpager
 *
 *
 *
 */

public class FriendsFragment extends Fragment {


    @BindView(R.id.sliding_tabs)
    TabLayout mSlidingTabs;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private List<Fragment> mList = new ArrayList<Fragment>();
    private TestFragmentAdapter mTestFragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.friend_tablayout, null);
        initView(view);
        Log.d("onCreateView", "一二三四五六七八");
        return view;
    }

    /**
     * 初始化控件
     *
     * @param view
     */
    private void initView(View view) {

        ButterKnife.bind(this, view);

        initPager();
    }

    /**
     * 設置子Fragment数據
     */
    private void initPager() {
        String tabTitles[] = new String[]{"賽事", "揪團跑"};

        //獲取子fragment列表
        mList = FragmentFactory.createIndexFragments();
        /**
         *  創建FragmentAdapter
         *  這里因為Fragment里面嵌套Fragment ,需要使用getChildFragmentManager()来管理,
         *  不然會出现一些異常
         */
        mTestFragmentAdapter = new TestFragmentAdapter(getChildFragmentManager(),
                tabTitles, mList);
        //绑定FragmentAdapter
        mViewpager.setAdapter(mTestFragmentAdapter);
        //绑定ViewPager
        mSlidingTabs.setupWithViewPager(mViewpager);
//        mSlidingTabs.setTabMode();
        //設置TabLayout模式
        mSlidingTabs.setTabMode(TabLayout.MODE_FIXED);
    }


}
