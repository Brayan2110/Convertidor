package com.example.bvarg.convertidor;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
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

public class MainActivity extends AppCompatActivity{

    Button Convertir;
    TextView Total;
    TextView Total2;
    EditText Cantidad;
    Boolean Moneda = true;
    Spinner spinner;
    Spinner spinner2;
    Resultado r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Convertir = (Button) findViewById(R.id.button_Convertir);
        Total = (TextView) findViewById(R.id.textView_Total);
        Total2 = (TextView) findViewById(R.id.textView_Total2);
        Cantidad = (EditText) findViewById(R.id.editText_Cantidad);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        HttpClient cliente = new HttpClient(new OnHttpRequestComplete() {
            @Override
            public void onComplete(Response status) {
                if(status.isSuccess()){
                    Gson gson = new GsonBuilder().create();
                    try{
                        JSONObject jsono = new JSONObject(status.getResult());
                        String res = jsono.getString("rates");
                        r = gson.fromJson(res, Resultado.class);
                        //Cambio = Float.parseFloat(r.getCRC());
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

        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( this, R.array.Moneda, android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinner_adapter);

        ArrayAdapter spinner_adapter2 = ArrayAdapter.createFromResource( this, R.array.Moneda , android.R.layout.simple_spinner_item);
        spinner_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(spinner_adapter2);
    }

    public void convertir(View v) {
        int numero1 = spinner.getSelectedItemPosition();
        int numero2 = spinner2.getSelectedItemPosition();
        double numero;
        if(!Cantidad.getText().toString().isEmpty()){
            numero = Double.parseDouble(Cantidad.getText().toString());
        }
        else{
            numero = 0;
        }
        Total.setText(String.valueOf(numero) + " =");
        Cantidad.setText("");
        double conversor1 = 0;
        double conversor2 = 0;

        switch (numero1) {
            case 0:
                conversor1 = Double.parseDouble(r.get0());
                break;
            case 1:
                conversor1 = Double.parseDouble(r.get1());
                break;
            case 2:
                conversor1 = Double.parseDouble(r.get2());
                break;
            case 3:
                conversor1 = Double.parseDouble(r.get3());
                break;
            case 4:
                conversor1 = Double.parseDouble(r.get4());
                break;
            case 5:
                conversor1 = Double.parseDouble(r.get5());
                break;
            case 6:
                conversor1 = Double.parseDouble(r.get6());
                break;
            case 7:
                conversor1 = Double.parseDouble(r.get7());
                break;
            case 8:
                conversor1 = Double.parseDouble(r.get8());
                break;
            case 9:
                conversor1 = Double.parseDouble(r.get9());
                break;
            case 10:
                conversor1 = Double.parseDouble(r.get10());
                break;
            case 11:
                conversor1 = Double.parseDouble(r.get11());
                break;
            case 12:
                conversor1 = Double.parseDouble(r.get12());
                break;
            case 13:
                conversor1 = Double.parseDouble(r.get13());
                break;
            case 14:
                conversor1 = Double.parseDouble(r.get14());
                break;
            case 15:
                conversor1 = Double.parseDouble(r.get15());
                break;
            case 16:
                conversor1 = Double.parseDouble(r.get16());
                break;
            case 17:
                conversor1 = Double.parseDouble(r.get17());
                break;
            case 18:
                conversor1 = Double.parseDouble(r.get18());
                break;
            case 19:
                conversor1 = Double.parseDouble(r.get19());
                break;
            case 20:
                conversor1 = Double.parseDouble(r.get20());
                break;
            case 21:
                conversor1 = Double.parseDouble(r.get21());
                break;
            case 22:
                conversor1 = Double.parseDouble(r.get22());
                break;
            case 23:
                conversor1 = Double.parseDouble(r.get23());
                break;
            case 24:
                conversor1 = Double.parseDouble(r.get24());
                break;
            case 25:
                conversor1 = Double.parseDouble(r.get25());
                break;
            case 26:
                conversor1 = Double.parseDouble(r.get26());
                break;
            case 27:
                conversor1 = Double.parseDouble(r.get27());
                break;
            case 28:
                conversor1 = Double.parseDouble(r.get28());
                break;
            case 29:
                conversor1 = Double.parseDouble(r.get29());
                break;
            case 30:
                conversor1 = Double.parseDouble(r.get30());
                break;
            case 31:
                conversor1 = Double.parseDouble(r.get31());
                break;
            case 32:
                conversor1 = Double.parseDouble(r.get32());
                break;
            case 33:
                conversor1 = Double.parseDouble(r.get33());
                break;
            case 34:
                conversor1 = Double.parseDouble(r.get34());
                break;
            case 35:
                conversor1 = Double.parseDouble(r.get35());
                break;
        }
        switch (numero2) {
            case 0:
                conversor2 = Double.parseDouble(r.get0());
                break;
            case 1:
                conversor2 = Double.parseDouble(r.get1());
                break;
            case 2:
                conversor2 = Double.parseDouble(r.get2());
                break;
            case 3:
                conversor2 = Double.parseDouble(r.get3());
                break;
            case 4:
                conversor2 = Double.parseDouble(r.get4());
                break;
            case 5:
                conversor2 = Double.parseDouble(r.get5());
                break;
            case 6:
                conversor2 = Double.parseDouble(r.get6());
                break;
            case 7:
                conversor2 = Double.parseDouble(r.get7());
                break;
            case 8:
                conversor2 = Double.parseDouble(r.get8());
                break;
            case 9:
                conversor2 = Double.parseDouble(r.get9());
                break;
            case 10:
                conversor2 = Double.parseDouble(r.get10());
                break;
            case 11:
                conversor2 = Double.parseDouble(r.get11());
                break;
            case 12:
                conversor2 = Double.parseDouble(r.get12());
                break;
            case 13:
                conversor2 = Double.parseDouble(r.get13());
                break;
            case 14:
                conversor2 = Double.parseDouble(r.get14());
                break;
            case 15:
                conversor2 = Double.parseDouble(r.get15());
                break;
            case 16:
                conversor2 = Double.parseDouble(r.get16());
                break;
            case 17:
                conversor2 = Double.parseDouble(r.get17());
                break;
            case 18:
                conversor2 = Double.parseDouble(r.get18());
                break;
            case 19:
                conversor2 = Double.parseDouble(r.get19());
                break;
            case 20:
                conversor2 = Double.parseDouble(r.get20());
                break;
            case 21:
                conversor2 = Double.parseDouble(r.get21());
                break;
            case 22:
                conversor2 = Double.parseDouble(r.get22());
                break;
            case 23:
                conversor2 = Double.parseDouble(r.get23());
                break;
            case 24:
                conversor2 = Double.parseDouble(r.get24());
                break;
            case 25:
                conversor2 = Double.parseDouble(r.get25());
                break;
            case 26:
                conversor2 = Double.parseDouble(r.get26());
                break;
            case 27:
                conversor2 = Double.parseDouble(r.get27());
                break;
            case 28:
                conversor2 = Double.parseDouble(r.get28());
                break;
            case 29:
                conversor2 = Double.parseDouble(r.get29());
                break;
            case 30:
                conversor2 = Double.parseDouble(r.get30());
                break;
            case 31:
                conversor2 = Double.parseDouble(r.get31());
                break;
            case 32:
                conversor2 = Double.parseDouble(r.get32());
                break;
            case 33:
                conversor2 = Double.parseDouble(r.get33());
                break;
            case 34:
                conversor2 = Double.parseDouble(r.get34());
                break;
            case 35:
                conversor2 = Double.parseDouble(r.get35());
                break;
        }
        numero = (numero/conversor1)*conversor2;
        Total2.setText(String.valueOf(numero));
    }
}
