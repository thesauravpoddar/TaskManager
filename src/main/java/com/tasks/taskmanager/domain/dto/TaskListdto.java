package com.tasks.taskmanager.domain.dto;

import java.util.List;
import java.util.UUID;

public record TaskListdto(
        UUID id,
        String title ,
        String description ,
        Integer count , //count of task in our task list
        Double progress,
        List<TaskDto> tasks
//        LocalDateTime dueDate,
//        TaskPRIORITY priority ,
//        taskStatus status
) {

}
