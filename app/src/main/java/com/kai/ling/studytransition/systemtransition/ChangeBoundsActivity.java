package com.kai.ling.studytransition.systemtransition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kai.ling.studytransition.R;

public class ChangeBoundsActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout mRoot;
    private TextView mTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_bounds);

        initView();
    }

    private void initView() {
        mRoot = findViewById(R.id.root_view);
        mTarget = findViewById(R.id.target);

        findViewById(R.id.btn_autotransition).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_autotransition:
                performChangeBounds();
                break;
        }
    }

    /**
     * AutoTransition
     */
    private void performChangeBounds(){
        TransitionManager.beginDelayedTransition(mRoot, new ChangeBounds());
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mTarget.getLayoutParams();
        if ((lp.gravity & Gravity.START) == Gravity.START) {
            lp.gravity = Gravity.BOTTOM | Gravity.END;
        } else {
            lp.gravity = Gravity.TOP | Gravity.START;
        }
        mTarget.setLayoutParams(lp);
    }
}
