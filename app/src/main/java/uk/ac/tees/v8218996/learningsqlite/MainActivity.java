package uk.ac.tees.v8218996.learningsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import uk.ac.tees.v8218996.learningsqlite.data.DatabaseHandler;
import uk.ac.tees.v8218996.learningsqlite.model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Contact jerome = new Contact();

        jerome.setName("Jerome");
        jerome.setPhoneNumber("098765432");

        //db.addContact(jerome);



       //Contact contact = db.getContact(2);

       //db.deleteContact(contact);

       //contact.setName("Eden");
      // contact.setPhoneNumber("07786982012");

       //int updatedRow = db.updateContact(contact);

        List<Contact> contactList = db.getAllContacts();

        for (Contact c: contactList){
            Log.d("mainacti", "onCreate: " + c.getName() +","+ c.getPhoneNumber());
        }



        //Log.d("main", "onCreate: " + updatedRow);

    }
}
