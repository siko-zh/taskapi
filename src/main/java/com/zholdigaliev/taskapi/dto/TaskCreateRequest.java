package com.zholdigaliev.taskapi.dto;

import com.zholdigaliev.taskapi.entity.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskCreateRequest {
    @NotBlank(message = "Название не должен быть пустым!")
    String title;
    @NotBlank(message = "Описание должен содержать строку!")
    String description;
    @NotNull(message = "Нужно задать приоритет задачи!")
    TaskPriority taskPriority;
}
