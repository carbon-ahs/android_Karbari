package com.axiagroups.karbari.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact_table")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String occupation;

    public Contact() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Contact(@NonNull String name, @NonNull String occupation) {
        this.name = name;
        this.occupation = occupation;
    }

    public Contact(int id, String name, String occupation) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }
}

