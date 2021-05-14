package sv.edu.udb.proyectodsm.Data;

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

import sv.edu.udb.proyectodsm.R;

public class platoAdapter extends FirebaseRecyclerAdapter<platoModel, platoAdapter.myviewholder> {

    public platoAdapter(@NonNull FirebaseRecyclerOptions<platoModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull platoModel model) {

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
            img = (ImageView)itemView.findViewById(R.id.imageFood);
            nombre=(TextView)itemView.findViewById(R.id.txtFoodName);
            desc=(TextView)itemView.findViewById(R.id.txtFoodDesc);

        }
    }
}
