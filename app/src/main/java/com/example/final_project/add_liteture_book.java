package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

class add_literature_book extends AppCompatActivity implements View.OnClickListener {
    Button add,home;
    private EditText name_editext,writer_editext,prize_editext;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_literature_book);

        database=new Database(this);
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();

        name_editext=(EditText)findViewById(R.id.nameid);
        writer_editext=(EditText)findViewById(R.id.writer_nameid);
        prize_editext=(EditText)findViewById(R.id.prizeid);
        add=(Button) findViewById(R.id.addid);
        home=(Button) findViewById(R.id.homeid);
        add.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String name = name_editext.getText().toString();
        String writer = writer_editext.getText().toString();
        String price = prize_editext.getText().toString();

        if (view.getId() == R.id.addid)
        {
            long rowid=database.insert_literature_book(name,writer,price);
            if(rowid==-1)
            {
                Toast.makeText(getApplicationContext(),"Unsessfull", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "row "+rowid+" sessfully inserted" ,Toast.LENGTH_LONG).show();

            }
        }
        if (view.getId() == R.id.homeid)
        {
            Intent intent=new Intent(add_literature_book.this,MainActivity.class);
            startActivity(intent);
        }
    }
}