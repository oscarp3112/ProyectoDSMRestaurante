package sv.edu.udb.proyectodsm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

import sv.edu.udb.proyectodsm.Data.historyAdapter;
import sv.edu.udb.proyectodsm.Data.historyModel;

public class Pedidos extends AppCompatActivity {

    RecyclerView rec;
    historyAdapter adapter;
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

        FirebaseRecyclerOptions<historyModel> options =
                new FirebaseRecyclerOptions.Builder<historyModel>()
                        .setQuery(database.getReference("Pedidos").child(usuario), historyModel.class)
                        .build();

        adapter = new historyAdapter(options);
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