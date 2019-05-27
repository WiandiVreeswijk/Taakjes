package com.example.myapplication.TaskList;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.myapplication.Database.Repository;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private Repository mRepository;
    private LiveData<List<Task>> mTasks;

    public ViewModel(@NonNull Application application) {
        super(application);
        mRepository = new Repository(application.getApplicationContext());
        mTasks = mRepository.getAllTasks();
    }

    public LiveData<List<Task>> getmTasks(){
        return mTasks;
    }

    public void insert(Task task){
        mRepository.insert(task);
    }

    public void update(Task task){
        mRepository.update(task);
    }

    public void delete(Task task){
        mRepository.delete(task);
    }

    public void deleteAll(){
        mRepository.deleteAll(mTasks.getValue());
    }
}
