package com.example.myfriends.contact_manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateData extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText updateName,updateEmail,updateNumber;
    Button updateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        databaseHelper=new DatabaseHelper(this);

        updateNumber=(EditText)findViewById(R.id.update_number);
        updateName=(EditText)findViewById(R.id.update_name);
        updateEmail=(EditText)findViewById(R.id.update_email);
        updateButton=(Button)findViewById(R.id.updateBt_id);

    }

    public void updateDataOnDatabase(View view){

          databaseHelper.onUpdate(updateNumber.getText().toString(),updateName.getText().toString(),updateEmail.getText().toString());

        Toast.makeText(this,"Data successfully updated!!!",Toast.LENGTH_SHORT).show();

    }
}
