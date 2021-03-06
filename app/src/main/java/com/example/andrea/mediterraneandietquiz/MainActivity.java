package com.example.andrea.mediterraneandietquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scorePoint = 0;
    RadioButton answer1;
    RadioButton answer2;
    RadioButton answer3;
    RadioButton answer6;
    RadioButton answer8;
    RadioButton answer9;

    Button resultQuiz;

    EditText namePlayer;

    CheckBox answerRight4A;
    CheckBox answerRight4B;
    CheckBox answerRight7A;
    CheckBox answerRight7B;
    CheckBox answerWrong4A;
    CheckBox answerWrong4B;
    CheckBox answerWrong7A;
    CheckBox answerWrong7B;

    EditText answer5;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scoreQuiz", scorePoint);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null)
            scorePoint = savedInstanceState.getInt("scoreQuiz");

        answer1 = findViewById(R.id.answerRight1);
        answer2 = findViewById(R.id.answerRight2);
        answer3 = findViewById(R.id.answerRight3);
        answer6 = findViewById(R.id.answerRight6);
        answer8 = findViewById(R.id.answerRight8);
        answer9 = findViewById(R.id.answerRight9);

        namePlayer = findViewById(R.id.enter_name);

        answerRight4A = findViewById(R.id.answerRight4A);
        answerRight4B = findViewById(R.id.answerRight4B);
        answerRight7A = findViewById(R.id.right_box7A);
        answerRight7B = findViewById(R.id.right_box7B);
        answerWrong4A = findViewById(R.id.answerWrong4A);
        answerWrong4B = findViewById(R.id.answerWrong4B);
        answerWrong7A = findViewById(R.id.wrong_box7A);
        answerWrong7B = findViewById(R.id.wrong_Box7B);
        answer5 = findViewById(R.id.answer5);
        resultQuiz = findViewById(R.id.resultQuiz);
    }
    public void checkQuiz(View view) {

        String name = namePlayer.getText().toString();

        boolean getAnswerOne = answer1.isChecked();
        boolean getAswerTwo = answer2.isChecked();
        boolean getAnswerThree = answer3.isChecked();
        boolean getAnswerSix = answer6.isChecked();
        boolean getAnswereight = answer8.isChecked();
        boolean getAnswerNine = answer9.isChecked();
        boolean getAnswerBoxFourA = answerRight4A.isChecked();
        boolean getAswerBoxFourB = answerRight4B.isChecked();
        boolean getAnswerBoxSevenA = answerRight7A.isChecked();
        boolean getAnswerBoxSevenB = answerRight7B.isChecked();
        boolean wrongAnswerBoxFourA = answerWrong4A.isChecked();
        boolean wrongAnswerBoxFourB = answerWrong4B.isChecked();
        boolean wrongAnswerBoxSevenA = answerWrong7A.isChecked();
        boolean wrongAnswerBoxSevenB = answerWrong7B.isChecked();
        String getAnswerFive = answer5.getText().toString();
        int scorePoint = calculateQuiz(getAnswerOne, getAswerTwo, getAnswerThree, getAnswerSix, getAnswereight, getAnswerNine,
                getAnswerBoxFourA, getAswerBoxFourB, getAnswerBoxSevenA, getAnswerBoxSevenB, wrongAnswerBoxFourA,
                wrongAnswerBoxFourB, wrongAnswerBoxSevenA, wrongAnswerBoxSevenB, getAnswerFive);
        if (scorePoint > 0 && scorePoint <= 5) {
            createToastMessage(name + "   " + getString(R.string.JavaR) + "   " + scorePoint, R.drawable.fork);
        } else if (scorePoint > 5 && scorePoint < 9) {
            createToastMessage(name + " " + getString(R.string.MedPoint) + "  " + scorePoint, R.drawable.plant);
        } else if (scorePoint == 9) {
            createToastMessage(name + "  " + getString(R.string.fullPoint) + "   " + scorePoint, R.drawable.table);
        }
        resetQuiz(view);
    }


    public void resetQuiz(View v) {
        scorePoint = 0;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void createToastMessage(String textMessage, int imageId) {
        Context context = getApplicationContext();
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));
        TextView text = (TextView) layout.findViewById(R.id.text);
        ImageView image = (ImageView) layout.findViewById(R.id.imagetoast);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        text.setText(textMessage);
        image.setImageResource(imageId);
        toast.show();
        return;
    }
    private int calculateQuiz(boolean answerOne, boolean answerTwo, boolean answerThree, boolean answerSix, boolean answerEight,
                              boolean answerNine, boolean answerBoxFourA, boolean answerBoxFourB, boolean answerBoxSevenA, boolean answerBoxSevenB,
                              boolean wrongBoxFourA, boolean wrongBoxFourB, boolean wrongBoxSevenA, boolean wrongBoxSevenB, String answerFive) {
        int scoreQuiz = 0;
        String editAnswer = "Italy";
        if (answerOne) {
            scoreQuiz++;
        }
        if (answerTwo) {
            scoreQuiz++;
        }
        if (answerThree) {
            scoreQuiz++;

        }
        if (answerSix) {
            scoreQuiz++;
        }
        if (answerEight) {
            scoreQuiz++;
        }
        if (answerNine) {
            scoreQuiz++;
        }
        if (answerBoxFourA && answerBoxFourB && !wrongBoxFourB && !wrongBoxFourA) {
            scoreQuiz++;
        }

        if (answerBoxSevenA && answerBoxSevenB && !wrongBoxSevenA && !wrongBoxSevenB) {
            scoreQuiz++;
        }
        if (answerFive.equalsIgnoreCase(editAnswer)) {
            scoreQuiz++;
        }
        return scoreQuiz;

    }

}








