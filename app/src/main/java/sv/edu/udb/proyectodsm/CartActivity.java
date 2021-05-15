package sv.edu.udb.proyectodsm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import sv.edu.udb.proyectodsm.Data.historyModel;

public class CartActivity extends AppCompatActivity {

    String orden = "", total = "";
    TextView txtOrden, txtTotal;
    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference refOrden = database.getReference("Pedidos").child("oscarp31");
    Date currentTime = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent data = getIntent();
        orden = data.getStringExtra("orden");
        total = data.getStringExtra("total");
        //Formateando el total
        if(total.substring(total.lastIndexOf(".") + 1).length() < 2)
        {
            //Se añade un 0 para uniformidad
            total = total + "0";
        }
        else if(total.substring(total.lastIndexOf(".") + 1).length() > 2)
        {
            String[] parts = total.split("\\.");
            total = parts[0] + "." + parts[1].substring(0,2);
        }

        txtOrden=findViewById(R.id.txtOrden);
        txtOrden.setText("Su orden incluye: " + orden);

        txtTotal=findViewById(R.id.txtTotal);
        txtTotal.setText("Total: $" + total);

        //Asignando métodos a los botones
        findViewById(R.id.btnConfirmar).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {   ConfirmPurchase();  }
        });

        findViewById(R.id.btnVolver).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
    }

    public void ConfirmPurchase()
    {
        AlertDialog.Builder ad = new AlertDialog.Builder(CartActivity.this);
        ad.setMessage("¿Está seguro de registrar esta orden?")
                .setTitle("Confirmación");

        ad.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-6"));
                String fecha = dateFormat.format(currentTime);
                historyModel pedido = new historyModel(orden, fecha, Double.valueOf(total));
                refOrden.push().setValue(pedido);
                Toast.makeText(CartActivity.this,"¡Orden registrada!",Toast.LENGTH_SHORT).show();

                finish();
            }
        });
        ad.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(CartActivity.this,"Orden no registrada.",Toast.LENGTH_SHORT).show();
            }
        });

        ad.show();
    }
}