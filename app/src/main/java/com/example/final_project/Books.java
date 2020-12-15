package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Books extends AppCompatActivity {
    Button home, Eng,kids,job,literature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        home= findViewById(R.id.homeid);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( Books.this,MainActivity.class);
                startActivity(intent);

            }
        });
        Eng= findViewById(R.id.engid);
        Eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( Books.this,Eng_book.class);
                startActivity(intent);
            }
        });

        kids=(Button) findViewById(R.id.kidsid);
        kids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Books.this,Kids.class);
                startActivity(intent);
            }
        });
        job=(Button)findViewById(R.id.jobid);
        job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Books.this,job_book.class);
                startActivity(intent);
            }
        });
        literature=(Button)findViewById(R.id.literatureid);
        literature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Books.this,literature_book.class);
                startActivity(intent);
            }
        });

    }
}