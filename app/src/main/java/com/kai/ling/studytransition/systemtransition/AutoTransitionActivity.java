package com.kai.ling.studytransition.systemtransition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kai.ling.studytransition.R;

public class AutoTransitionActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mRoot;
    private TextView mTvAutoTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_transition);

        initView();
    }

    private void initView() {
        mRoot = findViewById(R.id.root_view);
        mTvAutoTransition = findViewById(R.id.tv_autotransition);

        findViewById(R.id.btn_autotransition).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_autotransition:
                performAutoTransition();
                break;
        }
    }

    /**
     * AutoTransition
     */
    private void performAutoTransition(){
        TransitionManager.beginDelayedTransition(mRoot, new AutoTransition());
        if (mTvAutoTransition.getVisibility() != View.VISIBLE) {
            mTvAutoTransition.setVisibility(View.VISIBLE);
        } else {
            mTvAutoTransition.setVisibility(View.GONE);
        }
    }
}
