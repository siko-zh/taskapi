package com.zholdigaliev.taskapi.service;

import com.zholdigaliev.taskapi.dto.TaskCreateRequest;
import com.zholdigaliev.taskapi.dto.TaskResponse;
import com.zholdigaliev.taskapi.dto.TaskUpdateRequest;
import com.zholdigaliev.taskapi.entity.Task;
import com.zholdigaliev.taskapi.entity.TaskStatus;
import com.zholdigaliev.taskapi.exception.ResponseNotFoundException;
import com.zholdigaliev.taskapi.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<TaskResponse> getAllTasks() {
        List<TaskResponse> response = taskRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
        return response;
    }

    public TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getTitle(),
                task.getDescription(),
                task.getTaskStatus(),
                task.getTaskPriority()
        );
    }

    public TaskResponse getById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseNotFoundException("Задача не найден id: " + id));

        return toResponse(task);
    }

    public TaskResponse createTask(TaskCreateRequest taskRequest) {
        Task task = new Task(
                taskRequest.getTitle(),
                taskRequest.getDescription(),
                TaskStatus.NEW,
                taskRequest.getTaskPriority()
        );

        taskRepository.save(task);

        return toResponse(task);
    }

    public TaskResponse updateTask(Long id, TaskUpdateRequest taskRequest) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseNotFoundException("Задача не найден id: " + id));

        existingTask.setTitle(taskRequest.getTitle());
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setTaskStatus(taskRequest.getTaskStatus());
        existingTask.setTaskPriority(taskRequest.getTaskPriority());

        Task updatedTask = taskRepository.save(existingTask);

        return toResponse(updatedTask);
    }

    public void deleteTask(Long id) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseNotFoundException("Задача не найден id: " + id));

        taskRepository.delete(existingTask);
    }
}
