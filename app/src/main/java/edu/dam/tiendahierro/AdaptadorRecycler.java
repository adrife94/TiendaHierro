package edu.dam.tiendahierro;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ProductoViewHolder> implements View.OnClickListener {
    private List<Productos> items;
    private Context context;

    @Override
    public void onClick(View v) {

    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        public CardView personCardView;
        public ImageView imgFoto;
        public Button btndetalle;
        private TextView titulo, tipo, precio, cantidad, vendedor;




        public ProductoViewHolder(View v) {
            super(v);
           personCardView = v.findViewById(R.id.person_card);
            imgFoto = v.findViewById(R.id.imagen);
            titulo = v.findViewById(R.id.nombre);
            tipo = v.findViewById(R.id.tipo);
            cantidad = v.findViewById(R.id.cantidad);
            btndetalle = v.findViewById(R.id.btndetalle);
            precio = v.findViewById(R.id.precio);
            vendedor = v.findViewById(R.id.vendedor);

        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public AdaptadorRecycler(List<Productos> items) {
        this.items = items;
    }

    public List<Productos> getItems(){
        return this.items;
    }

    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_productos, viewGroup, false);
        return new ProductoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ProductoViewHolder viewHolder, final int i) {
        final Context contexto = null;
        viewHolder.imgFoto.setImageResource(items.get(i).getImageView());
        viewHolder.titulo.setText(items.get(i).getProducto());
        viewHolder.tipo.setText("Tipo:  " +items.get(i).getTipo());
        viewHolder.cantidad.setText("Cantidad: " + items.get(i).getCantidad());
        viewHolder.precio.setText(items.get(i).getPrecio() + " Euros");
        viewHolder.vendedor.setText("Vendedor: " + items.get(i).getVendedor());

        viewHolder.vendedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VendedorActivity.class);
                Bundle datos = new Bundle();
                datos.putString("titulo", items.get(i).getProducto());
                datos.putString("precio", items.get(i).getPrecio());
                datos.putString("cantidad", items.get(i).getCantidad());
                datos.putString("tipo", items.get(i).getTipo());
                datos.putInt("imagen", items.get(i).getImageView());
                intent.putExtras(datos);

                v.getContext().startActivity(intent);
            }

        });



        viewHolder.btndetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductoActivity.class);
                Bundle datos = new Bundle();
                datos.putString("titulo", items.get(i).getProducto());
                datos.putString("precio", items.get(i).getPrecio());
                datos.putString("cantidad", items.get(i).getCantidad());
                datos.putString("tipo", items.get(i).getTipo());
                datos.putInt("imagen", items.get(i).getImageView());
                datos.putString("vendedor", items.get(i).getVendedor());
                intent.putExtras(datos);

                v.getContext().startActivity(intent);
            }
        });



    }
}
