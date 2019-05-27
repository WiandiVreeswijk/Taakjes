package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.TaskList.Task;
import com.example.myapplication.ui.tabs.TabTakenLijst;

public class AddTask extends AppCompatActivity {
    private TextView mTitle;
    private TextView mDescription;
    private ImageButton mAddTaskButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        mTitle = findViewById(R.id.titleEditText);
        mDescription = findViewById(R.id.descriptionEditText);
        mAddTaskButton = findViewById(R.id.addTask);

        mAddTaskButton.setOnClickListener(v -> {
            String titleText = mTitle.getText().toString();
            String descriptionText = mDescription.getText().toString();

            if(!TextUtils.isEmpty(titleText) && !TextUtils.isEmpty(descriptionText)){
                Task task = new Task(titleText,descriptionText);
                Intent intent = new Intent();
                intent.putExtra(TabTakenLijst.ADD_TASK,task);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }else{
                Snackbar.make(v,"fill in all the fields",Snackbar.LENGTH_SHORT);

            }
        });


    }
}
