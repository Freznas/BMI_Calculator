package com.example.bmikalkylatorn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TextView textView;
    Button helloButton;
    EditText inputheight;
    EditText inputweight;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById((R.id.tv_instructions));
        inputheight = findViewById(R.id.et_height);
        inputweight = findViewById(R.id.et_weight);
        textView.setText(R.string.instruction);

        helloButton = findViewById(R.id.btn_calculate);
        helloButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "du gjorde en uträkning", Toast.LENGTH_LONG).show();
                calculateBmi();


            }
        });
    }

    public void getheight()
    {
        String message = inputheight.getText().toString();
        textView.setText(message);
    }

    public void getweight()
    {
        String message = inputweight.getText().toString();
        textView.setText(message);
    }

    public void calculateBmi()
    {
        String heightStr = inputheight.getText().toString();
        String weightStr = inputweight.getText().toString();
        if (!heightStr.isEmpty() && !weightStr.isEmpty())
        {
            int height = Integer.parseInt(heightStr);
            int weight = Integer.parseInt(weightStr);

            double bmi = calculateBmi(height, weight);
            String formattedBmi = String.format("%.2f", bmi);
            textView.setText(("Ditt BMI är:" + formattedBmi));
        }
        else
        {
            Toast.makeText(MainActivity.this,"fyll i både längd och vikt,",Toast.LENGTH_LONG).show();
        }

    }

    private double calculateBmi(int height, int weight)
    {
        // Beräkna BMI enligt formeln (vikt / (längd * längd))
        double heightInMeter = height / 100.0; // Konvertera längden till meter
        return weight / (heightInMeter * heightInMeter);
    }
}
