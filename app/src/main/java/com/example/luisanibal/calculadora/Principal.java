package com.example.luisanibal.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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


    public void Calcular(View v){
        double n1,n2,res=0;
        int opcion;

        if(Validar()){
            n1 = Double.parseDouble(numero1.getText().toString());
            n2 = Double.parseDouble(numero2.getText().toString());
            opcion = opciones.getSelectedItemPosition();

            switch(opcion){
                case 0:
                    res = Metodos.Sumar(n1,n2);
                    break;
                case 1:
                    res = Metodos.Restar(n1,n2);
                    break;
                case 2:
                    res = Metodos.Multiplicar(n1,n2);
                    break;
                case 3:
                    res = Metodos.Dividir(n1,n2);
                    break;
            }
            resultado.setText(String.format("%.2f",res));
        }
    }

    public boolean Validar(){
        int opcion = opciones.getSelectedItemPosition();
        if(numero1.getText().toString().isEmpty()){
            numero1.requestFocus();
            numero1.setError(this.getResources().getString(R.string.error_numero1));
            return false;
        }
        if(numero2.getText().toString().isEmpty()){
            numero2.requestFocus();
            numero2.setError(this.getResources().getString(R.string.error_numero2));
            return false;
        }
        if(opcion == 3 && Double.parseDouble(numero2.getText().toString())==0){
            numero2.requestFocus();
            numero2.setError(this.getResources().getString(R.string.error_numero3));
            return false;
        }
        return true;
    }
    public void Limpiar(View v){
        numero1.setText("");
        numero2.setText("");
        resultado.setText("");
        opciones.setSelection(0);
        numero1.requestFocus();
    }
}
