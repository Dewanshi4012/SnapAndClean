package com.example.SnapAndClean;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    Context context;
    List<Umodel> umodelList;

    public UserAdapter(Context context, List<Umodel> umodelList) {
        this.context = context;
        this.umodelList = umodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.userdata,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(umodelList.get(position).getName());
        holder.email.setText(umodelList.get(position).getEmail());
        holder.number.setText(umodelList.get(position).getPhone());



    }

    @Override
    public int getItemCount() {
        return umodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,email,number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.username);
            email=itemView.findViewById(R.id.useremail);
            number=itemView.findViewById(R.id.usernumber);
        }
    }
}
