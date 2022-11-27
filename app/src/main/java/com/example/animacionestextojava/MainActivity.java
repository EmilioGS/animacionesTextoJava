package com.example.animacionestextojava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation anim1, anim2, anim3, anim4;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnimationSet animaciones = new AnimationSet(true);
        tv = (TextView) findViewById(R.id.txt1);

        //Animacion traslacion
        int rs1 = TranslateAnimation.RELATIVE_TO_SELF;
        anim1 = new TranslateAnimation(rs1, 0, rs1, 0, rs1, 0, rs1, 10);
        anim1.setInterpolator(new LinearInterpolator());
        //anim1.setInterpolator(new AccelerateDecelerateInterpolator());
        //anim1.setInterpolator(new AnticipateInterpolator());
        anim1.setFillAfter(true);
        anim1.setDuration(3000);
        anim1.setRepeatMode(Animation.RESTART);
        anim1.setStartOffset(3000);
        //anim1.setRepeatCount(2); //Que en un conjunto de animaciones ya no sirve esta sentencia xd

        //Animacion rotacion
        int rs2 = RotateAnimation.RELATIVE_TO_SELF;
        anim2 = new RotateAnimation(0, 360, rs2, 0.5f, rs2, 0.5f);
        anim2.setFillAfter(true);
        anim2.setRepeatCount(1); //Se pueden combinar las animaciones
        anim2.setDuration(3000);
        anim2.setRepeatCount(Animation.RESTART);
        //anim2.setStartOffset(3000);

        //Animacion escala
        int rs3 = RotateAnimation.RELATIVE_TO_SELF;
        //anim3 = new ScaleAnimation(1, 2, 1, 2);
        anim3 = new ScaleAnimation(1, 2, 0, 2, rs3, 0.5f, rs3, 0.5f);
        anim3.setFillAfter(true);
        anim3.setRepeatCount(1); //Se pueden combinar las animaciones
        anim3.setDuration(3000);
        anim1.setStartOffset(6000);

        //Animacion transparencia
        anim4 = new AlphaAnimation(1,0);
        anim4.setFillAfter(true);
        anim4.setDuration(3000);
        anim4.setStartOffset(9000);

        animaciones.addAnimation(anim3);
        animaciones.addAnimation(anim2);
        animaciones.addAnimation(anim1);
        animaciones.addAnimation(anim4);
        tv.startAnimation(animaciones);
    }
}