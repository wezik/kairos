package com.dksoftware.kairos.repo

import org.springframework.data.repository.CrudRepository
import com.dksoftware.kairos.model.Task

interface TaskRepository : CrudRepository<Task, Long>