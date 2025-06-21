package com.tasks.taskmanager.Mappers;

import com.tasks.taskmanager.domain.dto.TaskListdto;
import com.tasks.taskmanager.domain.entities.TaskList;
import org.springframework.stereotype.Component;

@Component
public interface TaskListMapper {
    TaskList fromDto(TaskListdto taskListDto);
    TaskListdto toDto(TaskList taskList);
}
