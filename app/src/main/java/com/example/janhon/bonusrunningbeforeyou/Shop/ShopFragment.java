package com.example.janhon.bonusrunningbeforeyou.Shop;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.janhon.bonusrunningbeforeyou.R;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, //container傳入
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false); //inflater 載入器,載入layout.fragment_score
        //handleViews(view);
        List<Coupon> couponList = new ArrayList<>();
        couponList.add(new Coupon("必剩客歡聚套餐兌換卷", R.drawable.pizzahot, "剩餘10張", "1000"));
        couponList.add(new Coupon("家熱福購物金500元", R.drawable.carefour, "剩餘8張", "500"));
        couponList.add(new Coupon("全嘉購物金200元", R.drawable.familymart, "剩餘27張", "200"));
        couponList.add(new Coupon("哈根達濕冰淇淋25元折價卷", R.drawable.haagendazs,"剩餘87張", "25"));

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.shop_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new CouponAdpter(inflater, couponList));
        return view;
    }

    private class CouponAdpter extends RecyclerView.Adapter<CouponAdpter.ViewHolder> {
        private LayoutInflater inflater;
        private List<Coupon> couponList;
        private View visibleView;

        CouponAdpter(LayoutInflater inflater, List<Coupon> couponList) {
            this.inflater = inflater;
            this.couponList = couponList;
        }

        @Override
        public int getItemCount(){
            return couponList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageview;
            TextView tvcouponid, tvquantity, tvprice;

            ViewHolder(View itemView) {
                super(itemView);
                imageview = itemView.findViewById(R.id.imageview);
                tvcouponid = itemView.findViewById(R.id.tvcoupon);
                tvquantity = itemView.findViewById(R.id.tvquantity);
                tvprice = itemView.findViewById(R.id.tvprice);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View itemView = inflater.inflate(R.layout.shop_item, viewGroup, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
            Coupon coupon = couponList.get(position);
            viewHolder.imageview.setImageResource(coupon.getImage());
            viewHolder.tvcouponid.setText(coupon.getCouponid());
            viewHolder.tvquantity.setText(coupon.getQuantity());
            viewHolder.tvprice.setText(coupon.getPrice());
        }



    }

}
