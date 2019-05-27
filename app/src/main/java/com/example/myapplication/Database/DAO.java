package com.example.myapplication.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.myapplication.TaskList.Task;

import java.util.List;

@Dao
public interface DAO {

    @Insert
    void insert(Task task);

    @Delete
    void delete(Task task);

    @Delete
    void delete(List<Task> tasks);

    @Update
    void update(Task task);

    @Query("SELECT * from taskTable")
    LiveData<List<Task>> getAllTasks();
}
