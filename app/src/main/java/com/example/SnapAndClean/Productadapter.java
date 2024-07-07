package com.example.SnapAndClean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class Productadapter extends RecyclerView.Adapter<Productadapter.ViewHolder>{
    Context context;
    List<Productmodel> productmodelList;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth auth = FirebaseAuth.getInstance();

    public Productadapter(Context context, List<Productmodel> productmodelList) {
        this.context = context;
        this.productmodelList = productmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(productmodelList.get(position).getUri()).into(holder.imageView);
        holder.name.setText(productmodelList.get(position).getName());
        holder.description.setText(productmodelList.get(position).getDescription());
        holder.area.setText(productmodelList.get(position).getArea());
        holder.date.setText(productmodelList.get(position).getDate());
        holder.pincode.setText(productmodelList.get(position).getPin_Code());
        holder.address.setText(productmodelList.get(position).getAddress());
      /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details_Activity.class);
                intent.putExtra("detail",productmodelList.get(position));
                intent.putExtra("type",productmodelList.get(position).getType());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });*/
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.collection("Wastage").document(productmodelList.get(position).getDocId()).update("accptedBy",auth.getCurrentUser().getEmail() + "").addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, "Accept", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


     /*   holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.collection("Product").document(productmodelList.get(position).getDocId()).update("accptedBy",auth.getCurrentUser().getEmail() + "").addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, "Accepted", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return productmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,description,area,date,pincode,address;
        Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.productimg);
            name=itemView.findViewById(R.id.pname);
            description=itemView.findViewById(R.id.pdescription);
            area=itemView.findViewById(R.id.parea);
            date=itemView.findViewById(R.id.pdate);
            pincode=itemView.findViewById(R.id.ppincode);
            address=itemView.findViewById(R.id.paddress);
            button=itemView.findViewById(R.id.acceptbtn);
        }
    }
}
