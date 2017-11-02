package com.example.android.rockpaperscissors;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.media.MediaCodec.MetricsConstants.MODE;

/**
 * Created by Vinay on 10/30/2017.
 */

public class AI extends AppCompatActivity {

    int paper_score;
    int rock_score;
    int scissor_score;

    int paper_data;
    int rock_data;
    int scissor_data;

    public static final int MODE_PRIVATE = 0;
    private SharedPreferences preferencesSettings;
    private SharedPreferences.Editor preferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ai_view);

        paper_score = getIntent().getIntExtra("paper", 0);
        rock_score = getIntent().getIntExtra("rock", 0);
        scissor_score = getIntent().getIntExtra("scissor", 0);

        paper_data = paper_score / 5;
        rock_data = rock_score / 5;
        scissor_data = scissor_score / 5;

        TextView textView = (TextView) findViewById(R.id.paperScore);
        TextView textView1 = (TextView) findViewById(R.id.rockScore);
        TextView textView2 = (TextView) findViewById(R.id.scissorScore);

        textView.setText(" " + paper_data);
        textView1.setText(" " + rock_data);
        textView2.setText(" " + scissor_data);

    }

    @Override
    protected void onPause() {
        super.onPause();

        if (paper_data != 0) {
            preferencesSettings = getPreferences(MODE_PRIVATE);
            preferenceEditor = preferencesSettings.edit();
            preferenceEditor.putInt("paper_value", paper_data);
//            preferenceEditor.putInt("rock_value", rock_data);

            preferenceEditor.commit();
            TextView paper = (TextView) findViewById(R.id.paperScore);
            paper.setText(" " + paper_data);
//            TextView rock = (TextView) findViewById(R.id.rockScore);
//            rock.setText(" " + rock_data);

            Toast.makeText(this, "the value is " + paper_data, Toast.LENGTH_SHORT).show();
        }

        if (rock_data != 0) {
            preferencesSettings = getPreferences(MODE_PRIVATE);
            preferenceEditor = preferencesSettings.edit();
//            preferenceEditor.putInt("paper_value", paper_data);
            preferenceEditor.putInt("rock_value", rock_data);

            preferenceEditor.commit();
//            TextView paper = (TextView) findViewById(R.id.paperScore);
//            paper.setText(" " + paper_data);
            TextView rock = (TextView) findViewById(R.id.rockScore);
            rock.setText(" " + rock_data);
        }

        if (scissor_data != 0){
            preferencesSettings = getPreferences(MODE_PRIVATE);
            preferenceEditor = preferencesSettings.edit();
            preferenceEditor.putInt("scissor_value", scissor_data);
//            preferenceEditor.putInt("rock_value", rock_data);

            preferenceEditor.commit();
            TextView scissor = (TextView) findViewById(R.id.paperScore);
            scissor.setText(" " + scissor_data);
//            TextView rock = (TextView) findViewById(R.id.rockScore);
//            rock.setText(" " + rock_data);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        preferencesSettings = getPreferences(MODE_PRIVATE);
        int paper_final_data = preferencesSettings.getInt("paper_value", 0);
        int rock_final_data = preferencesSettings.getInt("rock_value", 0);
        int scissor_final_data = preferencesSettings.getInt("scissor_value", 0);

        TextView paper_text = (TextView) findViewById(R.id.paperScore);
        paper_text.setText(" " + paper_final_data);

        TextView rock_text = (TextView) findViewById(R.id.rockScore);
        rock_text.setText(" " + rock_final_data);

        TextView scissor_text = (TextView) findViewById(R.id.scissorScore);
        scissor_text.setText(" " + scissor_final_data);

        Toast.makeText(this, "Did I get restored?", Toast.LENGTH_SHORT).show();
    }
}
