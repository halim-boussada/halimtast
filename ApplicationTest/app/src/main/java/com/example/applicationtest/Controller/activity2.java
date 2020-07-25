package com.example.applicationtest.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicationtest.Model.Question;
import com.example.applicationtest.Model.QuestionBank;
import com.example.applicationtest.R;

import java.util.Arrays;

public class activity2 extends AppCompatActivity implements View.OnClickListener   {
    private TextView mQuestionTextView;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mScore;
    private int mNumberOfQuestions;

    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
    public static final String BUNDLE_STATE_SCORE = "currentScore";
    public static final String BUNDLE_STATE_QUESTION = "currentQuestion";

    private boolean mEnableTouchEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        System.out.println("activity2::onCreate()");

        mQuestionBank = this.generateQuestions();

        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            mNumberOfQuestions = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
        } else {
            mScore = 0;
            mNumberOfQuestions = 4;
        }

        mEnableTouchEvents = true;


        mQuestionTextView = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerButton1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerButton2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerButton3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswerButton4 = (Button) findViewById(R.id.activity_game_answer4_btn);


        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);
        mAnswerButton4.setTag(3);

        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
    }


    @Override
    public void onClick(View view) {
        int responseIndex = (int) view.getTag();

        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            // Good answer
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            // Wrong answer
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();

        }
        mEnableTouchEvents = false;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEnableTouchEvents = true;

                if (--mNumberOfQuestions == 0) {
                    // End the game
                    endGame();
                } else {
                    mCurrentQuestion = mQuestionBank.getQuestion();
                    displayQuestion(mCurrentQuestion);
                }
            }
        }, 2000);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvents && super.dispatchTouchEvent(ev);
    }
    private void endGame(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Well done!")
                .setMessage("Your score is " + mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // End the activity
                        Intent intent = new Intent();
                        intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }).setCancelable(false)
                .create()
                .show();
    }
    private void displayQuestion(final Question question) {
        mQuestionTextView.setText(question.getQuestion());
        mAnswerButton1.setText(question.getChoiceList().get(0));
        mAnswerButton2.setText(question.getChoiceList().get(1));
        mAnswerButton3.setText(question.getChoiceList().get(2));
        mAnswerButton4.setText(question.getChoiceList().get(3));
    }
    private QuestionBank generateQuestions() {
        Question question1 = new Question("Tynass Travel",
                Arrays.asList("Est basé en AR", "Est en simple 3D", "est basé Vr", "hata wahda men hédhom"),
                0);

        Question question2 = new Question("Tynass CTO est",
                Arrays.asList("Samy", "Karim", "khalil", "Hsin"),
                2);

        Question question3 = new Question("Tynass CEO",
                Arrays.asList("Karim Hermi", "Mahdy ben Rezg", "Jhon MARKS", "Touhémy"),
                0);

        Question question4 = new Question("Tynass a ete cree",
                Arrays.asList("avril 2020", "mai 2019", "janvier 2019", "avril 2019"),
                3);

        Question question5 = new Question("Akser abd fi Tynass",
                Arrays.asList("Montasar", "Samy", "Baccar", "Mingo"),
                2);

        Question question6 = new Question("Tynass en africup elu ",
                Arrays.asList("1", "2", "3", "10"),
                2);

        Question question7 = new Question("Chkoun pitcha africup",
                Arrays.asList("Khalil", "Hsin", "Samy", "Karim"),
                2);

        Question question8 = new Question("Reunion tynass fel ada",
                Arrays.asList("ahad", "jem3A", "thnin", "sebt"),
                3);

        Question question9 = new Question("Application Tynass bech 9a3da tet5dem",
                Arrays.asList("React Native", "Swift", "FullStack Js", "android Studio"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9));
    }
    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("activity2::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("activity2::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("GameActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("GameActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("activity2::onDestroy()");
    }


}
