package com.example.android.rockpaperscissors;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

//    Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/yourfont.ttf");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int paper_score = getIntent().getIntExtra("paper", 0);
        final int rock_score = getIntent().getIntExtra("rock", 0);
        final int scissor_score = getIntent().getIntExtra("scissor", 0);

//        AssetManager am = getApplicationContext().getAssets();
//        typeface = Typeface.createFromAsset(am, String.format(Locale.US, "fonts/%s", "OpenSans-Regular.ttf"));

        Button singleGame = (Button) findViewById(R.id.single_game);
        Button playAI = (Button) findViewById(R.id.play_ai);
        getSupportActionBar().hide();

        singleGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mDialog = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialog, null);
                final EditText mPlayer1 = (EditText) mView.findViewById(R.id.player1);
                final EditText mPlayer2 = (EditText) mView.findViewById(R.id.player2);
                Button mCont_btn = mView.findViewById(R.id.btn_continue);

                mCont_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if ((!mPlayer1.getText().toString().isEmpty()) && (!mPlayer2.getText().toString().isEmpty()) ) {
                            Intent intent = new Intent(MainActivity.this, SingleGame1.class);
                            intent.putExtra("name1", mPlayer1.getText().toString());
                            intent.putExtra("name2", mPlayer2.getText().toString());
                            startActivity(intent);
                        }
                    }
                });
                mDialog.setView(mView);
                AlertDialog dialog = mDialog.create();
                dialog.show();

            }
        });

        playAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AI.class);
                intent.putExtra("paper", paper_score);
                intent.putExtra("rock", rock_score);
                intent.putExtra("scissor", scissor_score);
                startActivity(intent);
            }
        });

    }

}
