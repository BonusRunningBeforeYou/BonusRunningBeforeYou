package com.example.janhon.bonusrunningbeforeyou.Shop;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.janhon.bonusrunningbeforeyou.R;
import com.example.janhon.bonusrunningbeforeyou.Running.RunningActivity;
import com.example.janhon.bonusrunningbeforeyou.Target.TargetFragment;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {
    private RunningActivity runningActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        runningActivity = (RunningActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, //container傳入
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false); //inflater 載入器,載入layout.fragment_score
        handleViews(view);
        return view;
    }

    private void handleViews(View view) {
        RecyclerView shop_recycler_view = view.findViewById(R.id.shop_recycler_view);
        shop_recycler_view.setLayoutManager(new LinearLayoutManager(runningActivity));
        List<Coupon> coupons = getCoupon();
        shop_recycler_view.setAdapter(new ShopAdapter(runningActivity, coupons));
    }

    private class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> {
        private Context context;
        private List<Coupon> coupons;

        public ShopAdapter(Context context, List<Coupon> coupons) {
            this.context = context;
            this.coupons = coupons;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageview;
            TextView tvcouponid, tvquantity, tvprice;

            MyViewHolder(View itemView) {
                super(itemView);
                imageview = itemView.findViewById(R.id.imageview);
                tvcouponid = itemView.findViewById(R.id.tvcoupon);
                tvquantity = itemView.findViewById(R.id.tvquantity);
                tvprice = itemView.findViewById(R.id.tvprice);
            }
        }

        @Override
        public int getItemCount() {
            return coupons.size();
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View itemview = LayoutInflater.from(context).inflate(R.layout.shop_item, viewGroup, false);

            return new MyViewHolder(itemview);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
            final Coupon coupon = coupons.get(position);

            viewHolder.imageview.setImageResource(coupon.getImage());
            viewHolder.tvcouponid.setText(String.valueOf(coupon.getCouponid()));
            viewHolder.tvquantity.setText(String.valueOf(coupon.getQuantity()));
            viewHolder.tvprice.setText(String.valueOf(coupon.getPrice()));
        }

    }

    public List<Coupon> getCoupon() {
        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon("必剩客歡聚套餐兌換卷", R.drawable.pizzahot, "剩餘10張", "1000"));
        coupons.add(new Coupon("家熱福購物金500元", R.drawable.carefour, "剩餘8張", "500"));
        coupons.add(new Coupon("全嘉購物金200元", R.drawable.familymart, "剩餘27張", "200"));
        coupons.add(new Coupon("哈根達濕冰淇淋25元折價卷", R.drawable.haagendazs, "剩餘87張", "25"));
        return coupons;
    }

}

