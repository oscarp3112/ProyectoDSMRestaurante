package sv.edu.udb.proyectodsm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import sv.edu.udb.proyectodsm.Data.adaptadorHome;
import sv.edu.udb.proyectodsm.Data.modeloHome;


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

    private void LogOff() {
        AlertDialog.Builder ad = new AlertDialog.Builder(HomeActivity.this);
        ad.setMessage("¿Desea cerrar su sesión?").setTitle("Confirmación");

        ad.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                //Cerrando la sesión
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        ad.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id) { }
        });
        ad.show();
    }

    //Inicializando el menú superior
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.optionLogOff:
                LogOff();
                return true;
            case R.id.optionCart:
                Toast.makeText(getApplicationContext(), "Su carrito está vacío.", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}