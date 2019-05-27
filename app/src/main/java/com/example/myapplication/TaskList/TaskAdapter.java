package com.example.myapplication.TaskList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>{
    private List<Task> mTasks;

    public TaskAdapter(List<Task> mTasks){
        this.mTasks = mTasks;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_cell,viewGroup,false);
        return new TaskViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder taskViewHolder, int i) {
        Task task = mTasks.get(i);
        taskViewHolder.title.setText(task.getTitle());
        taskViewHolder.description.setText(task.getDescription());
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }


    public class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;

        public TaskViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.taskText);
            description = itemView.findViewById(R.id.descriptionText);
        }
    }
}
