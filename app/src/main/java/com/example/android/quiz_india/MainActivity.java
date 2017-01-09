package com.example.android.quiz_india;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.checked;
import static android.R.attr.duration;
import static android.R.attr.name;
import static android.R.id.button2;
import static android.R.id.button3;
import static android.R.id.input;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score = 0;
    int finalScore = 0;

    public void submitScore(View view) {

        EditText name = (EditText) findViewById(R.id.capital);
        String capital = name.getText().toString().toLowerCase();

        if(capital.matches("new delhi")){
            score++;        }

        CheckBox hindiCheckBox = (CheckBox) findViewById(R.id.hindi);
        boolean checkedHindi = hindiCheckBox.isChecked();

        CheckBox englishCheckBox = (CheckBox) findViewById(R.id.english);
        boolean checkedEnglish = englishCheckBox.isChecked();

        CheckBox urduCheckBox = (CheckBox) findViewById(R.id.urdu);
        boolean checkedUrdu = urduCheckBox.isChecked();

        CheckBox bengaliCheckBox = (CheckBox) findViewById(R.id.bengali);
        boolean checkedBengali = bengaliCheckBox.isChecked();

        RadioButton himalaya = (RadioButton) findViewById(R.id.himalaya);
        boolean checkHimalaya = himalaya.isChecked();

        RadioButton hindu_kush = (RadioButton) findViewById(R.id.hindu_kush);
        boolean checkedHindu_kush = hindu_kush.isChecked();

        CheckBox gandhiCheckBox = (CheckBox) findViewById(R.id.gandhi);
        boolean checkedGandhi = gandhiCheckBox.isChecked();

        CheckBox nehruCheckBox = (CheckBox) findViewById(R.id.nehru);
        boolean checkedNehru = nehruCheckBox.isChecked();

        CheckBox ambedkarCheckBox = (CheckBox) findViewById(R.id.ambedkar);
        boolean checkedAmbedkar = ambedkarCheckBox.isChecked();

        CheckBox raj_kapoorCheckBox = (CheckBox) findViewById(R.id.raj_kapoor);
        boolean checkedRaj_kapoor = raj_kapoorCheckBox.isChecked();


        finalScore = calculateScore(checkedNehru, checkHimalaya, checkedHindi, checkedEnglish, checkedBengali, checkedUrdu,
                checkedGandhi, checkedAmbedkar, checkedRaj_kapoor, checkedHindu_kush);

        String finalMessage = displayMessage(msg);
        displayMessage(finalMessage);

        finalScore = 0;
        score = 0;
    }

    // Calculate Score
    private int calculateScore(boolean checkedNehru, boolean checkHimalaya, boolean checkedHindi,
                               boolean checkedEnglish, boolean checkedBengali, boolean checkedUrdu,
                               boolean checkedGandhi, boolean checkedAmbedkar, boolean checkedRajKapoor,
                               boolean checkedHinduKush
    ) {
        if (checkedEnglish && checkedHindi){
            if (!(checkedBengali || checkedUrdu)){
                score++;            }
        }

        if (checkedNehru){
            if(!(checkedAmbedkar || checkedGandhi || checkedRajKapoor))
                score++;        }

        if (checkHimalaya){
            score++;        }
        return score ;
    }

    // Print Score
    private void displayMessage(String message) {
        TextView finalScoreTextView = (TextView) findViewById(R.id.final_score);
        finalScoreTextView.setText(message);

        if (finalScore == 4) {
            Toast.makeText(this, "Congratulations! You have a perfect score!", Toast.LENGTH_SHORT).show();}
        else if (finalScore == 3){
            Toast.makeText(this, "Your final score is 3!", Toast.LENGTH_SHORT).show();
            }
        else if (finalScore == 2){
            Toast.makeText(this, "Your final score is 2", Toast.LENGTH_SHORT).show();
        }
        else if (finalScore == 1){
            Toast.makeText(this, "Your final score is 1", Toast.LENGTH_SHORT).show();
        }
        else if (finalScore == 0){
            Toast.makeText(this, "You need to read some wikipedia articles on India", Toast.LENGTH_SHORT).show();
        }
    }

    // Reset Score
    public void Reset(View v) {
        score = 0;
        finalScore = 0;
        displayMessage("Score set to Zero");
        RadioButton himalaya = (RadioButton) findViewById(R.id.himalaya);
        RadioButton hindu_kush = (RadioButton) findViewById(R.id.hindu_kush);
        CheckBox hindiCheckBox = (CheckBox) findViewById(R.id.hindi);
        CheckBox englishCheckBox = (CheckBox) findViewById(R.id.english);
        CheckBox urduCheckBox = (CheckBox) findViewById(R.id.urdu);
        CheckBox bengaliCheckBox = (CheckBox) findViewById(R.id.bengali);
        CheckBox gandhiCheckBox = (CheckBox) findViewById(R.id.gandhi);
        CheckBox nehruCheckBox = (CheckBox) findViewById(R.id.nehru);
        CheckBox ambedkarCheckBox = (CheckBox) findViewById(R.id.ambedkar);
        CheckBox raj_kapoorCheckBox = (CheckBox) findViewById(R.id.raj_kapoor);
        himalaya.setChecked(false);
        hindu_kush.setChecked(false);
        hindiCheckBox.setChecked(false);
        englishCheckBox.setChecked(false);
        urduCheckBox.setChecked(false);
        bengaliCheckBox.setChecked(false);
        gandhiCheckBox.setChecked(false);
        nehruCheckBox.setChecked(false);
        ambedkarCheckBox.setChecked(false);
        raj_kapoorCheckBox.setChecked(false);
        EditText name = (EditText) findViewById(R.id.capital);
        name.setText("");
    }
}
