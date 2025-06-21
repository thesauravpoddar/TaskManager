package com.tasks.taskmanager.repostries;

import com.tasks.taskmanager.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepo extends JpaRepository<Task , UUID> {
    List<Task> findByTaskListId(UUID taskListID);
    Optional<Task> findByTaskListIdAndId(UUID taskListId , UUID id);
}
