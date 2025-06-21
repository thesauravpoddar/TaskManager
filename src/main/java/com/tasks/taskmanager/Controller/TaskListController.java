package com.tasks.taskmanager.Controller;

import com.tasks.taskmanager.Mappers.TaskListMapper;
import com.tasks.taskmanager.Services.TaskListService;
import com.tasks.taskmanager.domain.dto.TaskListdto;
import com.tasks.taskmanager.domain.entities.TaskList;
import com.tasks.taskmanager.repostries.TaskListRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListdto> listTaskList() {
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }
}
