package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class buy_book extends AppCompatActivity implements View.OnClickListener {
    private Button buy_eng_book,buy_job_book,buy_kids_book,buy_literature_book,home,purches,books,contuct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_book);

        buy_eng_book=(Button)findViewById(R.id.engid);
        buy_job_book=(Button)findViewById(R.id.jobid);
        buy_kids_book=(Button)findViewById(R.id.kidsid);
        buy_literature_book=(Button)findViewById(R.id.literatureid);
        home=(Button)findViewById(R.id.homeid);
        purches=(Button)findViewById(R.id.purches_id);
        contuct=(Button)findViewById(R.id.contuct_id);
        books=(Button)findViewById(R.id.booksid);


        home.setOnClickListener( this);
        purches.setOnClickListener( this);
        contuct.setOnClickListener( this);
        books.setOnClickListener( this);
        buy_eng_book.setOnClickListener( this);
        buy_job_book.setOnClickListener( this);
        buy_kids_book.setOnClickListener( this);
        buy_literature_book.setOnClickListener( this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.homeid)
        {
            Intent intent=new Intent(buy_book.this,MainActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.purches_id)
        {
            Intent intent=new Intent(buy_book.this,buy_book.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.contuct_id)
        {
            Intent intent=new Intent(buy_book.this,contuct.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.booksid)
        {
            Intent intent=new Intent(buy_book.this,Books.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.engid)
        {
            Intent intent=new Intent(buy_book.this,buy_eng_book.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.kidsid)
        {
            Intent intent=new Intent(buy_book.this,buy_kids_book.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.jobid)
        {
            Intent intent=new Intent(buy_book.this,buy_job_book.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.literatureid)
        {
            Intent intent=new Intent(buy_book.this,buy_literature_book.class);
            startActivity(intent);
        }
    }
}