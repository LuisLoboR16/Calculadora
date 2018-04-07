package com.example.luisanibal.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private EditText numero1,numero2;
    private Spinner opciones;
    private TextView resultado;
    private String opc[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        numero1 = findViewById(R.id.txtNumero1);
        numero2 = findViewById(R.id.txtNumero2);
        opciones = findViewById(R.id.cmbOpciones);
        resultado = findViewById(R.id.txtResultado);

        opc = this.getResources().getStringArray(R.array.operaciones);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,opc);
        opciones.setAdapter(adapter);
    }
}
