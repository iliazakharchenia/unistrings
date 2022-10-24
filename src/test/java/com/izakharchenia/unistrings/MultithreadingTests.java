package com.izakharchenia.unistrings;

import com.izakharchenia.unistrings.multithreading.TasksManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MultithreadingTests {

    @Autowired
    private TasksManager tasksManager;

    @Test
    void taskManagerShouldCorrectAddingTasks() {
        tasksManager.addTask(123, "qwer", 1, 2, 4);
        tasksManager.addTask(123, "qwer", 1, 2, 4);
        tasksManager.addTask(123, "qwer", 1, 2, 100);
        tasksManager.addTask(123, "qwer", 1, 2, 4);
        tasksManager.addTask(123, "qwer", 1, 2, 4);
        tasksManager.addTask(123, "qwer", 1, 2, 4);
        tasksManager.addTask(123, "qwer", 1, 2, 4);
        tasksManager.addTask(123, "qwer", 1, 2, 4);
        tasksManager.addTask(123, "qwer", 1, 2, 4);
        tasksManager.addTask(223, "qwer", 1, 2, 4);
    }

    @Test
    void taskShouldExecutingTaskThreadCorrect() {
        //assert tasksManager.getCurrentTasks().size()==1;
    }

}
