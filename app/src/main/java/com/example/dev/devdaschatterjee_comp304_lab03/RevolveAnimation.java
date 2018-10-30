package com.example.dev.devdaschatterjee_comp304_lab03;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;


public class RevolveAnimation extends Animation {
    private View view;
    private float centerX, centerY;           // center x,y position of circular path
    private float previousX, previousY;     // previous x,y position of image during animation
    private float radius;                // radius of circle
    private float prevDx, prevDy;


    public RevolveAnimation(View view, float r){
        this.view = view;
        this.radius = r;
    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        // calculate position of image center
        int cxImage = width / 2;
        int cyImage = height / 2;
        centerX = view.getLeft() + cxImage;
        centerY = view.getTop() + cyImage;

        // set previous position to center
        previousX = centerX;
        previousY = centerY;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        if(interpolatedTime == 0){
            t.getMatrix().setTranslate(prevDx, prevDy);
            return;
        }

        float angleDeg = (interpolatedTime * 360f + 100000) % 360;
        float angleRad = (float) Math.toRadians(angleDeg);

        // radius = radius, centerX and centerY = center point, a = angle (radians)
        float x = (float) (centerX + radius * Math.cos(angleRad));
        float y = (float) (centerY + radius * Math.sin(angleRad));


        float dx = previousX - x;
        float dy = previousY - y;

        previousX = x;
        previousY = y;

        prevDx = dx;
        prevDy = dy;


        t.getMatrix().setTranslate(dx, dy);
    }

}
