package com.example.janhon.bonusrunningbeforeyou.social.gamedetail;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.janhon.bonusrunningbeforeyou.R;
import com.example.janhon.bonusrunningbeforeyou.social.main_friend.GoFriendsAdapter;
import com.example.janhon.bonusrunningbeforeyou.social.main_game.GameAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class GameDetailActivity extends AppCompatActivity {
RecyclerView rvRecyclerView;
List<GameDetailItem> gameDetailItems = new ArrayList<>();
RelativeLayout rlGameDetailUserDetail;
Button buttonJoin;

    public List<GameDetailItem> gameDetailItems(){
        gameDetailItems.add(new GameDetailItem("No.1", R.drawable.gamedetailitem,"魔鬼貓","xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.1", R.drawable.gamedetailitem,"魔鬼貓","xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.1", R.drawable.gamedetailitem,"魔鬼貓","xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.1", R.drawable.gamedetailitem,"魔鬼貓","xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.1", R.drawable.gamedetailitem,"魔鬼貓","xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.1", R.drawable.gamedetailitem,"魔鬼貓","xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.1", R.drawable.gamedetailitem,"魔鬼貓","xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.1", R.drawable.gamedetailitem,"魔鬼貓","xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.1", R.drawable.gamedetailitem,"魔鬼貓","xxxxxKm"));
        gameDetailItems.add(new GameDetailItem("No.1", R.drawable.gamedetailitem,"魔鬼貓","xxxxxKm"));
        return gameDetailItems;

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_detail);
        buttonJoin = findViewById(R.id.buttonJoin);
        rlGameDetailUserDetail = findViewById(R.id.rlGameDetailUserDetail);
        rlGameDetailUserDetail.setVisibility(View.GONE);
        rvRecyclerView = findViewById(R.id.rvGameDetail);
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        rvRecyclerView.setAdapter(new GameDetailAdapter(this , gameDetailItems()));
    }

    /* 點擊簡介畫面時建立GameDialogFragment，
           呼叫show()會將AlertDialogFragment.onCreateDialog()
           回傳的AlertDialog呈現出來 */
    public void onDetailClick(View view) {
        GameDialogFragment gameDialogFragment = new GameDialogFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        gameDialogFragment.show(fragmentManager, "alert");
    }


    public void onJoinClick(View view) {
        buttonJoin.setVisibility(View.GONE);
        rlGameDetailUserDetail.setVisibility(View.VISIBLE);

    }
}
