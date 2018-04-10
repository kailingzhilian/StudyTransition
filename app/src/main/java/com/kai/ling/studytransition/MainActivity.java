package com.kai.ling.studytransition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kai.ling.studytransition.systemtransition.AutoTransitionActivity;
import com.kai.ling.studytransition.systemtransition.ChangeBoundsActivity;
import com.kai.ling.studytransition.systemtransition.ChangeClipBoundsActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_auto_transition).setOnClickListener(this);
        findViewById(R.id.btn_change_bounds).setOnClickListener(this);
        findViewById(R.id.btn_change_clip_bounds).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_auto_transition:
                startActivity(new Intent(this, AutoTransitionActivity.class));
                break;
            case R.id.btn_change_bounds:
                startActivity(new Intent(this, ChangeBoundsActivity.class));
                break;
            case R.id.btn_change_clip_bounds:
                startActivity(new Intent(this, ChangeClipBoundsActivity.class));
                break;
        }
    }
}
