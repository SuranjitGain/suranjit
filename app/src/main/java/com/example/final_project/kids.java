package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Kids extends AppCompatActivity implements View.OnClickListener {
    private Button search,all_book,home,purches,contuct,books;
    Database database;
    private EditText name_editext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);

        search=(Button)findViewById(R.id.kids_book_searchid);
        all_book=(Button)findViewById(R.id.kids_allbookid);
        home=(Button)findViewById(R.id.homeid);
        purches=(Button)findViewById(R.id.purches_id);
        contuct=(Button)findViewById(R.id.contuct_id);
        books=(Button)findViewById(R.id.booksid);

        search.setOnClickListener(this);
        all_book.setOnClickListener( this);
        home.setOnClickListener( this);
        purches.setOnClickListener( this);
        contuct.setOnClickListener( this);
        books.setOnClickListener( this);


        database=new Database(this);
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        name_editext=(EditText)findViewById(R.id.search_nameid);
    }

    @Override
    public void onClick(View view) {

        String name = name_editext.getText().toString();

        if (view.getId() == R.id.kids_book_searchid) {
            SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
            Cursor cursor = database.display_kids_search_book(name);
            if (cursor.getCount()==0) {
                showdata("Error", "Np data found");

            } else {
                StringBuffer stringBuffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    stringBuffer.append("ID:" + cursor.getString(0)+"\t\t\t");
                    stringBuffer.append("Name:" + cursor.getString(1)+"\t\t\t");
                    stringBuffer.append("Writer name:" + cursor.getString(2)+"\t\t\t");
                    stringBuffer.append("Prize:" + cursor.getString(3)+"\t \t\t\n\n");


                }
                showdata("resultset", stringBuffer.toString());
            }

        }
        if (view.getId() == R.id.kids_allbookid) {
            SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
            Cursor cursor = database.display_kids_book();
            if (cursor.getCount()==0) {
                showdata("Error", "Np data found");

            }

            else {
                StringBuffer stringBuffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    stringBuffer.append("ID:" + cursor.getString(0)+"\t\t\t");
                    stringBuffer.append("Name:" + cursor.getString(1)+"\t\t\t");
                    stringBuffer.append("Writer name:" + cursor.getString(2)+"\t\t\t");
                    stringBuffer.append("Prize:" + cursor.getString(3)+"\t \t\t\n\n");


                }
                showdata("resultset", stringBuffer.toString());
            }
        }
        if (view.getId() == R.id.homeid)
        {
            Intent intent=new Intent(Kids.this,MainActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.purches_id)
        {

        }
        if (view.getId() == R.id.contuct_id)
        {

        }
        if (view.getId() == R.id.booksid)
        {
            Intent intent=new Intent(Kids.this,Books.class);
            startActivity(intent);
        }

    }
    public void showdata (String title,String messege)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(messege);
        builder.setCancelable(true);
        builder.show();
    }
}