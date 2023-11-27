package com.dksoftware.kairos.service

import org.springframework.stereotype.Service
import com.dksoftware.kairos.repo.TaskRepository
import com.dksoftware.kairos.model.Task
import java.util.Optional

@Service
class TaskService(private val taskRepo: TaskRepository) {
    
    fun getAllTasks(): List<Task> {
        return taskRepo.findAll().toList();
    }

    fun getTaskById(id: Long): Optional<Task> {
        return taskRepo.findById(id);
    }

    fun saveTask(task: Task): Task {
        return taskRepo.save(task);
    }

    fun deleteTask(id: Long) {
        taskRepo.deleteById(id);
    }
}