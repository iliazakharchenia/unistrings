package com.izakharchenia.unistrings.multythreading;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Component
public class TasksManager {

    @Getter
    private HashMap<Integer, List<Task>> currentTasks = new HashMap<>();

    public void addTask(Task task, int user_id) {
        if (!currentTasks.containsKey(user_id)) {
            currentTasks.put(task.getUserId(), new LinkedList<>());
            currentTasks.get(user_id).add(task);
            task.startTask();
        }
        else {
            currentTasks.get(user_id).add(task);
            task.startTask();
        }
    }

}
