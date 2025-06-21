package com.tasks.taskmanager.Mappers;

import com.tasks.taskmanager.domain.dto.TaskListdto;
import com.tasks.taskmanager.domain.entities.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListdto taskListDto);
    TaskListdto toDto(TaskList taskList);
}
