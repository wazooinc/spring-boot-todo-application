package com.wazooinc.springboottodoapplication.repositories;

import com.wazooinc.springboottodoapplication.models.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {  
}
