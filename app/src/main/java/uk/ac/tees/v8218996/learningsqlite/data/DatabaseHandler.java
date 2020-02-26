package uk.ac.tees.v8218996.learningsqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import uk.ac.tees.v8218996.learningsqlite.R;
import uk.ac.tees.v8218996.learningsqlite.model.Contact;
import uk.ac.tees.v8218996.learningsqlite.util.Util;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(Context context) {
        super(context, Util.DATABSE_NAME, null, Util.DATABASE_VERSION);
    }



    //create your table
    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL - STRUCTURE QUERY LANGUAGE
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + Util.TABLE_NAME
                + "("
                    + Util.KEY_ID + " INTEGER PRIMARY KEY, "
                    + Util.KEY_NAME + " TEXT, "
                    + Util.KEY_PHONE_NUMBER + " TEXT"
                + ")";

        //create the table
        db.execSQL(CREATE_CONTACT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //DROP THE TABLE
        String DROP_TABLE = String.valueOf(R.string.drop_table);
        db.execSQL(DROP_TABLE,new String[]{Util.DATABSE_NAME});


        //CREATE THE TABLE AGAIN
        onCreate(db);
    }

    //CRUD

    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        //using contact values

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME,contact.getName());
        values.put(Util.KEY_PHONE_NUMBER,contact.getPhoneNumber());

        db.insert(Util.TABLE_NAME,null ,values);

        //Log.d("NEW DB handler", "addContact: item added" );
        db.close();
    }

    public Contact getContact(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.TABLE_NAME,
                new String[]{Util.KEY_ID,Util.KEY_NAME,Util.KEY_PHONE_NUMBER},
                Util.KEY_ID + "=?", new String[]{String.valueOf(id)},
                null,null,null);
        if(cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact();

        assert cursor != null;
        contact.setId(Integer.parseInt(cursor.getString(0)));
        contact.setName(cursor.getString(1));
        contact.setPhoneNumber(cursor.getString(2));

        return contact;

    }

    public List <Contact> getAllContacts(){
        SQLiteDatabase db = this.getReadableDatabase();

        List<Contact> contactList = new ArrayList<>();

        //select all

        String selectAll = "SELECT * FROM " + Util.TABLE_NAME;

        Cursor cursor = db.rawQuery(selectAll,null);

        //loop through the data

        if (cursor.moveToFirst()){
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));

                //add contact objects to our list
                contactList.add(contact);

            }while (cursor.moveToNext());
        }

        return contactList;
    }

    //update contact
    public int updateContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME,contact.getName());
        values.put(Util.KEY_PHONE_NUMBER,contact.getPhoneNumber());


        //update row
        db.update(Util.TABLE_NAME,values,Util.KEY_ID + "=?",
                new String[]{String.valueOf(contact.getId())});

        return contact.getId();
    }

    public void deleteContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

         db.delete(Util.TABLE_NAME,Util.KEY_ID + "=?",new String[]{String.valueOf(contact.getId())});
    }
}
