package com.example.yugantjoshi.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String Extra_ANSWER_IS_TRUE = "com.example.yugant.geoquiz.answer_is_true";
    private boolean answerIsTrue;
    private TextView answerTextView;
    private Button showAnswerButton;
    public static Intent newIntent(Context packageContext, boolean answerIsTrue)
    {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(Extra_ANSWER_IS_TRUE,answerIsTrue);
        return i;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        answerIsTrue = getIntent().getBooleanExtra(Extra_ANSWER_IS_TRUE, false);

        answerTextView = (TextView) findViewById(R.id.answer_text_view);
        showAnswerButton = (Button) findViewById(R.id.show_answer_button);
        showAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerIsTrue == true)
                {
                    answerTextView.setText(R.string.true_button);
                }
                else
                {
                    answerTextView.setText(R.string.false_button);
                }
            }
        });
    }
}
