package com.example.janhon.bonusrunningbeforeyou.social.main_game;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    TextView gameSignUpStatus ;


    public List<GameItem> getGameItem(){

        gameItems.add(new GameItem(R.drawable.medal_red2,
                "八月距離競賽",
                "123人參加",
                "10天後結束",
                "報名中",
                "簡介\n" +
                "            2018年8月01日-2018年8月31日\n" +" \n"+
                "\t使用Bonus Running Before You的GPS跑步功能累積您的里程，與其他跑者一起競賽！",
                "簡介\n" +
                        "\n" +
                        "            2018年8月01日-2018年8月31日\n" +
                        "\n" +
                        "\t使用Bonus Running Before You的GPS跑步功能累積您的里程，與其他跑者一起競賽！\n" +
                        "\t在整個賽事期間您都可以隨時開跑，只要參與賽事的跑者我們都會給予參加獎勵點數xxx點，" +
                        "不管您是初級跑者或是專業跑者我們都歡迎您一起參與賽事，" +
                        "但無論如何請注意您的跑步環境以確保人身安全。\n" +
                        "\n" +
                        "規則\n" +
                        "\n" +
                        "\t只要在2018年8月01日-2018年8月31日中累計里程數在所有跑者中為前10名者可以得到排名獎勵。\\n\n" +
                        "第一名可以得到XXX點\n" +
                        "第二名可以得到XXX點\n  "));
        gameItems.add(new GameItem(R.drawable.medal_red2,
                "八月最速競賽",
                "223人參加",
                "8天後結束",
                "報名中",
                "簡介\n" +
                "            2018年8月01日-2018年8月31日\n" +" \n"+
                "\t使用Bonus Running Before You的GPS跑步功能，與其他跑者一起競賽！",
                "簡介\\n\n" +
                        "\n" +
                        "            2018年8月01日-2018年8月31日\\n\n" +
                        "\n" +
                        "\\t使用Bonus Running Before You的GPS跑步功能累積您的里程，與其他跑者一起競賽！\\n\\n\\t在整個賽事期間您都可以隨時開跑，只要參與賽事的跑者我們都會給予參加獎勵點數xxx點，不管您是初級跑者或是專業跑者我們都歡迎您一起參與賽事，但無論如何請注意您的跑步環境以確保人身安全。\\n\n" +
                        "\\n\n" +
                        "規則\\n\n" +
                        "\\n\n" +
                        "\\t只要在2018年8月01日-2018年8月31日中累計里程數在所有跑者中為前10名者可以得到排名獎勵。\\n\n" +
                        "第一名可以得到XXX點\\n\n" +
                        "第二名可以得到XXX點\\n  "));
        gameItems.add(new GameItem(R.drawable.medal_red2,
                "八月距離競賽",
                "123人參加",
                "10天後結束",
                "報名中",
                "簡介\n" +
                "            2018年8月01日-2018年8月31日\n" +" \n"+
                "\t使用Bonus Running Before You的GPS跑步功能累積您的里程，與其他跑者一起競賽！",
                "簡介\\n\n" +
                        "\n" +
                        "            2018年8月01日-2018年8月31日\\n\n" +
                        "\n" +
                        "\\t使用Bonus Running Before You的GPS跑步功能累積您的里程，與其他跑者一起競賽！\\n\\n\\t在整個賽事期間您都可以隨時開跑，只要參與賽事的跑者我們都會給予參加獎勵點數xxx點，不管您是初級跑者或是專業跑者我們都歡迎您一起參與賽事，但無論如何請注意您的跑步環境以確保人身安全。\\n\n" +
                        "\\n\n" +
                        "規則\\n\n" +
                        "\\n\n" +
                        "\\t只要在2018年8月01日-2018年8月31日中累計里程數在所有跑者中為前10名者可以得到排名獎勵。\\n\n" +
                        "第一名可以得到XXX點\\n\n" +
                        "第二名可以得到XXX點\\n  "));
        gameItems.add(new GameItem(R.drawable.medal_red2,
                "八月距離競賽",
                "123人參加",
                "10天後結束",
                "報名中",
                "簡介\n" +
                "            2018年8月01日-2018年8月31日\n" +" \n"+
                "\t使用Bonus Running Before You的GPS跑步功能累積您的里程，與其他跑者一起競賽！",
                "簡介\\n\n" +
                        "\n" +
                        "            2018年8月01日-2018年8月31日\\n\n" +
                        "\n" +
                        "\\t使用Bonus Running Before You的GPS跑步功能累積您的里程，與其他跑者一起競賽！\\n\\n\\t在整個賽事期間您都可以隨時開跑，只要參與賽事的跑者我們都會給予參加獎勵點數xxx點，不管您是初級跑者或是專業跑者我們都歡迎您一起參與賽事，但無論如何請注意您的跑步環境以確保人身安全。\\n\n" +
                        "\\n\n" +
                        "規則\\n\n" +
                        "\\n\n" +
                        "\\t只要在2018年8月01日-2018年8月31日中累計里程數在所有跑者中為前10名者可以得到排名獎勵。\\n\n" +
                        "第一名可以得到XXX點\\n\n" +
                        "第二名可以得到XXX點\\n  "));
        gameItems.add(new GameItem(R.drawable.medal_red2,
                "八月距離競賽",
                "123人參加",
                "10天後結束",
               "報名中",
                "簡介\n" +
                "            2018年8月01日-2018年8月31日\n" +" \n"+
                "\t使用Bonus Running Before You的GPS跑步功能累積您的里程，與其他跑者一起競賽！",
                "簡介\\n\n" +
                        "\n" +
                        "            2018年8月01日-2018年8月31日\\n\n" +
                        "\n" +
                        "\\t使用Bonus Running Before You的GPS跑步功能累積您的里程，與其他跑者一起競賽！\\n\\n\\t在整個賽事期間您都可以隨時開跑，只要參與賽事的跑者我們都會給予參加獎勵點數xxx點，不管您是初級跑者或是專業跑者我們都歡迎您一起參與賽事，但無論如何請注意您的跑步環境以確保人身安全。\\n\n" +
                        "\\n\n" +
                        "規則\\n\n" +
                        "\\n\n" +
                        "\\t只要在2018年8月01日-2018年8月31日中累計里程數在所有跑者中為前10名者可以得到排名獎勵。\\n\n" +
                        "第一名可以得到XXX點\\n\n" +
                        "第二名可以得到XXX點\\n  "));
        gameItems.add(new GameItem(R.drawable.medal_red2,
                "八月距離競賽",
                "123人參加",
                "10天後結束",
               "報名中",
                "簡介\n" +
                "            2018年8月01日-2018年8月31日\n" +" \n"+
                "\t使用Bonus Running Before You的GPS跑步功能累積您的里程，與其他跑者一起競賽！",
                "簡介\\n\n" +
                        "\n" +
                        "            2018年8月01日-2018年8月31日\\n\n" +
                        "\n" +
                        "\\t使用Bonus Running Before You的GPS跑步功能累積您的里程，與其他跑者一起競賽！\\n\\n\\t在整個賽事期間您都可以隨時開跑，只要參與賽事的跑者我們都會給予參加獎勵點數xxx點，不管您是初級跑者或是專業跑者我們都歡迎您一起參與賽事，但無論如何請注意您的跑步環境以確保人身安全。\\n\n" +
                        "\\n\n" +
                        "規則\\n\n" +
                        "\\n\n" +
                        "\\t只要在2018年8月01日-2018年8月31日中累計里程數在所有跑者中為前10名者可以得到排名獎勵。\\n\n" +
                        "第一名可以得到XXX點\\n\n" +
                        "第二名可以得到XXX點\\n  "));


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
