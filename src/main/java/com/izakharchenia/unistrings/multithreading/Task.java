package com.izakharchenia.unistrings.multithreading;

import com.izakharchenia.unistrings.exceptions.ParametersDataException;
import com.izakharchenia.unistrings.generators.UnistringsGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class Task {

    @Getter
    private final Integer userId;

    private final String str;
    private final int min;
    private final int max;
    private final int quantity;

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
                run();
            }

            @Override
            public void run() {
                UnistringsGenerator generator = new UnistringsGenerator();
                try {
                    resultSet.addAll(generator.generate(str, min, max, quantity));
                    status = TaskStatus.COMPLETED;
                    //to delete
                    System.out.println("result set: "+resultSet);
                } catch (ParametersDataException pde) {
                    status = TaskStatus.FAILED;
                    generator.clearResultSet();
                }
            }
        };
        thread.start();
    }

}
