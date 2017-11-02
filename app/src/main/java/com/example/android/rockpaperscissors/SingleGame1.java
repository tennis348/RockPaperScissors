package com.example.android.rockpaperscissors;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.jar.Attributes;

import static android.R.attr.childIndicator;
import static android.R.attr.id;
import static android.R.attr.name;
import static android.R.attr.queryActionMsg;
import static android.R.attr.start;
import static android.R.attr.x;
import static android.graphics.Color.CYAN;
import static com.example.android.rockpaperscissors.R.id.image;
import static com.example.android.rockpaperscissors.R.id.player1;

/**
 * Created by Vinay on 10/25/2017.
 */

public class SingleGame1 extends AppCompatActivity {
    int paper = 0;
    int rock = 0;
    int scissor = 0;
    int clickCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_game);

        final String player1 = getIntent().getStringExtra("name1");
        final String player2 = getIntent().getStringExtra("name2");

        final ImageView image1 = (ImageView) findViewById(R.id.imageView1);
        final ImageView image2 = (ImageView) findViewById(R.id.imageView2);
        final ImageView image3 = (ImageView) findViewById(R.id.imageView3);
        Button button = (Button) findViewById(R.id.select_btn);
        TextView name = (TextView) findViewById(R.id.name_text);

        name.setText(player1 + "'s " + "Turn");

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCounter++;
                if (clickCounter == 1) {
                    image1.setColorFilter(CYAN);
                    paper = 5;
                } else {
                    image1.setColorFilter(Color.BLACK);
                    clickCounter = 0;
                    paper = 0;
                }
            }
        });


        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCounter++;
                if (clickCounter == 1) {
                    image2.setColorFilter(CYAN);
                    rock = 5;
                } else {
                    image2.setColorFilter(Color.BLACK);
                    clickCounter = 0;
                    rock = 0;
                }
            }
        });


        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCounter++;
                if (clickCounter == 1) {
                    image3.setColorFilter(CYAN);
                    scissor = 5;
                } else {
                    image3.setColorFilter(Color.BLACK);
                    clickCounter = 0;
                    scissor = 0;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((paper == 5 && rock == 5) || (paper == 5 && scissor == 5) || (rock == 5 && scissor == 5)){
                    Toast.makeText(SingleGame1.this, "Choose only ONE hand!", Toast.LENGTH_SHORT).show();
                }else if(paper == 0 && rock == 0 && scissor == 0){
                    Toast.makeText(SingleGame1.this, "Select something!", Toast.LENGTH_SHORT).show();
                } else{
                    Intent intent = new Intent(SingleGame1.this, SingleGame2.class);
                    intent.putExtra("paper", paper);
                    intent.putExtra("rock", rock);
                    intent.putExtra("scissor", scissor);
                    intent.putExtra("name3", player2);
                    intent.putExtra("player1", player1);
                    startActivity(intent);
                }

            }
        });


    }

}



