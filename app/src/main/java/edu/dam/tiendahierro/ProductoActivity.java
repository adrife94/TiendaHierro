package edu.dam.tiendahierro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductoActivity extends AppCompatActivity {
    private double precio, cantidad;
    private String nombre, tipo;
    private int imagen;
    private ImageView imageView;
    private TextView titulotxv, preciotxv, cantidadtxv, tipotxv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        Bundle datos = this.getIntent().getExtras();
        nombre = datos.getString("titulo");
        tipo = datos.getString("tipo");
        precio = Double.parseDouble(datos.getString("cantidad"));
        imagen = Integer.parseInt(datos.getString("imagen"));
        precio = Double.parseDouble(datos.getString("precio"));

        imageView = findViewById(R.id.imagenproducto);
        imageView.setImageResource(imagen);

        titulotxv =findViewById(R.id.titulo);
        preciotxv = findViewById(R.id.precio);
        cantidadtxv = findViewById(R.id.cantidad);
        tipotxv = findViewById(R.id.tipo);
    }
}
