package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

class addbook extends AppCompatActivity implements View.OnClickListener {
    Button add_eng,home,add_kids,add_job,literature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout. activity_addbook);

        add_eng=(Button)findViewById(R.id.add_engid);
        home=(Button)findViewById(R.id.homeid);
        add_kids=(Button)findViewById(R.id.add_kidsid);
        add_job=(Button)findViewById(R.id.add_jobid);
        literature= (Button)findViewById(R.id.add_liteturatureid);

        add_eng.setOnClickListener(this);
        home.setOnClickListener(this);
        add_kids.setOnClickListener(this);
        add_job.setOnClickListener(this);
        literature.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.add_engid)
        {
            Intent intent=new Intent(addbook.this,add_eng_book.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.homeid)
        {
            Intent intent=new Intent(addbook.this,MainActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.add_kidsid)
        {
            Intent intent=new Intent(addbook.this,add_kids_book.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.add_jobid)
        {
            Intent intent=new Intent(addbook.this,add_job_book.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.add_liteturatureid)
        {
            Intent intent=new Intent(addbook.this,add_literature_book.class);
            startActivity(intent);
        }
    }
}