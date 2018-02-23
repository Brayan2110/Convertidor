package com.example.bvarg.convertidor;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RadioButton Colon;
    RadioButton Dolar;
    Button Convertir;
    TextView Total;
    EditText Cantidad;
    Boolean Moneda = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Colon = (RadioButton)findViewById(R.id.radioButton_Colones);
        Dolar = (RadioButton)findViewById(R.id.radioButton_Dolares);
        Convertir = (Button) findViewById(R.id.button_Convertir);
        Total = (TextView) findViewById(R.id.textView_Total);
        Cantidad = (EditText) findViewById(R.id.editText_Cantidad);

        Colon.setOnClickListener(this);
        Dolar.setOnClickListener(this);
        Dolar.setChecked(true);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radioButton_Dolares:
                Moneda = true;
                break;
            case R.id.radioButton_Colones:
                Moneda = false;
                break;
        }
    }
}
