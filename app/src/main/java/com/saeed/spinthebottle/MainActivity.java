package com.saeed.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView bottle;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle = findViewById(R.id.bottle);

    }

    public void spinBottle(View v) {
        if (!spinning) {  //to make it work when it stop, not while rotation
            int newDir = random.nextInt(1800); //Generate number between 0 and 1800
            float pivotX = bottle.getWidth() / 2;
            float pivotY = bottle.getWidth() / 2;
            // Make it rotate around the center
            Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            rotate.setDuration(2500);
            rotate.setFillAfter(true);                  //make it rotate from the last point not the initial one
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            lastDir = newDir;
            bottle.startAnimation(rotate);
        }


    }
}





