package com.izakharchenia.unistrings;

import com.izakharchenia.unistrings.multithreading.TasksManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UnistringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnistringsApplication.class, args);
//		UnistringsApplication app = new UnistringsApplication();
//		TasksManager tasksManager = app.getTasksManager();
//		tasksManager.addTask(123, "qwer", 1, 2, 4);
//		tasksManager.addTask(123, "qwer", 1, 2, 4);
//		tasksManager.addTask(123, "qwertyuiopasd", 1, 10, 1000);
//		System.out.println(tasksManager.getCurrentTasks().get(123).get(0).getStatus());
//		tasksManager.addTask(123, "qwer", 1, 2, 4);
//		tasksManager.addTask(123, "qwertyuiopasd", 1, 10, 1000);
//		tasksManager.addTask(123, "qwertyuiopass", 1, 10, 100);
//		tasksManager.addTask(123, "qwert", 1, 2, 4);
//		tasksManager.addTask(123, "qwer", 1, 2, 4);
//		tasksManager.addTask(123, "qwer", 1, 2, 4);
//		System.out.println(tasksManager.getCurrentTasks().get(123).get(2).getStatus());
//		tasksManager.addTask(223, "qwer", 1, 2, 4);
	}

	@Bean(name = "tasksManager")
	public TasksManager getTasksManager() {
		return new TasksManager();
	}

}
