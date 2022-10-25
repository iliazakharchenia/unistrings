package com.izakharchenia.unistrings;

import com.izakharchenia.unistrings.multithreading.TaskStatus;
import com.izakharchenia.unistrings.multithreading.TasksManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskManagerTests {

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
    void taskManagerShouldReturnCorrectTaskStatus() {
        assert tasksManager.getTask(1, 123).get().getStatus()==TaskStatus.COMPLETED;
    }

    @Test
    void taskManagerShouldReturnDataWithCorrectSizeOfSet() {
        assert tasksManager.getTask(1, 123).get().getResultSet().size()==4;
    }

    @BeforeEach
    void addTask() {
        tasksManager.addTask(123, "qwer", 1, 2, 4);
    }

}
