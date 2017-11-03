package com.example.android.rockpaperscissors;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.rockpaperscissors.R.id.player1;
import static com.example.android.rockpaperscissors.R.id.player2;

/**
 * Created by Vinay on 10/28/2017.
 */

public class Validator extends AppCompatActivity {

    static int paper_count = 0;
    static int rock_count = 0;
    static int scissor_count = 0;
    String fancy2 = "blocked";
    String fancy3 = "crushed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.validator);

        final String player1 = getIntent().getStringExtra("player1");
        final String player2 = getIntent().getStringExtra("player2");
        final int paper1 = getIntent().getIntExtra("paper1", 0);
        final int rock1 = getIntent().getIntExtra("rock1", 0);
        final int scissor1 = getIntent().getIntExtra("scissor1", 0);
        int paper2 = getIntent().getIntExtra("paper2", 0);
        int rock2 = getIntent().getIntExtra("rock2", 0);
        int scissor2 = getIntent().getIntExtra("scissor2", 0);
        String greater_sign = ">";
        String smaller_sign = "<";
        String equal_sign = "=";

        TextView name1 = (TextView) findViewById(R.id.player1);
        TextView name2 = (TextView) findViewById(R.id.player2);
        TextView fancy = (TextView) findViewById(R.id.fancy_text);
        Button button = (Button) findViewById(R.id.replay_btn);
        Button button1 = (Button) findViewById(R.id.main_menu_btn);
        ImageView player1Image = (ImageView) findViewById(R.id.player_image1);
        ImageView player2Image = (ImageView) findViewById(R.id.player_image2);
        TextView signs = (TextView) findViewById(R.id.signs);

        if (paper1 == 5) {
            player1Image.setImageResource(R.drawable.paper_hand);
            if (rock2 == 5) {
                name1.setText(player1);
                fancy.setText(fancy2);
                name2.setText(player2);
                player2Image.setImageResource(R.drawable.rock_hand);
                signs.setText(greater_sign);
            } else if (scissor2 == 5) {
                name1.setText(player2);
                fancy.setText("shred " + player1.toString());
                name2.setText("to pieces");
                player2Image.setImageResource(R.drawable.scissor_hand);
                signs.setText(smaller_sign);
            } else {
                name1.setText(player1);
                fancy.setText("drew with");
                name2.setText(player2);
                player2Image.setImageResource(R.drawable.paper_hand);
                signs.setText(equal_sign);
            }
        }

        if (rock1 == 5) {
            player1Image.setImageResource(R.drawable.rock_hand);
            if (paper2 == 5) {
                name1.setText(player2);
                fancy.setText(fancy2);
                name2.setText(player1);
                player2Image.setImageResource(R.drawable.paper_hand);
                signs.setText(smaller_sign);
            } else if (scissor2 == 5) {
                name1.setText(player1);
                fancy.setText(fancy3);
                name2.setText(player2);
                player2Image.setImageResource(R.drawable.scissor_hand);
                signs.setText(greater_sign);
            } else {
                name1.setText(player1);
                fancy.setText("drew with");
                name2.setText(player2);
                player2Image.setImageResource(R.drawable.rock_hand);
                signs.setText(equal_sign);
            }
        }

        if (scissor1 == 5) {
            player1Image.setImageResource(R.drawable.scissor_hand);
            if (paper2 == 5) {
                name1.setText(player1);
                fancy.setText("shred " + player2.toString());
                name2.setText("to pieces");
                player2Image.setImageResource(R.drawable.paper_hand);
                signs.setText(greater_sign);
            } else if (rock2 == 5) {
                name1.setText(player2);
                fancy.setText(fancy3);
                name2.setText(player1);
                player2Image.setImageResource(R.drawable.rock_hand);
                signs.setText(smaller_sign);
            } else {
                name1.setText(player1);
                fancy.setText("drew with");
                name2.setText(player2);
                player2Image.setImageResource(R.drawable.scissor_hand);
                signs.setText(equal_sign);
            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Validator.this, SingleGame1.class);
                intent.putExtra("name1", player1);
                intent.putExtra("name2", player2);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Validator.this, MainActivity.class);
//                intent.putExtra("paper", paper1);
//                intent.putExtra("rock", rock1);
//                intent.putExtra("scissor", scissor1);
//                startActivity(intent);
                Intent intent1 = new Intent(Validator.this, AI.class);
                intent1.putExtra("paper", paper1);
                intent1.putExtra("rock", rock1);
                intent1.putExtra("scissor", scissor1);
                intent1.putExtra("paper_count", paper_count++);
                intent1.putExtra("rock_count", rock_count++);
                intent1.putExtra("scissor_count", scissor_count++);
                startActivity(intent1);
            }
        });


    }
}
