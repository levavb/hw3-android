package com.example.triviaapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editUserName;
    EditText editQuesNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void StartTrivia(View view) {
        editUserName = findViewById(R.id.UserName);
        String userName = editUserName.getText().toString();
        editQuesNum = findViewById(R.id.QuesNum);
        String quesNum = editQuesNum.getText().toString();

        if (userName.length() != 0 ) {
            if (quesNum.length() == 0 || quesNum.equals("0")) {
                new AlertDialog.Builder(this)
                        .setTitle("Missing Quantity of questions")
                        .setMessage("You need to enter a Quantity of questions")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            } else {
                try
                {
                    // checking valid integer using parseInt() method
                    int qNum = Integer.parseInt(quesNum);
                    Intent intent = new Intent(this, TriviaGame.class);
                    intent.putExtra("userName",userName);
                    intent.putExtra("quesNum",qNum);
                    startActivity(intent);
                }
                catch (NumberFormatException e) {
                    new AlertDialog.Builder(this)
                            .setTitle("Incorrect Quantity of questions")
                            .setMessage("Try again.")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .show();
                }
            }
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Missing User name")
                    .setMessage("You need to enter a User name")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .show();
        }
    }
}
