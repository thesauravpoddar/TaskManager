package com.tasks.taskmanager.Services.impl;

import com.tasks.taskmanager.Services.TaskListService;
import com.tasks.taskmanager.domain.entities.TaskList;
import com.tasks.taskmanager.repostries.TaskListRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public TaskList createTaskList(TaskList taskList) {
        if(null != taskList.getId()) {
            throw new IllegalArgumentException("Bruhhhh Task list already has an ID!!!");
        }
        if(null == taskList.getTitle() || taskList.getTitle().isBlank()) {
            throw new IllegalArgumentException("Bruhhhh🥱Task list title must be present!");
        }

        LocalDateTime now = LocalDateTime.now();
        return taskListRepo.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
        ));
    }

    @Override
    public Optional<TaskList> getTaskList(UUID id) {
        return taskListRepo.findById(id);
    }

    @Override
    public TaskList updateTaskList(UUID taskListId, TaskList taskList) {
        if(null == taskList.getId()) {
            throw new IllegalArgumentException("Task lIst must have an id");
        }
        if(!Objects.equals(taskList.getId() , taskListId)) {
            throw new IllegalArgumentException("attempting to change task list id , this is not goodddddd");
        }
       TaskList existingTaskList = taskListRepo.findById(taskListId).orElseThrow(() ->
                new IllegalArgumentException("Task lIst not found"));

        existingTaskList.setTitle(taskList.getTitle());
        existingTaskList.setDescription(taskList.getDescription());
        existingTaskList.setUpdated(LocalDateTime.now());
        return taskListRepo.save(existingTaskList);

    }

    @Override
    public void deleteTaskList(UUID taskListId) {
        taskListRepo.deleteById(taskListId);
    }
}
