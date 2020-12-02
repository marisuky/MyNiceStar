package com.example.mynicestar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Crea un Activity en el que te puedes registrar o cancelar
 * @author Marisa
 * @see MainActivity
 * @see LoginActivity
 */
public class RegisterActivity extends AppCompatActivity {
    Button registerButton;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        Animation myanim2 = AnimationUtils.loadAnimation(this,R.anim.scale);
        imageView3.startAnimation(myanim2);
        registerButton = (Button)findViewById(R.id.buttonC);
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);

                startActivity(intent);


            }
        });
        registerButton = (Button)findViewById(R.id.buttonR);
        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);

                startActivity(intent);


            }
        });
      }

}
