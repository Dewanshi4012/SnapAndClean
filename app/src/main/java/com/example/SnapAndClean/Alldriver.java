package com.example.SnapAndClean;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class Alldriver extends AppCompatActivity {
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    List<Umodel> umodelList;
    FirebaseFirestore db;
    FirebaseUser auth;
    DatabaseReference mbase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alldriver);

        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance().getCurrentUser();
        recyclerView =findViewById(R.id.driverrec);
        mbase
                = FirebaseDatabase.getInstance().getReference("Delregister");

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



        umodelList = new ArrayList<>();
        userAdapter = new UserAdapter(getApplicationContext(), umodelList);
        recyclerView.setAdapter(userAdapter);
// Read from the database

        mbase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Umodel usermodel = dataSnapshot.getValue(Umodel.class);
                    umodelList.add(usermodel);
                }
                userAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}