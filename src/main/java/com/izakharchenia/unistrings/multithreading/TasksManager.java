package com.izakharchenia.unistrings.multithreading;

import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TasksManager {

    @Getter
    private HashMap<Integer, List<Task>> currentTasks = new HashMap<>();

    public synchronized void addTask(Integer userId, String str, int min, int max, int quantity) {
        Task task = new Task(userId, str, min, max, quantity);
        if (!currentTasks.containsKey(task.getUserId())) {
            LinkedList<Task> list = new LinkedList<>();
            list.add(task);
            currentTasks.put(task.getUserId(), list);
            task.startTask();
        }
        else {
            currentTasks.get(task.getUserId()).add(task);
            task.startTask();
        }
    }

}
