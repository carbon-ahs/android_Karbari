package com.axiagroups.karbari.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.axiagroups.karbari.data.ContactRepository;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {
    public static ContactRepository repository;
    public final LiveData<List<Contact>> allContacts;
    public ContactViewModel(@NonNull Application application) {
        super(application);
        repository = new ContactRepository(application);
        allContacts = repository.getAllContacts();
    }
    public LiveData<List<Contact>> getAllContacts() { return allContacts; }
    public static void insert(Contact contact) { repository.insert(contact); }
}
