package com.izakharchenia.unistrings;

import com.izakharchenia.unistrings.multithreading.TasksManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class UnistringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnistringsApplication.class, args);
		System.out.println("kekkekekekekekek");
		UnistringsApplication app = new UnistringsApplication();
		TasksManager tasksManager = app.getTasksManager();
		tasksManager.addTask(123, "qwer", 1, 2, 4);
		tasksManager.addTask(123, "qwer", 1, 2, 4);
		tasksManager.addTask(123, "qwer", 1, 2, 100);
		tasksManager.addTask(123, "qwer", 1, 2, 5);
		tasksManager.addTask(123, "qwer", 1, 2, 6);
		tasksManager.addTask(123, "qwer", 1, 2, 4);
		tasksManager.addTask(123, "qwer", 1, 2, 4);
		tasksManager.addTask(123, "qwer", 1, 2, 4);
		tasksManager.addTask(123, "qwer", 1, 2, 4);
		tasksManager.addTask(223, "qwer", 1, 2, 4);
	}

	@Bean(name = "tasksManager")
	public TasksManager getTasksManager() {
		return new TasksManager();
	}

}
