package sv.edu.udb.proyectodsm.Data;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import sv.edu.udb.proyectodsm.MainActivity;
import sv.edu.udb.proyectodsm.R;

public class platoAdapter extends FirebaseRecyclerAdapter<platoModel, platoAdapter.myviewholder> {

    public int[] prodCounter = new int[10];
    public String[] prodName = new String[10];
    public double[] prices = new double[10];
    public String[] names = new String[10];
    public int counter = 0;
    String price = "0";
    public platoAdapter(@NonNull FirebaseRecyclerOptions<platoModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull platoModel model) {

        //Seteando los campos de cada producto
        //Nombre
        holder.nombre.setText(model.getNombre());
        if(counter > 9) counter = 9;
        names[counter] = model.getNombre();
        //Descripcion y precio
        String descripcion1 = model.getDesc() + "\n\n Precio: $" + String.valueOf(model.getPrecio());
        holder.desc.setText(descripcion1);
        prices[counter] = model.getPrecio();
        counter = counter + 1;
        //Imagen
        Glide.with(holder.img.getContext()).load(model.getImgurl()).into(holder.img);
        holder.cant.setText("");
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plato_row,parent, false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView nombre, desc, cant;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.imageFood);
            nombre=(TextView)itemView.findViewById(R.id.txtFoodName);
            desc=(TextView)itemView.findViewById(R.id.txtFoodDesc);
            cant=(TextView)itemView.findViewById(R.id.txtCantidad);

            //Asignando métodos a los botones
            itemView.findViewById(R.id.btnAgregar).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.total = MainActivity.total + prices[getAdapterPosition()];
                    prodCounter[getAdapterPosition()] = prodCounter[getAdapterPosition()] + 1;
                    prodName[getAdapterPosition()] = names[getAdapterPosition()] + " (" + prodCounter[getAdapterPosition()] + ")";
                    MainActivity.productos = prodName;
                    cant.setText("x" + String.valueOf(prodCounter[getAdapterPosition()]));

                    Log.d("a", prodName[getAdapterPosition()]);
                    Log.d("a", String.valueOf(prodCounter[getAdapterPosition()]));
                    Log.d("a", String.valueOf(MainActivity.total));
                }
            });

            itemView.findViewById(R.id.btnQuitar).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(prodCounter[getAdapterPosition()] > 0)
                    {
                        MainActivity.total = MainActivity.total - prices[getAdapterPosition()];
                        prodCounter[getAdapterPosition()] = prodCounter[getAdapterPosition()] - 1;
                        prodName[getAdapterPosition()] = names[getAdapterPosition()] + " (" + prodCounter[getAdapterPosition()] + ")";
                        cant.setText("x" + String.valueOf(prodCounter[getAdapterPosition()]));

                        if(prodCounter[getAdapterPosition()] == 0)
                        {
                            prodName[getAdapterPosition()] = "";
                            cant.setText("");
                        }
                    }
                    else
                    {
                        prodName[getAdapterPosition()] = "";
                        cant.setText("");
                    }
                    MainActivity.productos = prodName;

                    Log.d("a", prodName[getAdapterPosition()]);
                    Log.d("a", String.valueOf(prodCounter[getAdapterPosition()]));
                    Log.d("a", String.valueOf(MainActivity.total));
                }
            });
        }
    }
}
