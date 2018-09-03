package com.example.janhon.bonusrunningbeforeyou.social.gamedetail;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.janhon.bonusrunningbeforeyou.R;

/*
*@justin
* @09/03
*
* 賽事簡介DialogFragment畫面
*
 */

public class GameDialogFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View dialogView = inflater.inflate(R.layout.gamedetail_dialog, container, false);
        View tv = dialogView.findViewById(R.id.tvGameDetailText);

        return dialogView;
    }
/*
* 上下兩種方法都可以生成
* 不過上面那種生成後可以直接點擊背景畫面跳出DialogFragment
* 下面的不行要按返回鍵
*
*
 */
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        // 設置主题的方法
//        // AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomDialog);
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        View view = inflater.inflate(R.layout.gamedetail_dialog, null);
//        builder.setView(view);
//        TextView tv = view.findViewById(R.id.tvGameDetailText);
//        return builder.create();
//    }
}
