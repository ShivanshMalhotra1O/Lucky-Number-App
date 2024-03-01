package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    Initialising Widgets

    EditText editText;
    Button btn;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextText);
        btn = findViewById(R.id.button);

//        Functionality to buttons

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Getting user name
                String username = editText.getText().toString();

//                Explicit Intent

                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);

//                Passing the name to second activity. putExtra is used to send extra data along with the intent to the second activity and can be
//                retrieved later on.
//                Here name is the key and username is the value.
                intent.putExtra("Name",username);

                startActivity(intent);
            }
        });

    }
}