package com.example.triviaapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void StartTrivia(View view) {
        editT = findViewById(R.id.UserName);
        String userName = editT.getText().toString();

        if (userName.length() != 0 ) {
            Intent intent = new Intent(this, TriviaGame.class);
            intent.putExtra("userName",userName);
            startActivity(intent);
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
