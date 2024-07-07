package com.example.SnapAndClean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garbagecollector.R;

import java.util.List;

public class Acceptedadapter extends RecyclerView.Adapter<Acceptedadapter.ViewHolder>{
    Context context;
    List<Acceptedmodel> acceptedmodelList;

    public Acceptedadapter(Context context, List<Acceptedmodel> acceptedmodelList) {
        this.context = context;
        this.acceptedmodelList = acceptedmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.accepted,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(acceptedmodelList.get(position).getDate());
        holder.name.setText(acceptedmodelList.get(position).getName());
        holder.time.setText(acceptedmodelList.get(position).getTime());
        holder.email.setText(acceptedmodelList.get(position).getEmail());
        holder.number.setText(acceptedmodelList.get(position).getMobilenumber());
        holder.username.setText(acceptedmodelList.get(position).getSendedBy());
    }

    @Override
    public int getItemCount() {
        return acceptedmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView date,name,time,email,number,username;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.adate);
            name=itemView.findViewById(R.id.aname);
            time=itemView.findViewById(R.id.atime);
            email=itemView.findViewById(R.id.aemail);
            number=itemView.findViewById(R.id.anumber);
            username=itemView.findViewById(R.id.auname);


        }
    }
}
