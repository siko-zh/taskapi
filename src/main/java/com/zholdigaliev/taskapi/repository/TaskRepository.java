package com.zholdigaliev.taskapi.repository;

import com.zholdigaliev.taskapi.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
