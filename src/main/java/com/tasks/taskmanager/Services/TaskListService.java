package com.tasks.taskmanager.Services;

import com.tasks.taskmanager.domain.entities.TaskList;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public interface TaskListService {
    List<TaskList> listTaskLists();
    TaskList createTaskList(TaskList taskList);
    Optional<TaskList> getTaskList(UUID id);
    TaskList UpdateTaskList(UUID taskListId , TaskList taskList);
}
