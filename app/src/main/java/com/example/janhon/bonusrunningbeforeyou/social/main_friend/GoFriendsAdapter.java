package com.example.janhon.bonusrunningbeforeyou.social.main_friend;

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

import com.example.janhon.bonusrunningbeforeyou.social.GoFriendsItem;

import java.util.List;
import com.example.janhon.bonusrunningbeforeyou.R;

/**
 * 實作 RecyclerView.Adapter
 *
 * @author justin
 * @date 2018/8/28
 */
public class GoFriendsAdapter extends RecyclerView.Adapter<GoFriendsAdapter.MyViewHolder> {
    Context context;
    LayoutInflater inflater;
    List<GoFriendsItem> goFriendsItems;

    /**
     * 初始化
     *
     *
     */
    public GoFriendsAdapter(Context context, LayoutInflater inflater, List<GoFriendsItem> goFriendsItems) {
        this.context = context;
        this.inflater = inflater;
        this.goFriendsItems = goFriendsItems;
    }

    /**
     * 你有幾筆資料？
     *
     *
     */
    @Override
    public int getItemCount() {
        return goFriendsItems.size();
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
        View gofriend_item_view = inflater.inflate(R.layout.gofriend_item_view, viewGroup, false);
        return new MyViewHolder(gofriend_item_view);
    }

    /**
     * 連結 gofriend_item_view
     *
     *
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivGoFriends;
        TextView tvGoFriendsName;
        TextView tvGofriendsJoinPeople;
        TextView tvStartDay;
        TextView tvGoFriendsSignUpStatus;
        TextView tvGoFriendsRunPlace;

        public MyViewHolder(@NonNull View gofriend_item_view) {
            super(gofriend_item_view);
            ivGoFriends = gofriend_item_view.findViewById(R.id.ivGoFriends);
            tvGoFriendsName = gofriend_item_view.findViewById(R.id.tvGoFriendsName);
            tvGofriendsJoinPeople = gofriend_item_view.findViewById(R.id.tvGofriendsJoinPeople);
            tvStartDay = gofriend_item_view.findViewById(R.id.tvStartDay);
            tvGoFriendsSignUpStatus = gofriend_item_view.findViewById(R.id.tvGoFriendsSignUpStatus);
            tvGoFriendsRunPlace = gofriend_item_view.findViewById(R.id.tvGoFriendsRunPlace);

        }
    }

    /**
     * 傳入資
     *
     *
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, final int position) {
        final GoFriendsItem goFriendsItem = goFriendsItems.get(position);
        MyViewHolder myViewHolder = viewHolder;
        myViewHolder.ivGoFriends.setImageResource(goFriendsItem.getGoFriends());
        myViewHolder.tvGoFriendsName.setText(goFriendsItem.getGoFriendsName());
        myViewHolder.tvGofriendsJoinPeople.setText(goFriendsItem.getGoFriendsJoinPeople());
        myViewHolder.tvStartDay.setText(goFriendsItem.getStartDay());
        myViewHolder.tvGoFriendsSignUpStatus.setText(goFriendsItem.getGoFriendsSignUpStatus());
        myViewHolder.tvGoFriendsRunPlace.setText(goFriendsItem.getGoFriendsRunPlace());


        /*itemView 是 點擊的那個項目*/
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GoFriendsFragment.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("ProductName", product.getProductName());
//                bundle.putInt("ProductImage", product.getProductImg());
//                intent.putExtras(bundle);
//                context.startActivity(intent);
//                Toast.makeText(context, product.getProductName(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

