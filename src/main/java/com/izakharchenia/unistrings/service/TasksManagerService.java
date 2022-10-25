package com.izakharchenia.unistrings.service;

import com.izakharchenia.unistrings.dto.request.TaskAddDtoRequest;
import com.izakharchenia.unistrings.dto.request.TaskDtoRequest;
import com.izakharchenia.unistrings.dto.response.TaskDataDtoResponse;
import com.izakharchenia.unistrings.dto.response.TaskStatusDtoResponse;
import com.izakharchenia.unistrings.multithreading.Task;
import com.izakharchenia.unistrings.multithreading.TaskStatus;
import com.izakharchenia.unistrings.multithreading.TasksManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class TasksManagerService {

    @Autowired
    private TasksManager tasksManager;

    public void addTask(TaskAddDtoRequest request) {
        tasksManager.addTask(request.getUserId(),request.getStr(),
                request.getMin(),request.getMax(),request.getQuantity());
    }

    public TaskStatusDtoResponse getStatus(TaskDtoRequest request) {
        Optional<Task> task = tasksManager.getTask(request.getTaskId(),request.getUserId());
        if (task.isEmpty()) return new TaskStatusDtoResponse(
                request.getUserId(),
                request.getTaskId(),
                TaskStatus.FAILED,
                "not found");
        else {
            if (task.get().getErrorMessage().toString().isEmpty())
                return new TaskStatusDtoResponse(
                    request.getUserId(),
                    request.getTaskId(),
                    task.get().getStatus(),
                    "");
                else return new TaskStatusDtoResponse(
                    request.getUserId(),
                    request.getTaskId(),
                    task.get().getStatus(),
                    task.get().getErrorMessage().toString());
        }
    }

    public TaskDataDtoResponse getData(TaskDtoRequest request) {
        Optional<Task> task = tasksManager.getTask(request.getTaskId(),request.getUserId());
        if (task.isEmpty()) return new TaskDataDtoResponse(
                request.getUserId(),
                request.getTaskId(),
                TaskStatus.FAILED,
                new HashSet<>(),
                "not found"
        );
        else {
            if (task.get().getErrorMessage().toString().isEmpty())
                return new TaskDataDtoResponse(
                        request.getUserId(),
                        request.getTaskId(),
                        task.get().getStatus(),
                        task.get().getResultSet(),
                        ""
                );
            else return new TaskDataDtoResponse(
                    request.getUserId(),
                    request.getTaskId(),
                    TaskStatus.FAILED,
                    task.get().getResultSet(),
                    task.get().getErrorMessage().toString()
            );
        }
    }

}
