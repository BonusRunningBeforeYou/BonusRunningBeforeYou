package com.example.janhon.bonusrunningbeforeyou.social.main_game;

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
*
* justin
*
* 賽事頁面
*
*
 */
public class GameFragment extends Fragment {

    RecyclerView rvRecyclerView;
    List<GameItem> gameItems = new ArrayList<>();



    public List<GameItem> getGameItem(){
        gameItems.add(new GameItem(R.drawable.medal_red2, "八月距離競賽","123人參加","10天後結束","報名中"));
        gameItems.add(new GameItem(R.drawable.medal_red2, "八月距離競賽","123人參加","10天後結束","報名中"));
        gameItems.add(new GameItem(R.drawable.medal_red2, "八月距離競賽","123人參加","10天後結束","報名中"));
        gameItems.add(new GameItem(R.drawable.medal_red2, "八月距離競賽","123人參加","10天後結束","報名中"));
        gameItems.add(new GameItem(R.drawable.medal_red2, "八月距離競賽","123人參加","10天後結束","報名中"));
        gameItems.add(new GameItem(R.drawable.medal_red2, "八月距離競賽","123人參加","10天後結束","報名中"));
        gameItems.add(new GameItem(R.drawable.medal_red2, "八月距離競賽","123人參加","10天後結束","報名中"));
        gameItems.add(new GameItem(R.drawable.medal_red2, "八月距離競賽","123人參加","10天後結束","報名中"));
    return gameItems;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);




        View viewPagerFragment = inflater.inflate(R.layout.fragment_game, container, false);

        rvRecyclerView = viewPagerFragment.findViewById(R.id.rvGame);
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvRecyclerView.setAdapter(new GameAdapter(getActivity(), inflater, getGameItem()));
        return viewPagerFragment;
    }


}
