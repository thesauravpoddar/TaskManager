package com.tasks.taskmanager.domain.dto;

import com.tasks.taskmanager.domain.entities.TaskPRIORITY;
import com.tasks.taskmanager.domain.entities.taskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

/// we created a java record becvause it provides a concise way to create an immutable data class with all-of-the boilerplate code
/// wec need so
public record TaskDto(
        UUID id,
        String title ,
        String description ,
        LocalDateTime dueDate,
        TaskPRIORITY priority ,
        taskStatus status
) {

}
