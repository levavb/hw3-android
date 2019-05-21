package com.example.triviaapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class TriviaGame extends AppCompatActivity implements View.OnClickListener {
    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question;
    int Score = 0;
    private Questions questions;
    private int q_index = 0;
    private int NumOfQues;
    private String userN;
    private String answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia_game);
        Intent intent = getIntent();
        NumOfQues = intent.getIntExtra("quesNum",10);
        userN = intent.getStringExtra("userName");
        questions = new Questions(NumOfQues);

        try {
            questions.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        btn_one = (Button)findViewById(R.id.button1);
        btn_one.setOnClickListener(this);
        btn_two = (Button)findViewById(R.id.button2);
        btn_two.setOnClickListener(this);
        btn_three = (Button)findViewById(R.id.button3);
        btn_three.setOnClickListener(this);
        btn_four = (Button)findViewById(R.id.button4);
        btn_four.setOnClickListener(this);

        tv_question = (TextView)findViewById(R.id.tv_question);

        NextQuestion(q_index++);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                if(btn_one.getText() == answer){
                    Score++;
                }
                break;
            case R.id.button2:
                if(btn_two.getText() == answer){
                    Score++;
                }
                break;
            case R.id.button3:
                if(btn_three.getText() == answer){
                    Score++;
                }
                break;
            case R.id.button4:
                if(btn_four.getText() == answer){
                    Score++;
                }
                break;
        }
        NextQuestion(q_index++);
    }


    private void NextQuestion(int num){

        if(num == NumOfQues){
            new AlertDialog.Builder(this)
                    .setTitle("End of the Game")
                    .setMessage("you have "+ Score +" correct answer\nyour grade is: "+((Score*100)/NumOfQues))
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if(NumOfQues == Score) {
                                Intent comp_intent = new Intent(TriviaGame.this, complimentsPage.class);
                                comp_intent.putExtra("userName",userN);
                                startActivity(comp_intent);
                            } else {
                                Intent intent = new Intent(TriviaGame.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }
                    })
                    .show();
            return;
        }
        Question q = questions.questions[num];
        tv_question.setText(q.getTextQuestion());
        btn_one.setText(q.getAnswer1());
        btn_two.setText(q.getAnswer2());
        btn_three.setText(q.getAnswer3());
        btn_four.setText(q.getAnswer4());

        answer = q.getCorrectAnswer();
    }

}

