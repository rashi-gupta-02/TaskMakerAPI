package com.example.project.controller;

import com.example.project.model.Task;
import com.example.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

        @Autowired
        private TaskService taskService;

        @GetMapping
        public List<Task> getAllTasks() {
            return taskService.getAllTasks();
        }

        @GetMapping("/{id}")
        public Task getTaskById(@PathVariable Long id) {
            return taskService.getTaskById(id);
        }

        @PostMapping
        public Task createTask(@RequestBody Task task) {
            return taskService.createTask(task);
        }

        @PutMapping("/{id}")
        public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
            return taskService.updateTask(id, task);
        }

        @DeleteMapping("/{id}")
        public void deleteTask(@PathVariable Long id) {
            taskService.deleteTask(id);
        }

        @GetMapping("/status/{completed}")
        public List<Task> getTasksByStatus(@PathVariable boolean completed) {
            return taskService.getTasksByStatus(completed);
        }

}
