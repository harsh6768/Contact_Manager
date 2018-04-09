package com.example.myfriends.contact_manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button search,add,delete,update;

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search=(Button)findViewById(R.id.search_Id);
        add=(Button)findViewById(R.id.add_Id);
        delete=(Button)findViewById(R.id.delete_Id);
        update=(Button)findViewById(R.id.update_Id);


        databaseHelper=new DatabaseHelper(this);

    }

    public void addContact(View view){
        Intent addContact=new Intent(MainActivity.this,AddContact.class);
        startActivity(addContact);
    }

    public void search(View view){
        Intent intent=new Intent(MainActivity.this,SearchData.class);
        startActivity(intent);
    }

    public void delete(View view){
        Intent intent=new Intent(MainActivity.this,deleteData.class);
        startActivity(intent);
    }

    public void updateDatabase(View view){
        Intent intent=new Intent(MainActivity.this,updateData.class);
        startActivity(intent);
    }
}
