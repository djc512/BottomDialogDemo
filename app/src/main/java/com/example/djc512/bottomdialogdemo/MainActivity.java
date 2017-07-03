package com.example.djc512.bottomdialogdemo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private Button btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                final Dialog dialog = new Dialog(this, R.style.BottomDialog);
                dialog.setCanceledOnTouchOutside(true);
                View view = LayoutInflater.from(this).inflate(R.layout.dialog, null);
                dialog.setContentView(view);
//                ViewGroup.LayoutParams params = view.getLayoutParams();
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                params.width = getResources().getDisplayMetrics().widthPixels-20;
                params.bottomMargin = 20;
                view.setLayoutParams(params);
                dialog.getWindow().setGravity(Gravity.BOTTOM);
                dialog.getWindow().setWindowAnimations(R.style.BottomDialogAnim);
                dialog.show();

                Button btn_close = (Button) view.findViewById(R.id.btn);
                btn_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });

                break;
        }
    }
}
