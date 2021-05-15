package sv.edu.udb.proyectodsm.Data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import sv.edu.udb.proyectodsm.R;

public class historyAdapter extends FirebaseRecyclerAdapter<historyModel, historyAdapter.myviewholder> {
    public historyAdapter(@NonNull FirebaseRecyclerOptions<historyModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull historyAdapter.myviewholder holder, int position, @NonNull historyModel model) {
        String pe = "Pedido realizado el: " + model.getFecha();
        holder.pedido.setText(pe);
        holder.desc.setText(model.getPedido());
        String monto = "Total: $" + String.valueOf(model.getTotal());
        holder.total.setText(monto);

    }

    @NonNull
    @Override
    public historyAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orden_row,parent, false);
        return new historyAdapter.myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView pedido, desc, total;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            pedido=(TextView)itemView.findViewById(R.id.txtFoodName);
            desc=(TextView)itemView.findViewById(R.id.txtFoodDesc);
            total=(TextView)itemView.findViewById(R.id.txtTotalHistory);

        }
    }
}
