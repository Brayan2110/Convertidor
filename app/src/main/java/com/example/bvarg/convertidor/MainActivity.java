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
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import devazt.devazt.networking.HttpClient;
import devazt.devazt.networking.OnHttpRequestComplete;
import devazt.devazt.networking.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RadioButton Colon;
    RadioButton Dolar;
    Button Convertir;
    TextView Total;
    EditText Cantidad;
    Boolean Moneda = true;
    float Cambio = 0;

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

        HttpClient cliente = new HttpClient(new OnHttpRequestComplete() {
            @Override
            public void onComplete(Response status) {
                if(status.isSuccess()){
                    Gson gson = new GsonBuilder().create();
                    try{
                        JSONObject jsono = new JSONObject(status.getResult());
                        String res = jsono.getString("rates");
                        Resultado r = gson.fromJson(res, Resultado.class);
                        Cambio = Float.parseFloat(r.getCRC());
                        //Total.setText(String.valueOf(Cambio));
                        //JSONArray jsonarray = jsono.getJSONArray("license");
//                        ArrayList<Resultado> lista = new ArrayList<Resultado>();
//                        for(int i=0; i<jsonarray.length(); i++){
//                            //String res = jsonarray.getString(i);
//                            System.out.println(res);
//                            Resultado r = gson.fromJson(res, Resultado.class);
//                            lista.add(r);
//                            System.err.println(r.getCRC());
//                            Total.setText(r.getCRC());
//                        }
                    }
                    catch (Exception e){

                    }
                    //Toast.makeText(MainActivity.this, status.getResult(), Toast.LENGTH_SHORT).show();
                }
                else{

                }

            }
        });
        cliente.excecute("https://openexchangerates.org/api/latest.json?app_id=ddb0898d8d1148a495691ba9ad1d4c9f");

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
