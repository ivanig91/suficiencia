package com.len1.suficiencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btCancelar;
    Button btRegistrar;
    EditText nombre;
    EditText cantidad;
    EditText precio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre = findViewById(R.id.etNombre);
        cantidad = findViewById(R.id.etCantidad);
        precio = findViewById(R.id.etPrecio);
        btCancelar = findViewById(R.id.btCancelar);
        btRegistrar = findViewById(R.id.btRegistrar);

        btCancelar.setOnClickListener(this);
        btRegistrar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btCancelar.getId()){
            nombre.setText(" ");
            cantidad.setText(" ");
            precio.setText(" ");
        }else{
            String nombStr = nombre.getText().toString();
            String cantStr = cantidad.getText().toString();
            String precStr = precio.getText().toString();
            if(nombStr.isEmpty() || cantStr.isEmpty() || precStr.isEmpty()){
                Toast.makeText(this,R.string.error_input,Toast.LENGTH_LONG).show();

            }else{
                Producto producto = new Producto(nombStr,cantStr,precStr);

                ListaProductos.listaProductos.add(producto);

                Toast.makeText(this,R.string.producto_registrado,Toast.LENGTH_LONG).show();
                nombre.setText(" ");
                cantidad.setText(" ");
                precio.setText(" ");

            }
        }
    }
}
