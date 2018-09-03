package com.example.janhon.bonusrunningbeforeyou.social.main_game;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.janhon.bonusrunningbeforeyou.R;
import com.example.janhon.bonusrunningbeforeyou.social.gamedetail.GameDetailActivity;
import com.example.janhon.bonusrunningbeforeyou.social.main_friend.GoFriendsFragment;

import java.util.List;


/**
 * 實作 RecyclerView.Adapter
 *
 * @author justin
 * @date 2018/8/28
 */
public class GameAdapter extends RecyclerView.Adapter<GameAdapter.MyViewHolder> {
    Context context;
    LayoutInflater inflater;
    List<GameItem> gameItems;

    /**
     * 初始化
     *
     *
     */
    public GameAdapter(Context context, LayoutInflater inflater, List<GameItem> gameItem) {
        this.context = context;
        this.inflater = inflater;
        this.gameItems = gameItem;
    }

    /**
     * 你有幾筆資料？
     *
     *
     */
    @Override
    public int getItemCount() {
        return gameItems.size();
    }


    /**
     * 開始
     *
     *
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /*載入item_view (間接依存輸入false 直接依存true)*/
        View game_item_view;
        game_item_view = inflater.inflate(R.layout.game_item_view, viewGroup, false);
        return new MyViewHolder(game_item_view);
    }

    /**
     * 連結 item_view
     *
     *
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivMedal;
        TextView tvGameName;
        TextView tvJoinPeople;
        TextView tvDays;
        TextView tvSignUpStatus;

        public MyViewHolder(@NonNull View item_view) {
            super(item_view);
            ivMedal = item_view.findViewById(R.id.ivMedal);
            tvGameName = item_view.findViewById(R.id.tvGameName);
            tvJoinPeople = item_view.findViewById(R.id.tvGameJoinPeople);
            tvDays = item_view.findViewById(R.id.tvGameEndDay);
            tvSignUpStatus = item_view.findViewById(R.id.tvGameSignUpStatus);

        }
    }

    /**
     * 傳入資
     *
     *
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, final int position) {
        final GameItem gameItem = gameItems.get(position);
        MyViewHolder myViewHolder = viewHolder;
        myViewHolder.ivMedal.setImageResource(gameItem.getMedal());
        myViewHolder.tvGameName.setText(gameItem.getGameName());
        myViewHolder.tvJoinPeople.setText(gameItem.getJoinPeople());
        myViewHolder.tvDays.setText(gameItem.getDays());
        myViewHolder.tvSignUpStatus.setText(gameItem.getSignUpStatus());


        /*itemView 是 點擊的那個項目*/
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GameDetailActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("ProductName", product.getProductName());
//                bundle.putInt("ProductImage", product.getProductImg());
//                intent.putExtras(bundle);
                context.startActivity(intent);
//                Toast.makeText(context, product.getProductName(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

