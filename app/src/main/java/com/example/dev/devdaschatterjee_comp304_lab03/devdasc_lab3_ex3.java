package com.example.dev.devdaschatterjee_comp304_lab03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class devdasc_lab3_ex3 extends AppCompatActivity {

    Animation revolveAnimation;
    long animationDuration = 2500;
    RelativeLayout relativeLayoutExercise3;
    boolean animationRunning = false;
    ImageView moonImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devdasc_lab3_ex3);
        relativeLayoutExercise3 = (RelativeLayout)findViewById(R.id.relativeLayoutExercise3);
        float centerX = relativeLayoutExercise3.getWidth()/2;
        float centery = relativeLayoutExercise3.getHeight()/2;
        moonImageView = (ImageView) findViewById(R.id.moonImageView);
    }
    public void toggleAnimation(View view){
        if(animationRunning == false) {
            moonImageView = (ImageView) findViewById(R.id.moonImageView);
            revolveAnimation = new RevolveAnimation(moonImageView, 450);
            revolveAnimation.setDuration(animationDuration);
            moonImageView.startAnimation(revolveAnimation);
            revolveAnimation.setRepeatMode(Animation.INFINITE);
            revolveAnimation.setRepeatCount(Animation.INFINITE);
            animationRunning = true;
        } else if(animationRunning == true){
            moonImageView = (ImageView) findViewById(R.id.moonImageView);
            /*revolveAnimation = new RevolveAnimation(moonImageView, 450);*/
            revolveAnimation.cancel();
            revolveAnimation.reset();
            animationRunning = false;
        }
    }
}
