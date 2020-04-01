package com.len1.suficiencia;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterProducto extends BaseAdapter {
    private Context context;
    private ArrayList<Producto> listaProductos;
    private LayoutInflater inflater;

    public AdapterProducto(Context context, ArrayList<Producto> listaProductos) {
        this.context = context;
        this.listaProductos = listaProductos;
        inflater = LayoutInflater.from(context);
    }
    static class ViewHolder{
        TextView nombre;
        TextView cantidad;
        TextView precio;
    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaProductos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if(convertView==null){
            convertView = inflater.inflate(R.layout.adapterproducto, null);
            holder = new ViewHolder();
            holder.nombre = convertView.findViewById(R.id.vhNombre);
            holder.cantidad = convertView.findViewById(R.id.vhCantidad);
            holder.precio = convertView.findViewById(R.id.vhPrecio);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Producto producto = listaProductos.get(position);
        holder.nombre.setText(Constantes.NOMBRE+producto.getNombre());
        holder.cantidad.setText(Constantes.CANTIDAD+producto.getCantidad());
        holder.precio.setText(Constantes.PRECIO+producto.getPrecio()+Constantes.SIMBOLO_EURO);

        return convertView;
    }
}
