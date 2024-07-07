package com.example.SnapAndClean;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Allwastage extends AppCompatActivity {
    FirebaseFirestore db;
    FirebaseUser auth;

    RecyclerView recyclerView;
    Wastageadapter wastageadapter;
    List<Productmodel> productmodelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allwastage);

        db =FirebaseFirestore.getInstance();
        auth= FirebaseAuth.getInstance().getCurrentUser();
        recyclerView=findViewById(R.id.wastagerec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        LocalBroadcastManager.getInstance(getApplicationContext());
        //  .registerReceiver(mMessageReceiver,new IntentFilter("MyTotalAmount"));

        productmodelList = new ArrayList<>();
        wastageadapter = new Wastageadapter(getApplicationContext(),productmodelList);
        recyclerView.setAdapter(wastageadapter);
        db.collection("Wastage")/*.whereEqualTo("accptedBy",auth.getEmail())*//*.whereEqualTo("sendedBy",auth.getEmail())*/
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult() ){
                                Productmodel acceptedmodel = document.toObject(Productmodel.class);
                                productmodelList.add(acceptedmodel);
                                // product_adapter.notifyDataSetChanged();
                                wastageadapter.notifyDataSetChanged();
                            }
                        }else {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}