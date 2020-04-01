package com.len1.suficiencia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaProductos extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    public static ArrayList<Producto> listaProductos;
    private ArrayList<Producto> productosVisibles;
    public static AdapterProducto adapter;
    ListView lali;
    TextView totales;
    Switch flip;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menucontextual,menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.comprados,menu);
        flip = (Switch) menu.findItem(R.id.app_bar_switch).getActionView().findViewById(R.id.swComprados);
        flip.setOnCheckedChangeListener(this);
        return true;
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final int itSelec = info.position;

        if(item.getItemId()==R.id.menu_eliminar){
            listaProductos.remove(itSelec);
            adapter.notifyDataSetChanged();
            actualizarTexto();
            return  true;
        }else{
            if(item.getItemId() == R.id.menu_comprado){
                listaProductos.get(itSelec).setComprado(true);
            }
        }
        return super.onContextItemSelected(item);

    }
    private void rellenarProductos(){
        for(Producto elem : listaProductos){
            productosVisibles.add(elem);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        totales = findViewById(R.id.tvTotales);
        productosVisibles = new ArrayList<>();
        adapter = new AdapterProducto(this,productosVisibles);
        lali = findViewById(R.id.lali);
        lali.setAdapter(adapter);
        if(productosVisibles.size()==0){
            rellenarProductos();
        }

        adapter.notifyDataSetChanged();
        registerForContextMenu(lali);
        actualizarTexto();
    }
    private void actualizarTexto(){
        double cantidad = 0;
        double precio = 0;
        for(Producto elem : productosVisibles){
            cantidad = cantidad + Double.parseDouble(elem.getCantidad());
            precio = precio + Double.parseDouble(elem.getPrecio());
        }

        totales.setText(Constantes.TOTAL_PRODUCTOS+String.valueOf(cantidad)+Constantes.TOTAL_EUROS+String.valueOf(precio)+Constantes.SIMBOLO_EURO);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        productosVisibles.clear();
        if(buttonView.isChecked()){
            for(Producto elem:listaProductos){
                if(elem.isComprado()){
                    productosVisibles.add(elem);
                }
            }
        }else{
            for(Producto elem: listaProductos){
                productosVisibles.add(elem);
            }
        }
        adapter.notifyDataSetChanged();
        actualizarTexto();
    }
}
