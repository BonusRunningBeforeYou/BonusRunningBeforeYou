package com.example.janhon.bonusrunningbeforeyou.social.gamedetail;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.janhon.bonusrunningbeforeyou.R;
import com.example.janhon.bonusrunningbeforeyou.social.main_friend.GoFriendsAdapter;
import com.example.janhon.bonusrunningbeforeyou.social.main_game.GameAdapter;
import com.example.janhon.bonusrunningbeforeyou.social.main_game.GameItem;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class GameDetailActivity extends AppCompatActivity {
    RecyclerView rvRecyclerView;
    List<GameDetailItem> gameDetailItems = new ArrayList<>();
    RelativeLayout rlGameDetailUserDetail;
    Button buttonJoin;
    TextView gameDetail;
    TextView gameDetailToobar;
    Bundle bundle;

    public List<GameDetailItem> gameDetailItems() {
        gameDetailItems.add(new GameDetailItem("No.1", R.drawable.gamedetailitem, "魔鬼貓", "xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.2", R.drawable.gamedetailitem, "魔鬼貓", "xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.3", R.drawable.gamedetailitem, "魔鬼貓", "xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.4", R.drawable.gamedetailitem, "魔鬼貓", "xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.5", R.drawable.gamedetailitem, "魔鬼貓", "xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.6", R.drawable.gamedetailitem, "魔鬼貓", "xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.7", R.drawable.gamedetailitem, "魔鬼貓", "xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.8", R.drawable.gamedetailitem, "魔鬼貓", "xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.9", R.drawable.gamedetailitem, "魔鬼貓", "xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.10", R.drawable.gamedetailitem, "魔鬼貓", "xxxxxKm"));
        return gameDetailItems;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_detail);

        gameDetail = findViewById(R.id.tvGameDetail);
        gameDetailToobar = findViewById(R.id.tvGameDetailToobar);
        buttonJoin = findViewById(R.id.buttonJoin);
        rlGameDetailUserDetail = findViewById(R.id.rlGameDetailUserDetail);
        rlGameDetailUserDetail.setVisibility(View.GONE);
        rvRecyclerView = findViewById(R.id.rvGameDetail);

        rvRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        rvRecyclerView.setAdapter(new GameDetailAdapter(this, gameDetailItems()));
        initValue();
    }


    /*
     *
     * 接收賽事列表的資料並設置
     * from GameAdapter
     *
     */
    @SuppressLint("ResourceAsColor")
    private void initValue() {
        bundle = getIntent().getExtras();

        String gameDetails = bundle.getString("gameDetail");
        gameDetail.setText(gameDetails);
        gameDetail.setTextColor(R.color.colorBlack);

        String gameDetailToobars = bundle.getString("gameName");
        gameDetailToobar.setText(gameDetailToobars);


    }

    /* 點擊簡介畫面時建立GameDialogFragment，
           呼叫show()會將AlertDialogFragment.onCreateDialog()
           回傳的AlertDialog呈現出來
    *
    *
    * 再將從GameAdapter 傳來的賽事簡介資料在傳到GameDialogFragment
    *
    */
    @SuppressLint("ResourceAsColor")
    public void onDetailClick(View view) {
        GameDialogFragment gameDialogFragment = new GameDialogFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        gameDialogFragment.show(fragmentManager, "alert");

        Bundle bundleN = new Bundle();
        String gameDetailTexts = bundle.getString("gameDetailText");
        bundleN.putString("gameDetailText", gameDetailTexts);
        gameDialogFragment.setArguments(bundleN);

    }
/*
*
* 點擊加入後加入按鈕隱藏顯示個人資料（
* 現在是假資料）
*
*
 */

    public void onJoinClick(View view) {
        buttonJoin.setVisibility(View.GONE);
        rlGameDetailUserDetail.setVisibility(View.VISIBLE);

    }
}
