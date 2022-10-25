package com.izakharchenia.unistrings.dto.request;

import lombok.Data;

@Data
public class TaskDtoRequest {
    private final Integer userId;
    private final Integer taskId;
}
