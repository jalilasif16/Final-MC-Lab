package com.jalilasif.mc_jalilasif_192021.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context mainContext;
    private  static  String DatabaseName="studentdetails.db";
    private static  int DATABASE_VERSION =1;
    private static String TableName="studentinfo";
    private  String query_create="create table "+ TableName+ "(id TEXT PRIMARY KEY," +"name TEXT,city TEXT,age TEXT)";

    public DatabaseHelper( Context context) {
        super(context, DatabaseName,null, DATABASE_VERSION);
        mainContext=context;
        Toast.makeText(context,"Database Created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query_create);
        Toast.makeText(mainContext, "Table Created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertData(String s_id,String s_name,String s_city,String s_age) {
        SQLiteDatabase sql_db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", s_id);
        contentValues.put("name", s_name);
        contentValues.put("city", s_city);
        contentValues.put("age", s_age);
        //insert into table studentinfo
        long insertCheck = sql_db.insert(TableName, null, contentValues);
        if (insertCheck == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getStudentData(){
        SQLiteDatabase sql_db = this.getWritableDatabase();
        Cursor cursor= sql_db.rawQuery("select * from "+ TableName,null);
        return cursor;
    }



}

