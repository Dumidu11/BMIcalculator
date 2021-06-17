package com.example.bmicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText age= (EditText) findViewById(R.id.age);
        EditText Height=(EditText) findViewById(R.id.height);
        EditText Weight=(EditText) findViewById(R.id.weight);
        Button button =(Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(age.getText().toString().equals("") || Height.getText().toString().equals("") || Weight.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(),"Enter your details",Toast.LENGTH_LONG).show();
                }
                else if (Integer.parseInt(age.getText().toString())<18) {
                       Toast.makeText(getApplicationContext(), "This Application use only 18+",Toast.LENGTH_LONG).show();
                   }
               else{
                   double BMI=(Double.parseDouble(Weight.getText().toString())/((Double.parseDouble(Height.getText().toString())*0.01)*(Double.parseDouble(Height.getText().toString())*0.01)));
                    String bmival=String.format("%.1f",BMI);
                    Toast.makeText(getApplicationContext(),bmival,Toast.LENGTH_LONG).show();
                    Intent BMIval=new Intent(MainActivity.this,MainActivity2.class);
                    Bundle ABC = new Bundle();
                    ABC.putString("val",bmival);
                    BMIval.putExtras(ABC);
                    startActivity(BMIval);
                }

                }

        });
    }
    @Override
    public void onBackPressed(){
        AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(this);

        dialogbuilder.setMessage("Do you want to exit?")
                .setTitle("Exit")
                .setCancelable(true)
                .setNegativeButton("cencel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        AlertDialog massgaebox = dialogbuilder.create();
        massgaebox.show();


    }

}