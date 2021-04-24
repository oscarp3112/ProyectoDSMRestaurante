package sv.edu.udb.proyectodsm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

import sv.edu.udb.proyectodsm.Data.adaptadorPedidos;
import sv.edu.udb.proyectodsm.Data.modeloPedidos;

public class Pedidos extends AppCompatActivity {

    RecyclerView rec;
    adaptadorPedidos adapter;
    String usuario;
    public static FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        usuario = "oscarp31";

        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);
        rec = findViewById(R.id.recyclerView);
        rec.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<modeloPedidos> options =
                new FirebaseRecyclerOptions.Builder<modeloPedidos>()
                        .setQuery(database.getReference("Pedidos").child(usuario), modeloPedidos.class)
                        .build();

        adapter = new adaptadorPedidos(options);
        rec.setAdapter(adapter);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}