package com.izakharchenia.unistrings.multithreading;

import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TasksManager {

    @Getter
    private HashMap<Integer, List<Task>> currentTasks = new HashMap<>();

    private List<Integer> taskIds = new LinkedList<>();
    private Integer maxTaskIdVal = 0;

    public synchronized void addTask(Integer userId, String str, int min, int max, int quantity) {
        if (taskIds.isEmpty()) {
            taskIds.add(1);
            maxTaskIdVal++;
        }
        else {
            taskIds.add(maxTaskIdVal+1);
            maxTaskIdVal++;
        }
        Task task = new Task(userId, maxTaskIdVal, str, min, max, quantity);
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

    public synchronized void deleteTask(Integer taskId, Integer userId) {
        currentTasks.get(userId).forEach(el->{
            if (el.getTaskId().equals(taskId)) currentTasks.get(userId).remove(el);
        });
    }

    public synchronized Optional<Task> getTask(Integer taskId, Integer userId) {
        for (int i = 0; i < currentTasks.get(userId).size(); i++) {
            if (currentTasks.get(userId).get(i).getTaskId().equals(taskId)) {
                return Optional.of(currentTasks.get(userId).get(i));
            }
        }
        return Optional.empty();
    }

}
