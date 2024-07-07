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

public class My_Acceptd_Food extends AppCompatActivity {
    //Delivery boy's accepted wastage collection List
    FirebaseFirestore db;
    FirebaseUser auth;

    RecyclerView recyclerView;
    Acceptedadapter acceptedadapter;
    List<Acceptedmodel> acceptedmodelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_acceptd_food);
        db =FirebaseFirestore.getInstance();
        auth= FirebaseAuth.getInstance().getCurrentUser();
        recyclerView=findViewById(R.id.productrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        LocalBroadcastManager.getInstance(getApplicationContext());
        //  .registerReceiver(mMessageReceiver,new IntentFilter("MyTotalAmount"));

        acceptedmodelList = new ArrayList<>();
        acceptedadapter = new Acceptedadapter(getApplicationContext(),acceptedmodelList);
        recyclerView.setAdapter(acceptedadapter);
        db.collection("Wastage").whereEqualTo("accptedBy",auth.getEmail())/*.whereEqualTo("sendedBy",auth.getEmail())*/
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult() ){
                                Acceptedmodel acceptedmodel = document.toObject(Acceptedmodel.class);
                                acceptedmodelList.add(acceptedmodel);
                                // product_adapter.notifyDataSetChanged();
                                acceptedadapter.notifyDataSetChanged();
                            }
                        }else {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}