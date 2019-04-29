package com.example.android.quizapp;

import android.graphics.Color;
import android.provider.MediaStore;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * When the submit answer button is pressed
     */
    public void submitAnswer(View view) {
        // Check if Question 1 is selected
        RadioButton questionOne = (RadioButton) findViewById(R.id.question_one_correct);
        boolean hasAnswerOne = questionOne.isChecked();

        // Check which checkbox in Question 2 is selected
        CheckBox questionTwoA = (CheckBox) findViewById(R.id.question_two_correctOne);
        boolean hasAnswerTwoA = questionTwoA.isChecked();

        CheckBox questionTwoWrongA = (CheckBox) findViewById(R.id.question_two_wrongOne);
        boolean hasAnswerTwoWrongA = questionTwoWrongA.isChecked();

        CheckBox questionTwoB = (CheckBox) findViewById(R.id.question_two_correctTwo);
        boolean hasAnswerTwoB = questionTwoB.isChecked();

        CheckBox questionTwoWrongB = (CheckBox) findViewById(R.id.question_two_wrongTwo);
        boolean hasAnswerTwoWrongB = questionTwoWrongB.isChecked();

        // This Makes sure that the right two boxes in question 2 are selected
        boolean hasAnswerTwo = !hasAnswerTwoWrongA && !hasAnswerTwoWrongB && hasAnswerTwoA && hasAnswerTwoB;

        // check for question 3 answer
        EditText answerFieldQuestionThree = (EditText) findViewById(R.id.question_three_answer);
        String questionThree = answerFieldQuestionThree.getText().toString();
        // Checks for right answer
        boolean hasAnswerThree;

        if (questionThree.equals("Clubs")) {
            hasAnswerThree = true;
        } else if (questionThree.equals("clubs")) {
            hasAnswerThree = true;
        } else {
            hasAnswerThree = false;
        }


        // Check if Question 4 is selected
        RadioButton questionFour = (RadioButton) findViewById(R.id.question_four_correct);
        boolean hasAnswerFour = questionFour.isChecked();

        // call to calculate test score
        int testScore = calculateScore(hasAnswerOne, hasAnswerTwo, hasAnswerThree, hasAnswerFour);

        displayScore(testScore);
        Toast.makeText(this, "You have " + points + "/4 Correct", Toast.LENGTH_LONG).show();

    }

    /**
     *  Calculates the test score. Green title for correct and red title for wrong.
     */

    private int calculateScore(boolean hasAnswerOne, boolean hasAnswerTwo, boolean hasAnswerThree, boolean hasAnswerFour) {
        // id the question title
        TextView titleOne = (TextView) findViewById(R.id.titleOne);
        TextView titleTwo = (TextView) findViewById(R.id.titleTwo);
        TextView titleThree = (TextView) findViewById(R.id.titleThree);
        TextView titleFour = (TextView) findViewById(R.id.titleFour);

        points = 0;
        if (hasAnswerOne) {
            titleOne.setTextColor(Color.GREEN);
            points = points + 1;
        } else {
            titleOne.setTextColor(Color.RED);
        }

        if (hasAnswerTwo) {
            titleTwo.setTextColor(Color.GREEN);
            points = points + 1;
        } else {
            titleTwo.setTextColor(Color.RED);
        }

        if (hasAnswerThree) {
            titleThree.setTextColor(Color.GREEN);
            points = points + 1;
        } else {
            titleThree.setTextColor(Color.RED);
        }
        if (hasAnswerFour) {
            titleFour.setTextColor(Color.GREEN);
            points = points + 1;
        } else {
            titleFour.setTextColor(Color.RED);
        }
        return points;
    }


    private void displayScore(int testScore) {
        TextView scoreTextView = (TextView) findViewById(R.id.text_view_score);
        scoreTextView.setText(testScore + "/4 Correct");
    }

}