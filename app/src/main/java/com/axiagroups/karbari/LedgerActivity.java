package com.axiagroups.karbari;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.axiagroups.karbari.adapter.RecyclerViewAdapter;
import com.axiagroups.karbari.model.Contact;
import com.axiagroups.karbari.model.ContactViewModel;

import java.util.List;

public class LedgerActivity extends AppCompatActivity {
    private ContactViewModel contactViewModel;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private LiveData<List<Contact>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ledger);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recycleView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(LedgerActivity.this));
        contactViewModel = new ViewModelProvider.AndroidViewModelFactory(LedgerActivity.this
                .getApplication())
                .create(ContactViewModel.class);


        contactViewModel.getAllContacts().observe(this, contacts -> {


            recyclerViewAdapter = new RecyclerViewAdapter(contacts, LedgerActivity.this);

            recyclerView.setAdapter(recyclerViewAdapter);

        });

    }
}