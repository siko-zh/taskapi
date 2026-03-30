package com.zholdigaliev.taskapi.dto;

import com.zholdigaliev.taskapi.entity.TaskPriority;
import com.zholdigaliev.taskapi.entity.TaskStatus;
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
public class TaskUpdateRequest {
    @NotBlank(message = "Название не должен быть пустым!")
    String title;
    @NotBlank(message = "Описание должен содержать строку!")
    String description;
    @NotNull(message = "Нужно указать статус задачи!")
    TaskStatus taskStatus;
    @NotNull(message = "Нужно задать приоритет задачи!")
    TaskPriority taskPriority;
}
