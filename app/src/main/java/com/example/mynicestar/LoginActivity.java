package com.example.mynicestar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

/**
 * Crea un Activity en el que te puedes logear o registrar
 * @author Marisa
 * @see RegisterActivity
 * @see MainActivity
 */
public class LoginActivity extends AppCompatActivity {
    TextView textR;
    MaterialButton buttonLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        Animation myanim2 = AnimationUtils.loadAnimation(this,R.anim.scale);
        imageView3.startAnimation(myanim2);

        buttonLog = (MaterialButton) findViewById(R.id.buttonLog);
        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);




                    }
                });
        textR = (TextView) findViewById(R.id.textViewR);
        textR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);




            }
        });
            }
        }