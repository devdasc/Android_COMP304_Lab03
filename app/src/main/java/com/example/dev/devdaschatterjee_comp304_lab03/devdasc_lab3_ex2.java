package com.example.dev.devdaschatterjee_comp304_lab03;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class devdasc_lab3_ex2 extends AppCompatActivity {

    AnimationDrawable mframeAnimation = null;
    Button startAndStopButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devdasc_lab3_ex2);
        startAndStopButton = (Button) findViewById(R.id.startAndStopButton);
        startAndStopButton.setText("START");
        //Get a reference to the ImageView
        ImageView imageViewExercise2Activity = (ImageView) findViewById(R.id.imageViewExercise2Activity);
        //Set an initial image to the ImageView
        imageViewExercise2Activity.setBackgroundResource(R.drawable.frame1);

    }
    public void toggleStartStop(View view){
        //Get a reference to the Button
        startAndStopButton = (Button) findViewById(R.id.startAndStopButton);
        switch(startAndStopButton.getText().toString()){
            case "START":
                startAnimation();
                startAndStopButton.setText("STOP");
                break;
            case "STOP":
                stopAnimation();
                startAndStopButton.setText("START");
                break;
        }
    }

    private void stopAnimation() {
        //Stop the animation
        mframeAnimation.stop();
    }

    private void startAnimation(){
        //Get a reference to the ImageView
        ImageView imageViewExercise2Activity = (ImageView) findViewById(R.id.imageViewExercise2Activity);
        //Declare BitmapDrawables for animation frames
        BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.frame1),
                frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.frame2),
                frame3 = (BitmapDrawable) getResources().getDrawable(R.drawable.frame3),
                frame4 = (BitmapDrawable) getResources().getDrawable(R.drawable.frame4);
        //Animation duration
        int animationDuration = 1500;
        // Get the background, which has been compiled to an AnimationDrawable object
        mframeAnimation = new AnimationDrawable();
        //code to loop through the frames continuously
        mframeAnimation.setOneShot(false);
        mframeAnimation.setEnterFadeDuration(200);
        //Add all frames to the AnimationDrawable object and set the duration
        mframeAnimation.addFrame(frame1, animationDuration);
        mframeAnimation.addFrame(frame2, animationDuration);
        mframeAnimation.addFrame(frame3, animationDuration);
        mframeAnimation.addFrame(frame4, animationDuration);
        //Set the background of the ImageView
        imageViewExercise2Activity.setBackgroundDrawable(mframeAnimation);
        //Make the animation visible
        mframeAnimation.setVisible(true, false);
        //Start animation
        mframeAnimation.start();
    }
}
