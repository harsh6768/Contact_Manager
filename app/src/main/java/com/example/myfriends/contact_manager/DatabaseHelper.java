package com.example.myfriends.contact_manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by myfriends on 4/2/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private  static final String DB_NAME="CONTACT.DB";   //you need to make the final so that the super can access the fields of the class
    private  static final String TABLE_NAME="CONTACTS";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);

        //for creating the database we need to execute the this query
        SQLiteDatabase db=this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+ "(id int primary key ,name varchar(30),mobile_no int,email varchar(50))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
      onCreate(sqLiteDatabase);
    }

    public boolean onInsert(String name,int mobileNO,String email){

        SQLiteDatabase database=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("mobile_no",mobileNO);
        contentValues.put("email",email);

        long result=database.insert(TABLE_NAME,null,contentValues);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor onSearch(String mobileNo){

        SQLiteDatabase db=this.getWritableDatabase();//it will create the database

        String query="select *from " +TABLE_NAME+ " where mobile_no='"+mobileNo+"'";

        Cursor cursor=db.rawQuery(query,null);

        return cursor;

    }

    public void onDelete(String mobileNO){

        SQLiteDatabase db=this.getWritableDatabase();

        db.delete(TABLE_NAME,"mobile_no='"+mobileNO+"'",null);

        db.close();
    }

    public void onUpdate(String mobileNO,String name,String email){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);

        db.update(TABLE_NAME,contentValues,"mobile_no='"+mobileNO+"'",null);

        db.close();
    }
}
