package edu.dam.tiendahierro;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductoActivity extends AppCompatActivity {
    private double precio, cantidad;
    private String nombre, tipo, vendedor;
    private int imagen, cantidadnumerica;
    private ImageView imageView;
    private TextView titulotxv, preciotxv, cantidadtxv, tipotxv, vendedortxv;
    private Button btnaumentar, btndisminuir, btncomprar;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        Bundle datos = this.getIntent().getExtras();
        nombre = datos.getString("titulo");
        tipo = datos.getString("tipo");
        precio = Double.parseDouble(datos.getString("cantidad"));
        imagen = datos.getInt("imagen");
        precio = Double.parseDouble(datos.getString("precio"));
        vendedor = datos.getString("vendedor");

        titulotxv = findViewById(R.id.titulo);
        titulotxv.setText(nombre);

        vendedortxv = findViewById(R.id.txvvendedor);
        vendedortxv.setText("Vendedor: " +vendedor);

        imageView = findViewById(R.id.imagenproducto);
        imageView.setImageResource(imagen);

        titulotxv =findViewById(R.id.titulo);

        preciotxv = findViewById(R.id.precio);
        preciotxv.setText(String.valueOf("Precio: " + precio));

        cantidadtxv = findViewById(R.id.cantidad);
        cantidadtxv.setText(String.valueOf(1));

        btnaumentar = findViewById(R.id.btnaumentar);
        btnaumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int cantidad = Integer.parseInt((String) cantidadtxv.getText());
               cantidadnumerica = cantidad + 1;
               cantidadtxv.setText(String.valueOf(cantidadnumerica));

               double precios = Double.parseDouble(String.valueOf(precio));
               double precionumerico = precios * cantidadnumerica;
               preciotxv.setText("Precio: " + String.valueOf(precionumerico));
            }
        });


        btndisminuir = findViewById(R.id.btndisminuir);
        btndisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidad = Integer.parseInt((String) cantidadtxv.getText());
                int cantidadnumerica = cantidad - 1;
                cantidadtxv.setText(String.valueOf(cantidadnumerica));

                double precios = Double.parseDouble(String.valueOf(precio));
                double precionumerico = precios * cantidadnumerica;
                preciotxv.setText("Precio: " + String.valueOf( precionumerico));
            }
        });

        btncomprar = findViewById(R.id.btncomprar);
        btncomprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final AlertDialog.Builder dialogo = new AlertDialog.Builder(v.getContext());
                dialogo.setTitle("Importante");
                dialogo.setMessage("¿Estás seguro que deseas comprar " + cantidadnumerica + " kilos de " + nombre + " por un importe de " + preciotxv.getText() + " euros" + "?");
                dialogo.setCancelable(false);
                dialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {

                        Toast.makeText(v.getContext(), "Compra finalizada correctamente", Toast.LENGTH_LONG).show();

                    }
                });
                dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        dialogo1.dismiss();
                    }
                });

                dialogo.show();

            }
        });

        /*tipotxv = findViewById(R.id.tipo);
        tipotxv.setText(tipo);*/
    }
}
