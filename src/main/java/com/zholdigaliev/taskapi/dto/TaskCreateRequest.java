package com.zholdigaliev.taskapi.dto;

import com.zholdigaliev.taskapi.entity.TaskPriority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskCreateRequest {
    String title;
    String description;
    TaskPriority taskPriority;
}
