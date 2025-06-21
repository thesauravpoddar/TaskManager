package com.tasks.taskmanager.Services;

import com.tasks.taskmanager.domain.entities.TaskList;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TaskListService {
    List<TaskList> listTaskLists();
}
