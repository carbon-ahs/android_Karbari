package com.axiagroups.karbari.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.axiagroups.karbari.data.ContactDao;
import com.axiagroups.karbari.model.Contact;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Contact.class}, version = 1, exportSchema = false)
public abstract class ContactRoomDatabase extends RoomDatabase {
    public static final int NUMBER_OF_THREADS = 4;
    public static final String DB_NAME = "contact_database";
    public abstract ContactDao contactDao();
    private static volatile ContactRoomDatabase INSTANCE;
    public static final ExecutorService databaseExecutor
            = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ContactRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (ContactRoomDatabase.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ContactRoomDatabase.class, DB_NAME)
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);

                    databaseExecutor.execute(() -> {
                        ContactDao contactDao = INSTANCE.contactDao();
                        contactDao.deleteAll();

//                        contactDao.insert(new Contact("", ""));
                        contactDao.insert(new Contact("a", "a"));
                        contactDao.insert(new Contact("b", "b"));
                        contactDao.insert(new Contact("c", "c"));
                        contactDao.insert(new Contact("d", "d"));
                        contactDao.insert(new Contact("e", "e"));
                        contactDao.insert(new Contact("f", "f"));
                        contactDao.insert(new Contact("g", "g"));
                        contactDao.insert(new Contact("h", "h"));
                        contactDao.insert(new Contact("i", "i"));
                        contactDao.insert(new Contact("j", "j"));
                        contactDao.insert(new Contact("a", "a"));
                        contactDao.insert(new Contact("b", "b"));
                        contactDao.insert(new Contact("c", "c"));
                        contactDao.insert(new Contact("d", "d"));
                        contactDao.insert(new Contact("e", "e"));
                        contactDao.insert(new Contact("f", "f"));
                        contactDao.insert(new Contact("g", "g"));
                        contactDao.insert(new Contact("h", "h"));
                        contactDao.insert(new Contact("i", "i"));
                        contactDao.insert(new Contact("j", "j"));

                    });
                }
            };
}
