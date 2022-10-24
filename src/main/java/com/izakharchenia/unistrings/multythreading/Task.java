package com.izakharchenia.unistrings.multythreading;

import lombok.Getter;

class Task {
    @Getter
    private Integer userId;

    @Getter
    private TaskStatus status;

    void startTask() {
        status = TaskStatus.IN_PROGRESS;
    }
}
