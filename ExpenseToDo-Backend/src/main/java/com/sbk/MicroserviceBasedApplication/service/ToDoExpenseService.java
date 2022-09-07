package com.sbk.MicroserviceBasedApplication.service;

import java.util.List;

import com.sbk.MicroserviceBasedApplication.model.ToDoExpense;

public interface ToDoExpenseService {
    public ToDoExpense save(ToDoExpense toDoExpense);
    public List<ToDoExpense> getAllExpenses();
    public ToDoExpense getToDoExpenseById(long id);
}
