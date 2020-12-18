package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Database  database;
    Button books,admin,purches,contuct;
    Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database=new Database(this);
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        books=(Button) findViewById(R.id.booksid);
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Books.class);
                startActivity(intent);
            }
        });

     admin=findViewById(R.id.adminid);
     admin.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(MainActivity.this,addbook.class);
             startActivity(intent);
         }
     });
        purches=(Button)findViewById(R.id.purchesid);
        purches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,buy_book.class);
                startActivity(intent);
            }
        });
        contuct=(Button)findViewById(R.id.contuctid);
        contuct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,contuct.class);
                startActivity(intent);
            }
        });
    }
}