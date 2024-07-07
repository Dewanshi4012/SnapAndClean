package com.example.SnapAndClean;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Login_Dashboard extends AppCompatActivity {
    CardView user,service,delivery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dashboard);

        user=findViewById(R.id.userlogin);
        service=findViewById(R.id.servicelogin);
        delivery=findViewById(R.id.delavirylogin);

        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Dashboard.this, Delivery_Login.class);
                startActivity(intent);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Dashboard.this, Login_Page.class);
                startActivity(intent);
            }
        });

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Dashboard.this, Admin_Login.class);
                startActivity(intent);
            }
        });
    }
}
