package com.example.mynicestar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Crea un Avtivity con una animación y arranca el login
 * @author Marisa
 * @see LoginActivity
 */
public class SplashScreen extends Activity {
   @Override

    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash_creen);

       ImageView imageView = (ImageView) findViewById(R.id.carret);
       Animation myanim = AnimationUtils.loadAnimation(this,R.anim.alpha);
       imageView.startAnimation(myanim);

       ImageView fondo = findViewById(R.id.carret);
       Glide.with(this)
               .load(R.drawable.carretera)
               .centerCrop()
               .transition(DrawableTransitionOptions.withCrossFade(500))
               .placeholder(new ColorDrawable(this.getResources().getColor(R.color.colorAccent)))

               .into(fondo);



   openApp(true);}
    private void openApp(boolean locationPermission) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen
                        .this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
