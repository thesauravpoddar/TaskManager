package com.tasks.taskmanager.Mappers.impl;

import com.tasks.taskmanager.Mappers.TaskMapper;
import com.tasks.taskmanager.domain.dto.TaskDto;
import com.tasks.taskmanager.domain.entities.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperimpl implements TaskMapper {
    @Override
    public Task fromDto(TaskDto taskDto) {
        return new Task(
                taskDto.id(),
                taskDto.title(),
                taskDto.description(),
                taskDto.dueDate(),
                taskDto.status(),
                taskDto.priority(),
                null,
                null,
                null
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
             task.getId(),
             task.getTitle(),
             task.getDescription(),
             task.getDueDate(),
             task.getPriority(),
             task.getStatus()
        );
    }
}
