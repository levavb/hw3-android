package com.example.triviaapp; 

import android.content.Intent; 
import android.support.v7.app.AppCompatActivity; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.TextView; 

public class complimentsPage extends AppCompatActivity { 

    @Override

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compliments_page);

        Intent intent = getIntent();
        String userN = intent.getStringExtra("userName");
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText("Congratulations "+ userN); 
    } 
 
    public void goToHomePage(View view) { 
        Intent intent = new Intent(complimentsPage.this,MainActivity.class); 
        startActivity(intent); 
    } 
} 
