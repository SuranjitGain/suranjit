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

public class buy_literature_book extends AppCompatActivity implements View.OnClickListener {
    private Button home,purches;
    Database database;
    private EditText id_editext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_literature_book);

        home=(Button)findViewById(R.id.homeid);
        purches=(Button)findViewById(R.id.buy_book_id);

        home.setOnClickListener(this);
        purches.setOnClickListener(this);


        database=new Database(this);
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        id_editext=(EditText)findViewById(R.id.search_id);
    }

    @Override
    public void onClick(View view) {
        Integer id =Integer.parseInt(id_editext.getText().toString());

        if (view.getId() == R.id.buy_book_id) {
            SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
            Cursor cursor = database.buy_literature_book(id);

            if (cursor.getCount()==0) {
                showdata("Error", "The id is invalid");

            }
            else {
                StringBuffer stringBuffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    stringBuffer.append("The book name is   :" + cursor.getString(1)+"\t\t\t\n\n");
                    stringBuffer.append(" the book Prize is  :" + cursor.getString(3)+"\t \t\t\n\n");


                }
                showdata("resultset", stringBuffer.toString());
            }
        }


        if (view.getId() == R.id.homeid)
        {
            Intent intent=new Intent(buy_literature_book.this,MainActivity.class);
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