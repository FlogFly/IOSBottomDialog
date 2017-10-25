package com.example.dialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IOSDialogFragment.ButtomDialogListener {

    private static final String DIALOG_TAG = "buttom_dialog";
    private String[] items = {"选项1", "选项2", "选项3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClick = (Button) findViewById(R.id.btn_click);
        final IOSDialogFragment fragment = IOSDialogFragment.newInstance(items,this);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!fragment.isAdded()) {
                    fragment.show(getFragmentManager(), DIALOG_TAG);
                }
            }
        });
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this, items[position]+"被点击了。", Toast.LENGTH_SHORT).show();
    }
}