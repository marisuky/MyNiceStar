package com.example.mynicestar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class MainActivity extends AppCompatActivity {


    TextView textVOK;
    Button buttonok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonok = (Button)findViewById(R.id.buttonok);
                buttonok.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);


            }
        });
        ImageView fondo = findViewById(R.id.imageViewimagyo);
        Glide.with(this)
                .load(R.drawable.imagyo)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.colorAccent2)))
                .circleCrop()
                .into(fondo);

    }
}