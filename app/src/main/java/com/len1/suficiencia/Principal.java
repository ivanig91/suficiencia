package com.len1.suficiencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    Button btProducto;
    Button btLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        if(ListaProductos.listaProductos == null){
            ListaProductos.listaProductos = new ArrayList<>();
        }


        btProducto = findViewById(R.id.btNuevo);
        btLista = findViewById(R.id.btLista);

        btProducto.setOnClickListener(this);
        btLista.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if(v.getId() == btProducto.getId()){
            intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else{
            intent = new Intent(this,ListaProductos.class);
            startActivity(intent);
        }
    }
}
