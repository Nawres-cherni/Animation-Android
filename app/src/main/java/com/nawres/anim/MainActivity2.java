package com.nawres.anim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.view.View;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;

import maes.tech.intentanim.CustomIntent;

public class MainActivity2 extends AppCompatActivity {

    private ConstraintLayout layout;
    private ConstraintSet constraintSetOld = new ConstraintSet();
    private ConstraintSet constraintSetNew = new ConstraintSet();
    private boolean altLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        setContentView(R.layout.activity_main2);
        layout = findViewById(R.id.layout);
        constraintSetOld.clone(layout);
        constraintSetNew.clone(this, R.layout.activity_main_alt);
    }

    public void swapView(View v) {
        Transition changeBounds = new ChangeBounds();
        changeBounds.setInterpolator(new OvershootInterpolator());
        TransitionManager.beginDelayedTransition(layout, changeBounds);
        if (!altLayout) {
            constraintSetNew.applyTo(layout);
            altLayout = true;
        } else {
            constraintSetOld.applyTo(layout);
            altLayout = false;
        }
    }




    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this, "fadein-to-fadeout");
    }



}