package com.example.ugotthis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add New Task");


        Button btn_add = (Button) findViewById(R.id.add_btn);

        //direct to task list activity
        btn_add.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                //create toast to indicate that new task have been done
                Toast.makeText(getApplicationContext() , "You created a new task", Toast.LENGTH_LONG).show();
                Intent numbersIntent = new Intent(AddActivity.this, TaskListActivity.class);
                startActivity(numbersIntent);
            }
        });



    }
}
