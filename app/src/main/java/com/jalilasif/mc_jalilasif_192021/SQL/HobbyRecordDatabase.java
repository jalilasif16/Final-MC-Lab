package com.jalilasif.mc_jalilasif_192021.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class HobbyRecordDatabase extends SQLiteOpenHelper {

    private final Context mainContext;
    private  static final String DatabaseName = "hobbydetails.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TableName = "hobbyinfo";

    public HobbyRecordDatabase(Context context) {
        super(context, DatabaseName,null, DATABASE_VERSION);
        mainContext=context;
        Toast.makeText(context,"Database Created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_create = "create table " + TableName + "(hobby TEXT,description TEXT)";
        db.execSQL(query_create);
        Toast.makeText(mainContext, "Table Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertHobby(String s_hobby,String s_description) {
        SQLiteDatabase sql_db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hobby", s_hobby);
        contentValues.put("description", s_description);

        long insertCheck = sql_db.insert(TableName, null, contentValues);
        return insertCheck != -1;
    }

    public Cursor getHobby(){
        SQLiteDatabase sql_db = this.getWritableDatabase();
        return sql_db.rawQuery("select * from "+ TableName,null);
    }
}