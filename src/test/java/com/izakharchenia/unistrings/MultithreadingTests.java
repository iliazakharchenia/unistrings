package com.izakharchenia.unistrings;

import com.izakharchenia.unistrings.multithreading.TaskStatus;
import com.izakharchenia.unistrings.multithreading.TasksManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MultithreadingTests {

    @Autowired
    private TasksManager tasksManager;

    @Test
    void taskManagerShouldCorrectAddTasks() {
		tasksManager.addTask(123, "qwer", 1, 2, 4);
		tasksManager.addTask(123, "qwer", 1, 2, 4);
		tasksManager.addTask(123, "qwertyuiopasd", 1, 10, 1000);
		tasksManager.addTask(123, "qwer", 1, 2, 4);
		tasksManager.addTask(123, "qwertyuiopasd", 1, 10, 1000);
		tasksManager.addTask(123, "qwertyuiopass", 1, 10, 100);
		tasksManager.addTask(123, "qwert", 1, 2, 4);
		tasksManager.addTask(123, "qwer", 1, 2, 4);
		tasksManager.addTask(123, "qwer", 1, 2, 4);
		tasksManager.addTask(223, "qwer", 1, 2, 4);
    }

    @Test
    void taskShouldReturnCorrectTaskStatus() {
        tasksManager.addTask(123, "qwer", 1, 2, 4);
        assert tasksManager.getCurrentTasks().get(123).get(0).getStatus()==TaskStatus.IN_PROGRESS;
    }

}
