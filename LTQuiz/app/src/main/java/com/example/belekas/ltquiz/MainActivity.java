package com.example.belekas.ltquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variables
    int scoreTotal;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Results button is clicked.
     */

    public void submitAnswers (View view) {

        // to enter user name
        EditText nameField = (EditText)findViewById(R.id.name_field);
        name = nameField.getText().toString();

        // 1st question radio button check
        RadioButton questOneButton = (RadioButton) findViewById(R.id.questOneYes);
        boolean yesChosen = questOneButton.isChecked();

        // 2nd question radio button check
        RadioButton questTwoButton = (RadioButton) findViewById(R.id.questTwoDalia);
        boolean daliaChosen = questTwoButton.isChecked();

        // enter answer field
        EditText answerText = (EditText) findViewById(R.id.enterAnswer);
        String answer = answerText.getText().toString();

        // to figure out of blue box is checked in question 5
        CheckBox questFourBaCheckBox = (CheckBox) findViewById(R.id.questFourBasketball);
        boolean questFourBas = questFourBaCheckBox.isChecked();

        // to figure out if red box box is checked in question 5
        CheckBox questFourBeCheckBox = (CheckBox) findViewById(R.id.questFourBeer);
        boolean QuestFourBe = questFourBeCheckBox.isChecked();

        // to figure out if red box box is checked in question 5
        CheckBox questFourCACheckBox = (CheckBox) findViewById(R.id.questFourCars);
        boolean QuestFourCA = questFourCACheckBox.isChecked();

        // total quiz score
        scoreTotal = calculateTotalScore (yesChosen, daliaChosen, answer, questFourBas,QuestFourBe, QuestFourCA);

        // toast messages with score, name and message
        if (scoreTotal == 0 || scoreTotal == 1 || scoreTotal == 2){
            Toast.makeText(this, "congrats " + name + "\nYour score is " + scoreTotal + "\nAnd you should not skip geography lessons", Toast.LENGTH_LONG).show();
        }

        else{
            Toast.makeText(this, "congrats " + name + "\nYour score is " + scoreTotal + "\nGood Job!! ", Toast.LENGTH_LONG).show();
        }

    }

    //calculating the score
    private int calculateTotalScore (boolean yesChosen, boolean daliaChosen,  String answer, boolean questFourBas, boolean QuestFourBe, boolean QuestFourCA){
        int rez = 0;
        // if 1st answer correct +1
        if (yesChosen){
            rez = rez + 1;
        }
        // if 2nd answer correct +1
        if (daliaChosen){
            rez= rez + 1;
        }
        // if 3nd answer correct +1
        if (answer.equalsIgnoreCase("Europe")) {

            rez = rez + 1;
        }
        // if 4th answer correct +1
        if (questFourBas == true && QuestFourBe == true && QuestFourCA == false){
            rez= rez + 1;
        }

        return rez;
    }

}



