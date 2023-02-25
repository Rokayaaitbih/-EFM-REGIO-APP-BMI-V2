package com.example.efmregionaljavav2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText weight ;
    EditText height ;
    Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight	=findViewById(R.id.weight);
        height 	=findViewById(R.id.height);
        btn	=findViewById(R.id.ok);

        btn.setOnClickListener(btnListener);

    }
    private View.OnClickListener btnListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            String w = weight.getText().toString(); //On récupère la taille saisie par l'utilisateur et on l'affecte à la variable t
            String h = height.getText().toString(); //On récupère le poid saisie par l'utilisateur et on l'affecte à la variable p
            float wValue = Float.valueOf(w); //On transforme la valeur que contient t en float et on l'affecte à la variable tValue
            float hValue = Float.valueOf(h); //On trans
            wValue = (float)Math.pow(wValue, 2);
            float bmi =  wValue / 703* hValue ; //Calcule de l'IMC
            bmi = (float)Math.round(bmi*100)/100; //Arrondie à 2 chiffres après la virgule.
            //On verifie si un des champ est vide
            if (weight.getText().toString().isEmpty() || height.getText().toString().isEmpty()){

                //Message d'erreur si un des champs est vide.
                Resources message = getResources();
                Toast.makeText(MainActivity.this, message.getString(R.string.toast_message_erreur_saisie), Toast.LENGTH_LONG).show();
            }
            else if (bmi<18.5){
                Resources message = getResources();
                Toast.makeText(MainActivity.this, message.getString(R.string.Underweight), Toast.LENGTH_LONG).show();

            }
            else if (bmi>18.5||bmi<25){
                Resources message = getResources();
                Toast.makeText(MainActivity.this, message.getString(R.string.Normal), Toast.LENGTH_LONG).show();
            }
            else if (bmi>25||bmi<40){
                Resources message = getResources();
                Toast.makeText(MainActivity.this, message.getString(R.string.overweight), Toast.LENGTH_LONG).show();
            }
            else if (bmi>=40){
                Resources message = getResources();
                Toast.makeText(MainActivity.this, message.getString(R.string.Obese), Toast.LENGTH_LONG).show();
            }
        }
    };


}