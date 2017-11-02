package com.example.android.rockpaperscissors;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.CYAN;
import static com.example.android.rockpaperscissors.R.id.player1;

/**
 * Created by Vinay on 10/28/2017.
 */

public class SingleGame2 extends AppCompatActivity {
    int paper = 0;
    int rock = 0;
    int scissor = 0;
    int clickCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_game_2);

        final String player1 = getIntent().getStringExtra("player1");
        final String player2 = getIntent().getStringExtra("name3");
        final int paper_data1 = getIntent().getIntExtra("paper", 0);
        final int rock_data1 = getIntent().getIntExtra("rock", 0);
        final int scissor_data1 = getIntent().getIntExtra("scissor", 0);

        final ImageView image1 = (ImageView) findViewById(R.id.imageView1);
        final ImageView image2 = (ImageView) findViewById(R.id.imageView2);
        final ImageView image3 = (ImageView) findViewById(R.id.imageView3);
        Button button = (Button) findViewById(R.id.select_btn);
        TextView name = (TextView) findViewById(R.id.name_text_2);

        name.setText(player2 + "'s " + "Turn");

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
                if ((paper == 5 && rock == 5) || (paper == 5 && scissor == 5) || (rock == 5 && scissor == 5)) {
                    Toast.makeText(SingleGame2.this, "Choose only ONE hand!", Toast.LENGTH_SHORT).show();
                } else if (paper == 0 && rock == 0 && scissor == 0) {
                    Toast.makeText(SingleGame2.this, "Select something!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SingleGame2.this, Validator.class);
                    intent.putExtra("paper1", paper_data1);
                    intent.putExtra("rock1", rock_data1);
                    intent.putExtra("scissor1", scissor_data1);
                    intent.putExtra("paper2", paper);
                    intent.putExtra("rock2", rock);
                    intent.putExtra("scissor2", scissor);
                    intent.putExtra("player1", player1);
                    intent.putExtra("player2", player2);
                    startActivity(intent);
                }
            }

        });


    }

}