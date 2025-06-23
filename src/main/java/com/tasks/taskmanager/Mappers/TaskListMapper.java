package com.tasks.taskmanager.Mappers;

import com.tasks.taskmanager.domain.dto.TaskListDto;
import com.tasks.taskmanager.domain.entities.TaskList;


public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
