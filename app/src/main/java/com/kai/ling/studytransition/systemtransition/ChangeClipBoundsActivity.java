package com.kai.ling.studytransition.systemtransition;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeClipBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kai.ling.studytransition.R;

public class ChangeClipBoundsActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mRoot;
    private TextView mTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_clip_bounds);

        initView();
    }

    private void initView() {
        mRoot = findViewById(R.id.root_view);
        mTarget = findViewById(R.id.target);

        findViewById(R.id.btn).setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                performChangeClipBounds();
                break;
        }
    }

    /**
     * AutoTransition
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void performChangeClipBounds(){
        Rect BOUNDS = new Rect(20, 20, 100, 100);
        TransitionManager.beginDelayedTransition(mRoot, new ChangeClipBounds());
        if (BOUNDS.equals(ViewCompat.getClipBounds(mTarget))) {
            ViewCompat.setClipBounds(mTarget, null);
        } else {
            ViewCompat.setClipBounds(mTarget, BOUNDS);
        }
    }
}
