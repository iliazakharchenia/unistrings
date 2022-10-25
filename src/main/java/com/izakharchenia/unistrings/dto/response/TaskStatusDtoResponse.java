package com.izakharchenia.unistrings.dto.response;

import com.izakharchenia.unistrings.multithreading.TaskStatus;
import lombok.Data;

@Data
public class TaskStatusDtoResponse {
    private final Integer userId;
    private final Integer taskId;
    private final TaskStatus status;
    private final String errorMessage;
}
