package com.example.myapplication.Database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.myapplication.TaskList.Task;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Repository {
    private TaskRoomDatabase db;
    private DAO dao;
    private LiveData<List<Task>> mTasks;
    /**creating pool with exactly 1 thread**/
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    public Repository(Context context){
        this.db = TaskRoomDatabase.getDatabase(context);
        this.dao = db.dao();
        this.mTasks = dao.getAllTasks();
    }
    public LiveData<List<Task>> getAllTasks() {
        return mTasks;
    }
    /**dont have to communicate with the UI thread
     * Dont execute queries on main thread
     * **/
    public void insert(final Task task){
        mExecutor.execute(() -> dao.insert(task));
    }

    public void update(final Task task){
        mExecutor.execute(() -> dao.update(task));
    }

    public void delete(final Task task){
        mExecutor.execute(()->dao.delete(task));
    }

    public void deleteAll(List<Task> task){
        mExecutor.execute(()->dao.delete(task));
    }
}
