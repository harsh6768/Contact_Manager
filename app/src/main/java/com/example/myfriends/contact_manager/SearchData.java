package com.example.myfriends.contact_manager;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchData extends AppCompatActivity {

    EditText inputMobileNumber;
    Button searchButton;
    TextView getName,getEmail;

    DatabaseHelper databaseHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seach_data);

        databaseHelper=new DatabaseHelper(this);

        inputMobileNumber=(EditText)findViewById(R.id.search_input);
        searchButton=(Button)findViewById(R.id.search_button);
        getName=(TextView)findViewById(R.id.get_name);
        getEmail=(TextView)findViewById(R.id.get_email);


    }

    public void searchFromDatabase(View view){

        Cursor cursor=databaseHelper.onSearch(inputMobileNumber.getText().toString());

        while(cursor.moveToNext())
        {
            getName.setText(cursor.getString(1));
            getEmail.setText(cursor.getString(3));
        }

    }

}
