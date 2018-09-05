package com.example.janhon.bonusrunningbeforeyou.social.main_friend;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.janhon.bonusrunningbeforeyou.R;

import java.util.ArrayList;
import java.util.List;


/*
 * justin
 * 揪團跑頁面
 *
 *
 *
 */
public class GoFriendsFragment extends Fragment {

    RecyclerView rvRecyclerView;
    List<GoFriendsItem> goFriendsItems = new ArrayList<>();


    public List<GoFriendsItem> goFriendsItems() {
        goFriendsItems.add(new GoFriendsItem(R.drawable.gofriends, "假揪團跑", "23人參加", "5天後開始", "報名中", "台北市"));
        goFriendsItems.add(new GoFriendsItem(R.drawable.gofriends, "假揪團跑", "23人參加", "5天後開始", "報名中", "台北市"));
        goFriendsItems.add(new GoFriendsItem(R.drawable.gofriends, "假揪團跑", "23人參加", "5天後開始", "報名中", "台北市"));
        goFriendsItems.add(new GoFriendsItem(R.drawable.gofriends, "假揪團跑", "23人參加", "5天後開始", "報名中", "台北市"));
        goFriendsItems.add(new GoFriendsItem(R.drawable.gofriends, "假揪團跑", "23人參加", "5天後開始", "報名中", "台北市"));
        goFriendsItems.add(new GoFriendsItem(R.drawable.gofriends, "假揪團跑", "23人參加", "5天後開始", "報名中", "台北市"));
        goFriendsItems.add(new GoFriendsItem(R.drawable.gofriends, "假揪團跑", "23人參加", "5天後開始", "報名中", "台北市"));
        goFriendsItems.add(new GoFriendsItem(R.drawable.gofriends, "假揪團跑", "23人參加", "5天後開始", "報名中", "台北市"));
        goFriendsItems.add(new GoFriendsItem(R.drawable.gofriends, "假揪團跑", "23人參加", "5天後開始", "報名中", "台北市"));
        return goFriendsItems;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);


        View viewPagerFragment = inflater.inflate(R.layout.fragment_gofriend, container, false);

        rvRecyclerView = viewPagerFragment.findViewById(R.id.rvGoFriends);
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvRecyclerView.setAdapter(new GoFriendsAdapter(getActivity(), inflater, goFriendsItems()));
        return viewPagerFragment;
    }


}
