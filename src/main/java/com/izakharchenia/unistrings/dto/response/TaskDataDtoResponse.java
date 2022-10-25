package com.izakharchenia.unistrings.dto.response;

import com.izakharchenia.unistrings.multithreading.TaskStatus;
import lombok.Data;

import java.util.Set;

@Data
public class TaskDataDtoResponse {
    private final Integer userId;
    private final Integer taskId;
    private final TaskStatus status;
    private final Set<String> resultSet;
    private final String errorMessage;
}
