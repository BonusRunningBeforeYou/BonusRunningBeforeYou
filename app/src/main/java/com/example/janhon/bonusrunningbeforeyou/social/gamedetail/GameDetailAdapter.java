package com.example.janhon.bonusrunningbeforeyou.social.gamedetail;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.janhon.bonusrunningbeforeyou.R;

import java.util.List;

/*
 *
 * @justin
 * @09/02
 * 實作 RecyclerView.Adapter
 *
 */
public class GameDetailAdapter extends RecyclerView.Adapter<GameDetailAdapter.MyViewHolder> {

    Context context;
    List<GameDetailItem> gameDetailItems;

    /**
     * 初始化
     */
    public GameDetailAdapter(Context context,  List<GameDetailItem> gameDetailItems) {
        this.context = context;
        this.gameDetailItems = gameDetailItems;
    }

    /**
     * 你有幾筆資料？
     */
    @Override
    public int getItemCount() {
        return gameDetailItems.size();
    }


    /**
     * 開始
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /*載入item_view (間接依存輸入false 直接依存true)*/
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View item_view = layoutInflater.inflate(R.layout.gamedetail_itemview, viewGroup, false);
        //傳入想要放入的元件                                                       //間接依存要打false
        //直接依存是在最底層的layout直接傳入,間接依存是主lay
        return new MyViewHolder(item_view);//回傳viewholder
    }

    /**
     * 連結 item_view
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTopNum;
        ImageView civTopImage;
        TextView tvTopName;
        TextView tvTopKm;


        public MyViewHolder(@NonNull View item_view) {
            super(item_view);
            tvTopNum = item_view.findViewById(R.id.tvTopNum);
            civTopImage = item_view.findViewById(R.id.civTopImage);
            tvTopName = item_view.findViewById(R.id.tvTopName);
            tvTopKm = item_view.findViewById(R.id.tvTopKm);

        }
    }

    /**
     * 傳入資
     */
    @Override
    public void onBindViewHolder(@NonNull GameDetailAdapter.MyViewHolder viewHolder, final int position) {
        final GameDetailItem gameDetailItem = gameDetailItems.get(position);
        GameDetailAdapter.MyViewHolder myViewHolder = viewHolder;
        myViewHolder.tvTopNum.setText(gameDetailItem.getTopNum());
        myViewHolder.civTopImage.setImageResource(gameDetailItem.getTopImage());
        myViewHolder.tvTopName.setText(gameDetailItem.getTopName());
        myViewHolder.tvTopKm.setText(gameDetailItem.getTopKm());


        /*itemView 是 點擊的那個項目*/
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, GameDetailActivity.class);
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


