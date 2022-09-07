package com.sbk.MicroserviceBasedApplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sbk.MicroserviceBasedApplication.model.ToDoExpense;

public interface ToDoExpenseRepository extends JpaRepository<ToDoExpense, Long>{
    
}
