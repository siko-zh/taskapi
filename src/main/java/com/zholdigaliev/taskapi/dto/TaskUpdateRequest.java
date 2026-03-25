package com.zholdigaliev.taskapi.dto;

import com.zholdigaliev.taskapi.entity.TaskPriority;
import com.zholdigaliev.taskapi.entity.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskUpdateRequest {
    String title;
    String description;
    TaskStatus taskStatus;
    TaskPriority taskPriority;
}
