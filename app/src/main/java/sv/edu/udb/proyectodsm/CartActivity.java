package sv.edu.udb.proyectodsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {

    TextView txtOrden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent data = getIntent();
        String orden = data.getStringExtra("orden");

        txtOrden=findViewById(R.id.txtOrden);
        txtOrden.setText(orden);
    }
}