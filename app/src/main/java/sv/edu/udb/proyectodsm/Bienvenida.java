package sv.edu.udb.proyectodsm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Bienvenida extends AppCompatActivity {
    public static DatabaseReference refplatos;
    TextView Nombre[];
    TextView Descripcion[];
    ImageView Imagen[];
    ImageButton Agregar [];
    ImageButton Compartir [];
    Button Mas [];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Nombre = new TextView[10];
        Descripcion = new TextView[10];
        Imagen = new ImageView[10];
        Agregar = new ImageButton[10];
        Compartir = new ImageButton[10];
        Mas = new Button[10];
//Mapeo de nombres
        Nombre[0]=(TextView)findViewById(R.id.nombre1);
        Nombre[1]=(TextView)findViewById(R.id.nombre2);
        Nombre[2]=(TextView)findViewById(R.id.nombre3);
        Nombre[3]=(TextView)findViewById(R.id.nombre4);
        Nombre[4]=(TextView)findViewById(R.id.nombre5);
        Nombre[5]=(TextView)findViewById(R.id.nombre6);
        Nombre[6]=(TextView)findViewById(R.id.nombre7);
        Nombre[7]=(TextView)findViewById(R.id.nombre8);
        Nombre[8]=(TextView)findViewById(R.id.nombre9);
        Nombre[9]=(TextView)findViewById(R.id.nombre10);
//Mapeo de descripciones
        Descripcion[0]=(TextView)findViewById(R.id.descripcion1);
        Descripcion[1]=(TextView)findViewById(R.id.descripcion2);
        Descripcion[2]=(TextView)findViewById(R.id.descripcion3);
        Descripcion[3]=(TextView)findViewById(R.id.descripcion4);
        Descripcion[4]=(TextView)findViewById(R.id.descripcion5);
        Descripcion[5]=(TextView)findViewById(R.id.descripcion6);
        Descripcion[6]=(TextView)findViewById(R.id.descripcion7);
        Descripcion[7]=(TextView)findViewById(R.id.descripcion8);
        Descripcion[8]=(TextView)findViewById(R.id.descripcion9);
        Descripcion[9]=(TextView)findViewById(R.id.descripcion10);
//Mapeo de imágenes
        Imagen[0]=(ImageView)findViewById(R.id.image1);
        Imagen[1]=(ImageView)findViewById(R.id.image2);
        Imagen[2]=(ImageView)findViewById(R.id.image3);
        Imagen[3]=(ImageView)findViewById(R.id.image4);
        Imagen[4]=(ImageView)findViewById(R.id.image5);
        Imagen[5]=(ImageView)findViewById(R.id.image6);
        Imagen[6]=(ImageView)findViewById(R.id.image7);
        Imagen[7]=(ImageView)findViewById(R.id.image8);
        Imagen[8]=(ImageView)findViewById(R.id.image9);
        Imagen[9]=(ImageView)findViewById(R.id.image10);
        //Mapeo de botones
        Agregar[0]=(ImageButton)findViewById(R.id.agregar1);
        Agregar[1]=(ImageButton)findViewById(R.id.agregar2);
        Agregar[2]=(ImageButton)findViewById(R.id.agregar3);
        Agregar[3]=(ImageButton)findViewById(R.id.agregar4);
        Agregar[4]=(ImageButton)findViewById(R.id.agregar5);
        Agregar[5]=(ImageButton)findViewById(R.id.agregar6);
        Agregar[6]=(ImageButton)findViewById(R.id.agregar7);
        Agregar[7]=(ImageButton)findViewById(R.id.agregar8);
        Agregar[8]=(ImageButton)findViewById(R.id.agregar9);
        Agregar[9]=(ImageButton)findViewById(R.id.agregar10);

        Compartir[0]=(ImageButton)findViewById(R.id.share1);
        Compartir[1]=(ImageButton)findViewById(R.id.share2);
        Compartir[2]=(ImageButton)findViewById(R.id.share3);
        Compartir[3]=(ImageButton)findViewById(R.id.share4);
        Compartir[4]=(ImageButton)findViewById(R.id.share5);
        Compartir[5]=(ImageButton)findViewById(R.id.share6);
        Compartir[6]=(ImageButton)findViewById(R.id.share7);
        Compartir[7]=(ImageButton)findViewById(R.id.share8);
        Compartir[8]=(ImageButton)findViewById(R.id.share9);
        Compartir[9]=(ImageButton)findViewById(R.id.share10);

        Mas[0]=(Button)findViewById(R.id.mas1);
        Mas[1]=(Button)findViewById(R.id.mas2);
        Mas[2]=(Button)findViewById(R.id.mas3);
        Mas[3]=(Button)findViewById(R.id.mas4);
        Mas[4]=(Button)findViewById(R.id.mas5);
        Mas[5]=(Button)findViewById(R.id.mas6);
        Mas[6]=(Button)findViewById(R.id.mas7);
        Mas[7]=(Button)findViewById(R.id.mas8);
        Mas[8]=(Button)findViewById(R.id.mas9);
        Mas[9]=(Button)findViewById(R.id.mas10);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);



    }

}