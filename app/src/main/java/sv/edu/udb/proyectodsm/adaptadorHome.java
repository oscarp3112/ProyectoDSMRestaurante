package sv.edu.udb.proyectodsm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class adaptadorHome extends FirebaseRecyclerAdapter<modeloHome,adaptadorHome.myviewholder> {

    public adaptadorHome(@NonNull FirebaseRecyclerOptions<modeloHome> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull modeloHome model) {

        holder.nombre.setText(model.getNombre());
        String descripcion1 = model.getDesc() + "\n\n Precio: $"+String.valueOf(model.getPrecio());
        holder.desc.setText(descripcion1);
        Glide.with(holder.img.getContext()).load(model.getImgurl()).into(holder.img);

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
        TextView nombre, desc;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.image1);
            nombre=(TextView)itemView.findViewById(R.id.pedido1);
            desc=(TextView)itemView.findViewById(R.id.descripcion1);

        }
    }
}
