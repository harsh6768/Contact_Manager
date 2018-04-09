package com.example.myfriends.contact_manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deleteData extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    EditText delData;
    Button deleteDataFromDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        delData=(EditText)findViewById(R.id.delNo_id);
        deleteDataFromDatabase=(Button)findViewById(R.id.delete_Id);

        databaseHelper=new DatabaseHelper(this);
    }

    public void delDataFromDatabase(View view){

        databaseHelper.onDelete(delData.getText().toString());   //calling of the onDelete method and passing the number as string

        Toast.makeText(this,"Data deleted succesfully!!!",Toast.LENGTH_SHORT).show();

    }
}
