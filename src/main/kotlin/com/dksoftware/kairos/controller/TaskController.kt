package com.dksoftware.kairos.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import com.dksoftware.kairos.service.TaskService
import com.dksoftware.kairos.model.Task

@RestController
@RequestMapping("/task")
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun getAllTasks(): ResponseEntity<List<Task>> { 
        val tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: Long): ResponseEntity<Task> {
        val task = taskService.getTaskById(id);
        return if (task.isPresent) {
            ResponseEntity.ok(task.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun saveTask(@RequestBody task: Task): ResponseEntity<Task> {
        val createdTask = taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long) {
        taskService.deleteTask(id)
    }  
}