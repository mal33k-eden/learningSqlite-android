package uk.ac.tees.v8218996.learningsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import uk.ac.tees.v8218996.learningsqlite.data.DatabaseHandler;
import uk.ac.tees.v8218996.learningsqlite.model.Contact;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList <String> contactArrayList;
    private ArrayAdapter <String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        contactArrayList = new ArrayList<>();

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

//        db.addContact(new Contact("Jerome","1234567890"));
//        db.addContact(new Contact("Dickson","12345609876"));
//        db.addContact(new Contact("Daisy","234567987654"));
//        db.addContact(new Contact("Opokua","456787654356"));
//        db.addContact(new Contact("Nana Kwasei","1234567890"));
//        db.addContact(new Contact("Emmanuel","7754324567876"));
//        db.addContact(new Contact("Eden","1234567890"));
//        db.addContact(new Contact("Patience","1234567890"));
//        db.addContact(new Contact("Kofi","1234567890"));
//        db.addContact(new Contact("Hellen","1234567890"));
//        db.addContact(new Contact("Winfred","1234567890"));
//        db.addContact(new Contact("Margaret","1234567890"));
//        db.addContact(new Contact("Ose","1234567890"));

        List<Contact> contactList = db.getAllContacts();
        for (Contact c: contactList){

            contactArrayList.add(c.getName());
            //Log.d("mainacti", "onCreate: " + c.getName() +","+ c.getPhoneNumber());
        }

//        //create array adapter
//        arrayAdapter = new ArrayAdapter<>(
//          this,
//                android.R.layout.simple_list_item_1,
//                contactArrayList
//        );
//
//        //add to our listview
//        listView.setAdapter(arrayAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });

//        jerome.setName("Jerome");
//        jerome.setPhoneNumber("098765432");

        //db.addContact(jerome);



       //Contact contact = db.getContact(2);

       //db.deleteContact(contact);

       //contact.setName("Eden");
      // contact.setPhoneNumber("07786982012");

       //int updatedRow = db.updateContact(contact);

//        List<Contact> contactList = db.getAllContacts();
//
//        for (Contact c: contactList){
//            Log.d("mainacti", "onCreate: " + c.getName() +","+ c.getPhoneNumber());
//        }



        //Log.d("main", "onCreate: " + updatedRow);

    }
}
