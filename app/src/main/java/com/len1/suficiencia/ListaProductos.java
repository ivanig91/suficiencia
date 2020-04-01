package com.len1.suficiencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaProductos extends AppCompatActivity {
    public static ArrayList<Producto> listaProductos;
    public static AdapterProducto adapter;
    ListView lali;
    TextView totales;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        totales = findViewById(R.id.tvTotales);

        adapter = new AdapterProducto(this,listaProductos);
        lali = findViewById(R.id.lali);
        lali.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        registerForContextMenu(lali);





        double cantidad = 0;
        double precio = 0;
        for(Producto elem : listaProductos){
            cantidad = cantidad + Double.parseDouble(elem.getCantidad());
            precio = precio + Double.parseDouble(elem.getPrecio());
        }

        totales.setText(Constantes.TOTAL_PRODUCTOS+String.valueOf(cantidad)+Constantes.TOTAL_EUROS+String.valueOf(precio)+" €");
    }

}
