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
    //Här deklarerar vi variabler med passande simpla namn.
    TextView textView;
    Button helloButton;
    EditText inputheight;
    EditText inputweight;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//här nedan hämtar vi IDn för olika delar av appen.
        textView = findViewById((R.id.tv_instructions));
        inputheight = findViewById(R.id.et_height);
        inputweight = findViewById(R.id.et_weight);
        textView.setText(R.string.instruction);
        helloButton = findViewById(R.id.btn_calculate);
        helloButton.setOnClickListener(new View.OnClickListener()

        {
            /**
             *
             * @param v här skapar vi en onclick metod som skickar upp en Toast när man klickar på
             *          knappen som även ändrar texten för instruktioner till resultat av uträkningen av BMI.
             */
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "du gjorde en uträkning", Toast.LENGTH_LONG).show();
                calculateBmi();



            }
        });
    }

    /**
     * Här skapar vi strängar som hämtar inputen från längd och vikt inmatning.
     */
    public void calculateBmi()
    {
        String heightStr = inputheight.getText().toString();
        String weightStr = inputweight.getText().toString();
        /**
         * här skapar vi en if sats som tar inmatade strängar och kollar så det finns inmatning
         * i bägge så gör dem en uträkning av BMI på de båda talen
         */
        if (!heightStr.isEmpty() && !weightStr.isEmpty())
        {
            //här görs inmatningarna om från sträng till int.
            int height = Integer.parseInt(heightStr);
            int weight = Integer.parseInt(weightStr);

            double bmi = calculateBmi(height, weight);
            //Här begränsar vi antalet decimaler i uträkningen för hålla det enkelt och rent.
            String formattedBmi = String.format("%.2f", bmi);
            textView.setText(("Ditt BMI är:" + formattedBmi));

        }
        //om någon av villkoren inte uppfylls(dvs. att om antigen längd eller vikt fälten är tomma)
        //så får användaren en Toast som uppmanar att följa instruktionerna.
        else
        {
            Toast.makeText(MainActivity.this,"fyll i både längd och vikt,",Toast.LENGTH_LONG).show();

        }

    }
//Här sker uträkningen av BMIn baserat på inmatningen.
    private double calculateBmi(int height, int weight)
    {
        // Beräkna BMI enligt formeln (vikt / (längd * längd))
        double heightInMeter = height / 100.0; // Konvertera längden till meter
        return weight / (heightInMeter * heightInMeter);
    }
}
