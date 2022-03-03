package com.anmol_a00246505.anmol_score;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView plutoScoreText, jupiterScoreText;
    Switch teamSelector;
    RadioGroup scores;
    Button increaseButton, decreaseButton;

    int teamPluto = 0, teamJupiter = 1;
    int selectedTeam = teamPluto;
    int score = 1;
    int totalScorePluto = 10, totalScoreJupiter = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //==============
        //assigning objects to widgets used in xml by their id
        //==============
        plutoScoreText = findViewById(R.id.plutoScoreText);
        jupiterScoreText = findViewById(R.id.jupiterScoreText);
        teamSelector = findViewById(R.id.teamSelector);
        scores = findViewById(R.id.scores);
        increaseButton = findViewById(R.id.increaseScoreButton);
        decreaseButton = findViewById(R.id.decreaseScoreButton);

        //setting current score of the game
        plutoScoreText.setText(String.valueOf(totalScorePluto));
        jupiterScoreText.setText(String.valueOf(totalScoreJupiter));

        //==============
        //adding listeners to objects
        //==============

        //switch listener checks for change in switch
        teamSelector.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selectedTeam = teamJupiter;
                } else {
                    selectedTeam = teamPluto;
                }
            }
        });

        //radio group listener checks for change in radio button selection
        scores.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.score1:
                        score = 1;
                        break;
                    case R.id.score2:
                        score = 2;
                        break;
                    case R.id.score3:
                        score = 3;
                        break;
                    case R.id.score4:
                        score = 4;
                        break;
                    default:
                        score = 0;
                        break;
                }
            }
        });

        //button listeners checks if button was clicked

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedTeam == teamPluto){
                    totalScorePluto += score;
                    plutoScoreText.setText(String.valueOf(totalScorePluto));
                }
                else if(selectedTeam == teamJupiter){
                    totalScoreJupiter += score;
                    jupiterScoreText.setText(String.valueOf(totalScoreJupiter));
                }
            }
        });

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedTeam == teamPluto){
                    totalScorePluto -= score;
                    plutoScoreText.setText(String.valueOf(totalScorePluto));
                }
                else if(selectedTeam == teamJupiter){
                    totalScoreJupiter -= score;
                    jupiterScoreText.setText(String.valueOf(totalScoreJupiter));
                }
            }
        });

    }
}
