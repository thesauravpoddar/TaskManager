package com.tasks.taskmanager.Services;

import com.tasks.taskmanager.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> listTaskLists();
}
