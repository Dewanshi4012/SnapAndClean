package com.example.SnapAndClean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Wastageadapter extends RecyclerView.Adapter<Wastageadapter.ViewHolder>{

    Context context;
    List<Productmodel> productmodelList;

    public Wastageadapter(Context context, List<Productmodel> productmodelList) {
        this.context = context;
        this.productmodelList = productmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Wastageadapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.wastage,parent,false));

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
    }

    @Override
    public int getItemCount() {
        return productmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,description,area,date,pincode,address;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.productimg);
            name=itemView.findViewById(R.id.pname);
            description=itemView.findViewById(R.id.pdescription);
            area=itemView.findViewById(R.id.parea);
            date=itemView.findViewById(R.id.pdate);
            pincode=itemView.findViewById(R.id.ppincode);
            address=itemView.findViewById(R.id.paddress);
        }
    }
}
