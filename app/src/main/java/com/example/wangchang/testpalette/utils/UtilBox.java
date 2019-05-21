package com.example.wangchang.testpalette.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class UtilBox {
    static ProgressDialog dialog;
    public static void showDialog (Context context, String msg){
        dialog = new ProgressDialog(context);
        dialog.setMessage(msg);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}
