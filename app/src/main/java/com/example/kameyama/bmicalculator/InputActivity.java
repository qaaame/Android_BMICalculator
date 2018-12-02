package com.example.kameyama.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Button calcButton = findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                EditText editHeight = (EditText)findViewById(R.id.heightEdit);
                String strHeight = editHeight.getText().toString();
                EditText editWeight = (EditText) findViewById(R.id.weightEdit);
                String strWeight = editWeight.getText().toString();


                Intent intent;
                intent = new Intent(InputActivity.this, ResultActivity.class);
                intent.putExtra("height",strHeight);
                intent.putExtra("weight",strWeight);
                startActivity(intent);
            }
        });
    }
}
