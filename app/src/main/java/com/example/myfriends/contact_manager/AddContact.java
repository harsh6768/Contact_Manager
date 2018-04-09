package com.example.myfriends.contact_manager;

import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContact extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText name,mobileNo,email;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        databaseHelper=new DatabaseHelper(this);

        name=(EditText)findViewById(R.id.name_Id);
        mobileNo=(EditText)findViewById(R.id.mobile_Id);
        email=(EditText)findViewById(R.id.email_Id);
        save=(Button)findViewById(R.id.save_Id);

    }

    public void insertIntoDatabase(View view){

        boolean result=databaseHelper.onInsert(name.getText().toString(),Integer.parseInt(mobileNo.getText().toString())
                ,email.getText().toString());

        if(result)
            Toast.makeText(AddContact.this,"Data Inserted Successfully!!!",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(AddContact.this,"Data didn't insert!!!",Toast.LENGTH_SHORT).show();

    }


}
