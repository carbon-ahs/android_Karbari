package com.axiagroups.karbari;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageButton simpleInterestBtn, compoundInterestBtn, ledgerBtn, aboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        simpleInterestBtn = findViewById(R.id.simpleInterestBtn);
        compoundInterestBtn = findViewById(R.id.compoundInterestBtn);
        ledgerBtn = findViewById(R.id.ledgerBtn);
        aboutBtn = findViewById(R.id.aboutBtn);

        simpleInterestBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SimpleInterestActivity.class);
            startActivity(intent);
        });
        compoundInterestBtn.setOnClickListener(v -> {});
        ledgerBtn.setOnClickListener(v -> {});
        aboutBtn.setOnClickListener(v -> {});
    }
}