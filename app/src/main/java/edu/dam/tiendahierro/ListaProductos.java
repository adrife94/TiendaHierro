package edu.dam.tiendahierro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaProductos extends AppCompatActivity {
    private RecyclerView recicler;
    private List<Productos> items = new ArrayList();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager iManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        fillProductos();


        recicler = findViewById(R.id.recicler);
        recicler.setHasFixedSize(true);
        recicler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        iManager = new LinearLayoutManager(this);
        recicler.setLayoutManager(iManager);

        adapter = new AdaptadorRecycler(items);
        recicler.setAdapter(adapter);
    }

    private void fillProductos() {
        items.add(new Productos("1","Cebolla", "1.5",R.drawable.cebolla, "Hortalizas","5", "Juan Gonzalez Blanco"));
        items.add(new Productos("2","Espinacas", "1.8",R.drawable.espinacas, "Verdura", "38", "Pedro Rodriguez"));
        items.add(new Productos("3","Higo", "2.5",R.drawable.higo, "Fruta", "20", "David Silva Rodriguez"));
        items.add(new Productos("4","Mango", "2.9",R.drawable.mango, "Fruta", "97", "Julian Cruz"));
        items.add(new Productos("6","Melon", "3.2",R.drawable.melon, "Fruta", "83", "Juan Magan"));
        items.add(new Productos("7","Papas", "4.2",R.drawable.papas, "Tipo:","567", "Kilian Martinez"));
       /* items.add(new Productos("8","Papaya", "2.5",R.drawable.papaya, "Fruta", 71));
        items.add(new Productos("9","Piña", "1.65",R.drawable.pina, "Fruta", 31));
        items.add(new Productos("10","Plátanos", "3.18",R.drawable.platanos, "Fruta", 74));
        items.add(new Productos("11","Quesadilla", "7",R.drawable.quesadilla, "Tipo: ",  99));
        items.add(new Productos("12","Tomate", "2.6",R.drawable.tomate, "Verdura", 56));
        items.add(new Productos("13","Zanahoria", "3.6",R.drawable.zanahoria, "Verdura", 98));
        items.add(new Productos("5","Leche", "1.7",R.drawable.leche, "Tipo: ", 25));
*/
    }
}
