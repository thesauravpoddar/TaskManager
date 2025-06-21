package com.tasks.taskmanager.Mappers;

import com.tasks.taskmanager.domain.dto.TaskDto;
import com.tasks.taskmanager.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);
}
