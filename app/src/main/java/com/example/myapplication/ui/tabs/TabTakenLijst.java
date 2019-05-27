package com.example.myapplication.ui.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.myapplication.AddTask;
import com.example.myapplication.R;
import com.example.myapplication.TaskList.Task;
import com.example.myapplication.TaskList.TaskAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class TabTakenLijst extends Fragment {
    List<Task> mTasks;
    private RecyclerView mRecyclerView;
    private TaskAdapter mTaskAdapter;
//    private GestureDetector mGestureDetector;
    private ImageButton addTaskButton;
    public static final String ADD_TASK = "NewTask";
    public static final int NewTaskCode = 4321;
    public static final String VIEW_TASK = "ViewTask";
    public static final int ViewTaskCode = 3421;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabtakenlijst,container,false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.taskRecyclerView);
        addTaskButton = view.findViewById(R.id.addTask);
        mTasks = new ArrayList<>();
        mTaskAdapter = new TaskAdapter(mTasks);
        mRecyclerView.setAdapter(mTaskAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AddTask.class);
                startActivityForResult(intent, NewTaskCode);
            }
        });
        return view;
    }
    public void updateUI() {
        if (mTaskAdapter == null) {
            mTaskAdapter = new TaskAdapter(mTasks);
            mRecyclerView.setAdapter(mTaskAdapter);
        } else {
            mTaskAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NewTaskCode){
            if(resultCode == RESULT_OK){
                Task task = data.getParcelableExtra(TabTakenLijst.ADD_TASK);
                mTasks.add(task);
                updateUI();
            }
        }
    }
}
