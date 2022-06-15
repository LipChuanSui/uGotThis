package com.example.ugotthis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox_Home = null;

    TextView first_home = null;
    TextView second_home = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout rl = (RelativeLayout)findViewById(R.id.task_home);
        getSupportActionBar().setTitle("Home");

        checkBox_Home = (CheckBox) findViewById(R.id.check_task_home);
        first_home = (TextView) findViewById(R.id.firstLine_home);
        second_home = (TextView) findViewById(R.id.secondLine_home);



        //check the task at homepage, change backgroudn color to green and change word
        checkBox_Home.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                rl.setBackgroundResource(R.color.colorPrimaryLight);

                first_home.setText("Great Job ! uGotThis");
                second_home.setText("");
                checkBox_Home.setEnabled(false);
            }
        }
        );


        Button btn_add = (Button) findViewById(R.id.add_btn);

        //direct to task list activity
        btn_add.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(numbersIntent);
            }
        });

        Button btn_task = (Button) findViewById(R.id.task_btn);

        //direct to add task activity
        btn_task.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, TaskListActivity.class);
                startActivity(numbersIntent);
            }
        });


    }
}
