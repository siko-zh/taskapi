package com.zholdigaliev.taskapi.controller;

import com.zholdigaliev.taskapi.dto.TaskCreateRequest;
import com.zholdigaliev.taskapi.dto.TaskResponse;
import com.zholdigaliev.taskapi.dto.TaskUpdateRequest;
import com.zholdigaliev.taskapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTask() {
        List<TaskResponse> response = taskService.getAllTasks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getById(@PathVariable Long id) {
        TaskResponse response = taskService.getById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskCreateRequest taskRequest) {
        TaskResponse response = taskService.createTask(taskRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id, @RequestBody TaskUpdateRequest taskRequest) {
        TaskResponse response = taskService.updateTask(id, taskRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
