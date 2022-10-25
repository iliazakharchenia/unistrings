package com.izakharchenia.unistrings.dto.request;

import lombok.Data;

@Data
public class TaskAddDtoRequest {
    private final Integer userId;
    private final String str;
    private final Integer min;
    private final Integer max;
    private final Integer quantity;
}
