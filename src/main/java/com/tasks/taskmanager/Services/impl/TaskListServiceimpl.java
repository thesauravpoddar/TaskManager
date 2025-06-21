package com.tasks.taskmanager.Services.impl;

import com.tasks.taskmanager.Services.TaskListService;
import com.tasks.taskmanager.domain.entities.TaskList;
import com.tasks.taskmanager.repostries.TaskListRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListServiceimpl implements TaskListService {

   private final TaskListRepo taskListRepo;

    public TaskListServiceimpl(TaskListRepo taskListRepo) {
        this.taskListRepo = taskListRepo;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepo.findAll();
    }
}
