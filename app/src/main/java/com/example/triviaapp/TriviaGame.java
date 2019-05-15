package com.example.triviaapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TriviaGame extends AppCompatActivity implements View.OnClickListener {
    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question;
    int Score = 0;
    private Questions questions = new Questions();
    private int q_index = 0;
    private String answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia_game);


        btn_one = (Button)findViewById(R.id.button2);
        btn_one.setOnClickListener(this);
        btn_two = (Button)findViewById(R.id.button3);
        btn_two.setOnClickListener(this);
        btn_three = (Button)findViewById(R.id.button5);
        btn_three.setOnClickListener(this);
        btn_four = (Button)findViewById(R.id.button6);
        btn_four.setOnClickListener(this);

        tv_question = (TextView)findViewById(R.id.tv_question);

        NextQuestion(q_index++);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                if(btn_one.getText() == answer){
                    NextQuestion(q_index++);
                    Score++;
                }else{
                    NextQuestion(q_index++);
                }

                break;

            case R.id.button3:
                if(btn_two.getText() == answer){
                    NextQuestion(q_index++);
                    Score++;

                }else{
                    NextQuestion(q_index++);
                }

                break;

            case R.id.button5:
                if(btn_three.getText() == answer){
                    NextQuestion(q_index++);
                    Score++;
                }else{
                    NextQuestion(q_index++);
                }

                break;

            case R.id.button6:
                if(btn_four.getText() == answer){
                    NextQuestion(q_index++);
                    Score++;
                }else{
                    NextQuestion(q_index++);
                }

                break;
        }
    }


    private void NextQuestion(int num){
        if(num >= 9){
            new AlertDialog.Builder(this)
                    .setTitle("End of the Game")
                    .setMessage("you have "+ Score +" correct answer")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(TriviaGame.this, MainActivity.class);
                            startActivity(intent);
                        }
                    })
                    .show();
            return;
        }
        Question q = questions.getQuestion(num);
        tv_question.setText(q.getTextQuestion());
        btn_one.setText(q.getAnswer1());
        btn_two.setText(q.getAnswer2());
        btn_three.setText(q.getAnswer3());
        btn_four.setText(q.getAnswer4());

        answer = q.getCorrectAnswer();
    }

}

