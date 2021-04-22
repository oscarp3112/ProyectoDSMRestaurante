package sv.edu.udb.proyectodsm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HomeActivity extends AppCompatActivity {

    RecyclerView rec;
    adaptadorHome adapter;
    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference refPlatos = database.getReference("Platos");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        rec = findViewById(R.id.recyclerView);
        rec.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<modeloHome> options =
                new FirebaseRecyclerOptions.Builder<modeloHome>()
                .setQuery(refPlatos, modeloHome.class)
                .build();

        adapter = new adaptadorHome(options);
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