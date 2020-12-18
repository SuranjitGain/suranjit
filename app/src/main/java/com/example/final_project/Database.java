package com.example.final_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.time.Instant;


public class Database extends SQLiteOpenHelper {
    private static final String Database_name="Books.db";
    private static final String Eng_table="Engineering_book";
    private static final String Kids_table="Kids_book";
    private static final String Job_table="job_book";
    private static final String Literature_table="Literature_book";
    private static final String Book_id="ID";
    private static final String Book_name="Name";
    private static final String Writer_name="Writer_name";
    private static final String Book_price="Price";
    private static final int Version_number=3;
    private static final String all_eng_book="SELECT * FROM "+Eng_table;
    private static final String all_kids_book="SELECT * FROM "+Kids_table;
    private static final String all_job_book="SELECT * FROM "+Job_table;
    private static final String all_literature_book="SELECT * FROM "+Literature_table;
    private static final String Create_eng_table=" CREATE TABLE "+Eng_table+" ( "+Book_id+" INTEGER PRIMARY KEY  AUTOINCREMENT,"+Book_name+" VARCHAR(200),"+Writer_name+" VARCHAR(200), "+Book_price+" INTEGER);";
    private static final String Create_Kids_table=" CREATE TABLE "+Kids_table +" ( "+Book_id+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+Book_name+" VARCHAR(200),"+Writer_name+" VARCHAR(200), "+Book_price+" INTEGER);";
    private static final String Create_job_table=" CREATE TABLE "+Job_table +" ( "+Book_id+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+Book_name+" VARCHAR(200),"+Writer_name+" VARCHAR(200), "+Book_price+" INTEGER);";
    private static final String Create_Literature_table=" CREATE TABLE "+Literature_table +" ( "+Book_id+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+Book_name+" VARCHAR(200),"+Writer_name+" VARCHAR(200), "+Book_price+" INTEGER);";
    private Context  context;


    public Database(Context context) {
        super(context, Database_name, null, Version_number);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        try{
            sqLiteDatabase.execSQL(Create_eng_table);
            sqLiteDatabase.execSQL(Create_job_table);
            sqLiteDatabase.execSQL(Create_Kids_table);
            sqLiteDatabase.execSQL(Create_Literature_table);
            Toast.makeText(context,"On creat is callrd",Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(context,"On creat is failled",Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            db.execSQL("DROP TABLE IF EXISTS "+Eng_table);
            db.execSQL("DROP TABLE IF EXISTS "+Job_table);
            db.execSQL("DROP TABLE IF EXISTS "+Kids_table);
            db.execSQL("DROP TABLE IF EXISTS "+Literature_table);
            onCreate(db);
            Toast.makeText(context,"On upgrad is callrd",Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(context,"On upgrad is failled",Toast.LENGTH_SHORT).show();
        }

    }



    public  Cursor display_eng_book()
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(all_eng_book,null);
        return cursor;
    }

    public  Cursor display_kids_book()
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(all_kids_book,null);
        return cursor;
    }
    public  Cursor display_job_book()
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(all_job_book,null);
        return cursor;
    }
    public  Cursor display_literature_book()
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(all_literature_book,null);
        return cursor;
    }

    public  Long insert_Eng_book(String name,String writer,String price)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Book_name,name);
        contentValues.put(Writer_name,writer);
        contentValues.put(Book_price,price);
        long rowid=sqLiteDatabase.insert(Eng_table,null,contentValues);
        return rowid;
    }


    public  Long insert_kids_book(String name,String writer,String price)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Book_name,name);
        contentValues.put(Writer_name,writer);
        contentValues.put(Book_price,price);
        long rowid=sqLiteDatabase.insert(Kids_table,null,contentValues);
        return rowid;
    }

    public  Long insert_literature_book(String name,String writer,String price)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Book_name,name);
        contentValues.put(Writer_name,writer);
        contentValues.put(Book_price,price);
        long rowid=sqLiteDatabase.insert(Literature_table,null,contentValues);
        return rowid;
    }

    public  Long insert_job_book(String name,String writer,String price)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Book_name,name);
        contentValues.put(Writer_name,writer);
        contentValues.put(Book_price,price);
        long rowid=sqLiteDatabase.insert(Job_table,null,contentValues);
        return rowid;
    }
    public  Cursor display_eng_search_book(String name)
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("SELECT * FROM Engineering_book WHERE Name='"+name+"'",null);
        return cursor;
    }

    public  Cursor display_kids_search_book(String name)
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("SELECT * FROM Kids_book WHERE Name='"+name+"'",null);
        return cursor;
    }

    public  Cursor display_job_search_book(String name)
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("SELECT * FROM job_book WHERE Name='"+name+"'",null);
        return cursor;
    }

    public  Cursor display_literature_search_book(String name)
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("SELECT * FROM Literature_book WHERE Name='"+name+"'",null);
        return cursor;
    }


    public  Cursor buy_eng_book(Integer id)
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("SELECT * FROM Engineering_book WHERE ID='"+id+"'",null);
        return cursor;
    }

    public  Cursor buy_job_book(Integer id)
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("SELECT * FROM job_book WHERE ID='"+id+"'",null);
        return cursor;
    }

    public  Cursor buy_kids_book(Integer id)
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("SELECT * FROM Kids_book WHERE ID='"+id+"'",null);
        return cursor;
    }

    public  Cursor buy_literature_book(Integer id)
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("SELECT * FROM Literature_book WHERE ID='"+id+"'",null);
        return cursor;
    }

}

