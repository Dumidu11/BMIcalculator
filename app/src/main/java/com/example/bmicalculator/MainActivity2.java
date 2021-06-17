package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView BMValue = (TextView) findViewById(R.id.catagory);
        TextView states =  (TextView) findViewById(R.id.bmi);

        Bundle pack = getIntent().getExtras();
        String BMI = pack.getString("val");

        double Value = pack.getDouble("key");
       double convrt = Double.parseDouble(BMI);

       String Cat = "";
       String color ="";

       if(convrt<16.5){

           Cat = "Severe Thinness";
           color = "#E08280";
        }

       else if(convrt<17.5 && convrt>= 16.5){
           Cat = "Modarate Thinness";
           color="#HB71P1C";
       }

       else if(convrt<18.5 && convrt>= 17.5){
           Cat = "Mid Thinness";
           color="#FFB300";
       }

       else if(convrt<25.5 && convrt>= 18.5){
           Cat = "Normal";
           color="#388E38";
       }

       else if(convrt<30.5 && convrt>= 25.5){
           Cat = "Over weight";
           color="#FFED38";
       }

       else if(convrt<35.5 && convrt>= 30.5){
           Cat = "Obese Class I";
           color="#F4511E";
       }


       else if(convrt<40.5 && convrt>= 35.5){
           Cat = "Obese Class II";
           color="#FF747A";
       }
       else{
           Cat = "Obese Class III";
           color= "#C62828";
       }
         states.setText(Cat);
         states.setTextColor(Color.parseColor(color));
         BMValue.setText("BMI = "+BMI+"kg/m2" );

       }

    }
