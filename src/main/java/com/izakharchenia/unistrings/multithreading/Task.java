package com.izakharchenia.unistrings.multithreading;

import com.izakharchenia.unistrings.exceptions.ParametersDataException;
import com.izakharchenia.unistrings.generators.UnistringsGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
public class Task {

    @Getter
    private final Integer userId;

    @Getter
    private final Integer taskId;
    private final String str;
    private final int min;
    private final int max;
    private final int quantity;

    @Getter
    private StringBuilder errorMessage = new StringBuilder();

    @Getter
    private TaskStatus status;

    @Getter
    private Set<String> resultSet = new HashSet<>();

    void startTask() {
        status = TaskStatus.IN_PROGRESS;
        startTaskThread();
    }

    private void startTaskThread() {
        Thread thread = new Thread() {
            @Override
            public synchronized void start() {
                super.start();
                //run();
            }

            @Override
            public void run() {
                UnistringsGenerator generator = new UnistringsGenerator();
                try {
                    resultSet = generator.generate(str, min, max, quantity);
                    Optional<String> optional = Optional.ofNullable(generator.getErrorMessage());
                    if (optional.isPresent()) {
                        status = TaskStatus.FAILED;
                        errorMessage.append(optional.get());
                    }
                    else status = TaskStatus.COMPLETED;
                } catch (ParametersDataException pde) {
                    status = TaskStatus.FAILED;
                    errorMessage.append(pde.getMessage());
                    generator.clearResultSet();
                }
            }
        };
        thread.start();
    }

}
