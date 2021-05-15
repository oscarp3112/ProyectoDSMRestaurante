package sv.edu.udb.proyectodsm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import sv.edu.udb.proyectodsm.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    public static double total;
    public static String[] productos = new String[10];
    public String orden = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        /*
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */
    }

    private void LogOff() {
        AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
        ad.setMessage("¿Desea cerrar su sesión?").setTitle("Confirmación");

        ad.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                //Cerrando la sesión
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        ad.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id) { }
        });
        ad.show();
    }

    private void OpenCart()
    {
        //Procesando los datos obtenidos
        orden = "";
        for(int i = 0; i < productos.length; i++)
        {
            //Tomando los productos que se compraron
            if(productos[i] != null)
            {
                if(productos[i].trim() != "")
                {
                    orden = orden + productos[i].trim() + ", ";
                }
            }
            //Quitando la última coma
            if (i == productos.length - 1) orden = orden.substring(0, orden.length() - 2);
        }
        Log.d("a", orden);

        //Abriendo el carrito
        Intent intent = new Intent(MainActivity.this, CartActivity.class);
        intent.putExtra("total", String.valueOf(total));
        intent.putExtra("orden", orden);
        startActivity(intent);
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
                if(total > 0) OpenCart();
                else Toast.makeText(getApplicationContext(), "Su carrito está vacío.", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}