package com.tasks.taskmanager.Mappers.impl;

import com.tasks.taskmanager.Mappers.TaskListMapper;
import com.tasks.taskmanager.Mappers.TaskMapper;
import com.tasks.taskmanager.domain.dto.TaskListDto;
import com.tasks.taskmanager.domain.entities.Task;
import com.tasks.taskmanager.domain.entities.TaskList;
import com.tasks.taskmanager.domain.entities.taskStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperimpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperimpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }


    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
             taskListDto.id(),
             taskListDto.title(),
             taskListDto.description(),
                Optional.ofNullable(taskListDto.tasks())
                        .map(tasks -> tasks.stream()
                        .map(taskMapper::fromDto)
                        .toList()
                ).orElse(null) ,
                null,
                null
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                // now ew have to manage count
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size)
                        .orElse(0) ,
                CalculateTaskListProgram(taskList.getTasks()) ,
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks ->
                                tasks.stream().map(taskMapper::toDto).toList())
                        .orElse(null)

        );
    }
    private Double CalculateTaskListProgram(List<Task> tasks) {
        if(null == tasks) {
            return null;
        }
       long closedTaskcount =  tasks.stream().filter(task -> taskStatus.CLOSE == task.getStatus()).count();
        return (double)closedTaskcount / tasks.size();
    }


}
