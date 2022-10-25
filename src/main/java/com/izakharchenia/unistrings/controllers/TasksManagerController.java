package com.izakharchenia.unistrings.controllers;

import com.izakharchenia.unistrings.dto.request.TaskAddDtoRequest;
import com.izakharchenia.unistrings.dto.request.TaskDtoRequest;
import com.izakharchenia.unistrings.dto.response.TaskDataDtoResponse;
import com.izakharchenia.unistrings.dto.response.TaskStatusDtoResponse;
import com.izakharchenia.unistrings.service.TasksManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TasksManagerController {
    private final TasksManagerService service;

    @PostMapping("/add")
    public void addTask(@RequestBody TaskAddDtoRequest taskAddDtoRequest) {
        service.addTask(taskAddDtoRequest);
    }

    @GetMapping("/get-status")
    public TaskStatusDtoResponse getStatus(@RequestBody TaskDtoRequest taskDtoRequest) {
        return service.getStatus(taskDtoRequest);
    }

    @GetMapping("/get-data")
    public TaskDataDtoResponse getData(@RequestBody TaskDtoRequest taskDtoRequest) {
        return service.getData(taskDtoRequest);
    }
}
