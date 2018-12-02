package com.example.kameyama.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String height = intent.getStringExtra("height");
        String weight = intent.getStringExtra("weight");

        Log.d("TEST", "ボタンがクリックされました  height:"+height+", weight :"+weight+"");

        if (height != null && !height.isEmpty() && weight != null && !weight.isEmpty()){
            double resultBmi = calcBmi(height,weight);
            String resultShape = selectShape(resultBmi);

            ((TextView)findViewById(R.id.bmiValue)).setText(String.valueOf(resultBmi));
            ((TextView)findViewById(R.id.resultShape)).setText(String.valueOf(resultShape));
        }

    }
    private double calcBmi(String height,String weight) {
        return Math.round(Double.valueOf(weight) / Math.pow(Double.valueOf(height) / 100, 2.0));
    }

    private String selectShape(double bmi){
        String shape = null;
        if (bmi < 18.5) {
            shape = "やせぎみ";
        }else if (bmi < 25.0){
            shape = "通常";
        }else{
            shape = "肥満";
        }
        return shape;
    }
}
