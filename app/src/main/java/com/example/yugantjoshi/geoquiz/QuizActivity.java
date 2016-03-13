package com.example.yugantjoshi.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button trueButton, falseButton, cheatButton;
    private TextView questionText;
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private ImageButton nextButton, previousButton;
    private int index =0;
    private Question[] questions = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = (TextView)findViewById(R.id.question_text);
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        nextButton = (ImageButton) findViewById(R.id.next_button);
        previousButton = (ImageButton) findViewById(R.id.prev_button);
        cheatButton = (Button) findViewById(R.id.cheat_button);

        questionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                index = (index+1)%questions.length;

                updateQuestion();
            }
        });
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
              public void onClick(View v) {
                index = (index+1)%questions.length;
                updateQuestion();
            }
        });
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try
                    {
                        index = (index-1)%questions.length;
                        if(index<0)
                        {
                            index= questions.length-1;
                        }
                        previousQuestion();
                    }
                    catch (java.lang.ArrayIndexOutOfBoundsException e)
                    {
                        Toast.makeText(QuizActivity.this, R.string.outOfBounds, Toast.LENGTH_SHORT).show();
                    }
            }
        });
        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                boolean answerIsTrue = questions[index].getIsTrue();
                Intent i = CheatActivity.newIntent(QuizActivity.this, answerIsTrue);
                startActivity(i);
            }
        });
        if(savedInstanceState!=null)
        {
            index = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        updateQuestion();
    }
    private void updateQuestion()
    {
        int question = questions[index].getResId();
        questionText.setGravity(Gravity.CENTER);
        questionText.setText(question);
    }
    private void previousQuestion()
    {
        int question = questions[index].getResId();
        questionText.setGravity(Gravity.CENTER);
        questionText.setText(question);
    }
    private void checkAnswer(boolean userTrue)
    {
        boolean answerTrue = questions[index].getIsTrue();
        int toastId;
        if(userTrue == answerTrue)
        {
            toastId = R.string.correct_toast;
        }
        else
        {
            toastId = R.string.incorrect_toast;
        }
        Toast.makeText(this, toastId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, index);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    public void onResume()
    {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
    @Override
    public void onStop()
    {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
}
