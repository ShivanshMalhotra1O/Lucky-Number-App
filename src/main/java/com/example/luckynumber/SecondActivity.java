package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView welcomeTxt , luckyNumberTxt;
    Button button2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcomeTxt = findViewById(R.id.textView2);
        luckyNumberTxt = findViewById(R.id.lucky_number_txt);
        button2 = findViewById(R.id.sharebtn);

//        Receiving the data from Main Activity
        Intent intent = getIntent();
        String userName = intent.getStringExtra("Name");

        //    Generating random numbers
        int random_num = generateRandomNumber();
        luckyNumberTxt.setText(""+random_num);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName,random_num);
            }
        });
    }


    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;

        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;
    }

    public void shareData(String username, int randomNum){

//        Implicit Intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

//        Additional Info
        intent.putExtra(Intent.EXTRA_SUBJECT,username + "got lucky today");
        intent.putExtra(Intent.EXTRA_TEXT,username + "'s lucky number is : " + randomNum);

        startActivity(Intent.createChooser(intent,"Choose a Platform"));

    }
}