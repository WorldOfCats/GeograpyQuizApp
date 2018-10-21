package com.example.sotito.quizapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private final short questionsCount = 4;
    private RadioGroup qestion2, qestion4;
    private short score;
    private boolean submited;

    private CheckBox qestion1a1, qestion1a2, qestion1a3;
    private RadioButton qestion2a1, qestion2a2, qestion2a3;
    private EditText q3a1;
    private RadioButton qestion4a1, qestion4a2, qestion4a3;

    private Button submit, reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submited = false;
        // initiate
        intialize();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(addition.submited, submited);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        submited = savedInstanceState.getBoolean(addition.submited);
        if (submited) checkScore(submited);
    }

    public void checkScore(boolean flag) {
        score = 0;
        submited = true;
        // question 1
        if (qestion1a1.isChecked() && qestion1a2.isChecked() && !qestion1a3.isChecked()) score++;
        qestion1a1.setEnabled(false);
        qestion1a2.setEnabled(false);
        qestion1a3.setEnabled(false);


        // question 2
        if (qestion2a2.isChecked()) {
            score++;
        }
        for (int i = 0; i < qestion2.getChildCount(); i++)
            qestion2.getChildAt(i).setEnabled(false);
        // question 3
        String temp = this.getResources().getString(R.string.q3text).toUpperCase();
        if (q3a1.getText().toString().toUpperCase().equals(temp)) score++;
        q3a1.setEnabled(false);

        // question 4
        if (qestion4a3.isChecked()) {
            score++;
        }
        for (int i = 0; i < qestion2.getChildCount(); i++)
            qestion2.getChildAt(i).setEnabled(false);


        // show score toast message
        if (!flag) {
            @SuppressLint({"StringFormatInvalid", "LocalSuppress"}) String message = getResources().getString(R.string.summary, score, questionsCount);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        } else {
            @SuppressLint({"StringFormatInvalid", "LocalSuppress"}) String message = "error";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();


        }

    }

    public void reset() {
        submited = false;
        score = 0;
        // unckeck and enable all quiz views

        qestion1a1.setEnabled(true);
        qestion1a2.setEnabled(true);
        qestion1a3.setEnabled(true);


        qestion1a1.setChecked(false);
        qestion1a2.setChecked(false);
        qestion1a3.setChecked(false);

        qestion2.clearCheck();
        for (int i = 0; i < qestion2.getChildCount(); i++)
            qestion2.getChildAt(i).setEnabled(true);


        q3a1.setEnabled(true);
        q3a1.setText("");


        qestion4.clearCheck();
        for (int i = 0; i < qestion4.getChildCount(); i++)
            qestion4.getChildAt(i).setEnabled(true);
    }


    private void intialize() {
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkScore(false);
            }
        });
        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        qestion1a1 = (CheckBox) findViewById(R.id.q1a1);
        qestion1a2 = (CheckBox) findViewById(R.id.q1a2);
        qestion1a3 = (CheckBox) findViewById(R.id.q1a3);


        qestion2 = (RadioGroup) findViewById(R.id.q2);
        qestion2a1 = (RadioButton) findViewById(R.id.q2a1);
        qestion2a2 = (RadioButton) findViewById(R.id.q2a2);
        qestion2a3 = (RadioButton) findViewById(R.id.q2a3);


        q3a1 = (EditText) findViewById(R.id.q3a1);

        qestion4 = (RadioGroup) findViewById(R.id.q4);
        qestion4a1 = (RadioButton) findViewById(R.id.q4a1);
        qestion4a2 = (RadioButton) findViewById(R.id.q4a2);
        qestion4a3 = (RadioButton) findViewById(R.id.q4a3);


    }
}
