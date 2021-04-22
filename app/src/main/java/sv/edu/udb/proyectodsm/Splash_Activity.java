package sv.edu.udb.proyectodsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Código para que la splashscreen se muestre por poco tiempo
        Thread thread = new Thread(){
            public void run(){
                try {

                    sleep(1575);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent newIntent = new Intent(Splash_Activity.this, Login_Activity.class);
                    startActivity(newIntent);
                    finish();
                }
            }

        };
        thread.start();
    }
}