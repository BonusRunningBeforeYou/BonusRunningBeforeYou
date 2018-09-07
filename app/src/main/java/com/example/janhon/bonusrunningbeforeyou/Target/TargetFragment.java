package com.example.janhon.bonusrunningbeforeyou.Target;

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

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class TargetFragment extends Fragment {
    private RunningActivity runningActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        runningActivity = (RunningActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, //container傳入
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_target, container, false); //inflater 載入器,載入layout.fragment_score
        handleViews(view);
        return view;
    }

    private void handleViews(View view) {
        RecyclerView target_recycler_view = view.findViewById(R.id.target_recycler_view);
        target_recycler_view.setLayoutManager(new LinearLayoutManager(runningActivity));
        List<com.example.janhon.bonusrunningbeforeyou.Target.Target> targets = getTarget();
        target_recycler_view.setAdapter(new TargetAdpter(runningActivity, targets));
    }

    private class TargetAdpter extends RecyclerView.Adapter<TargetAdpter.MyViewHolder> {
        private Context context;
        private List<com.example.janhon.bonusrunningbeforeyou.Target.Target> targets;

        TargetAdpter(Context context, List<com.example.janhon.bonusrunningbeforeyou.Target.Target> targets) {
            this.context = context;
            this.targets = targets;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv_targt_dare, tv_target_time, tv_target_km_one, tv_target_km_two,
                    target_bonus_1, target_bonus_2, target_bonus_3, target_km1, target_km2, target_km3;

            MyViewHolder(View itemView) {
                super(itemView);
                tv_targt_dare = itemView.findViewById(R.id.tv_target_dare);
                tv_target_time = itemView.findViewById(R.id.tv_target_time);
                tv_target_km_one = itemView.findViewById(R.id.tv_target_km_one);
                tv_target_km_two = itemView.findViewById(R.id.tv_target_km_two);
                target_bonus_1 = itemView.findViewById(R.id.target_bonus_1);
                target_bonus_2 = itemView.findViewById(R.id.target_bonus_2);
                target_bonus_3 = itemView.findViewById(R.id.target_bonus_3);
                target_km1 = itemView.findViewById(R.id.target_km1);
                target_km2 = itemView.findViewById(R.id.target_km2);
                target_km3 = itemView.findViewById(R.id.target_km3);

            }
        }

        @Override
        public int getItemCount() {
            return targets.size();
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.target_item, viewGroup, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
            final com.example.janhon.bonusrunningbeforeyou.Target.Target target = targets.get(position);

            viewHolder.tv_targt_dare.setText(String.valueOf(target.getTv_target_dare()));
            viewHolder.tv_target_time.setText(String.valueOf(target.getTv_target_time()));
            viewHolder.tv_target_km_one.setText(String.valueOf(target.getTv_target_km_one()));
            viewHolder.tv_target_km_two.setText(String.valueOf(target.getTv_target_km_two()));
            viewHolder.target_bonus_1.setText(String.valueOf(target.getTarget_bonus_1()));
            viewHolder.target_bonus_2.setText(String.valueOf(target.getTarget_bonus_2()));
            viewHolder.target_bonus_3.setText(String.valueOf(target.getTarget_bonus_3()));
            viewHolder.target_km1.setText(String.valueOf(target.getTarget_km1()));
            viewHolder.target_km2.setText(String.valueOf(target.getTarget_km2()));
            viewHolder.target_km3.setText(String.valueOf(target.getTarget_km3()));
        }




    }

    public List<com.example.janhon.bonusrunningbeforeyou.Target.Target> getTarget() {
        List<com.example.janhon.bonusrunningbeforeyou.Target.Target> targets = new ArrayList<>();
        targets.add(new com.example.janhon.bonusrunningbeforeyou.Target.Target("每日目標", "剩餘13時", "1km", "3km", "5km", 0.00, 1, 10, 20, 40));
        targets.add(new com.example.janhon.bonusrunningbeforeyou.Target.Target("每週目標", "剩餘4天","10km", "20km", "30km", 0.00,10,30, 40, 60));
        targets.add(new com.example.janhon.bonusrunningbeforeyou.Target.Target("每月目標", "剩餘21天","50km", "75km", "100km", 0.00,50,50, 60, 80));
        return targets;
    }
}
