package com.sbk.MicroserviceBasedApplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbk.MicroserviceBasedApplication.exception.ResourceNotFoundException;
import com.sbk.MicroserviceBasedApplication.model.ToDoExpense;
import com.sbk.MicroserviceBasedApplication.repository.ToDoExpenseRepository;
import com.sbk.MicroserviceBasedApplication.service.ToDoExpenseService;

@Service
public class ToDoExpenseServiceImpl implements ToDoExpenseService{
    private ToDoExpenseRepository toDoExpenseRepository;
    public ToDoExpenseServiceImpl(ToDoExpenseRepository toDoExpenseRepository) {
        this.toDoExpenseRepository = toDoExpenseRepository;
    }

    @Override
    public ToDoExpense save(ToDoExpense toDoExpense) {
        // TODO Auto-generated method stub
        return toDoExpenseRepository.save(toDoExpense);
    }

    @Override
    public List<ToDoExpense> getAllExpenses() {
        // TODO Auto-generated method stub
        return toDoExpenseRepository.findAll();
    }

    @Override
    public ToDoExpense getToDoExpenseById(long id) {
        // TODO Auto-generated method stub
        return toDoExpenseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ToDoExpense", "Id", id));
    }

    @Override
    public ToDoExpense updateToDoExpenseById(long id ,ToDoExpense toDoExpense) {
        // TODO Auto-generated method stub
        toDoExpense.setId(id);
        return toDoExpenseRepository.save(toDoExpense);
    }

    @Override
    public Boolean deleteToDoExpenseById(long id) {
        // TODO Auto-generated method stub
        ToDoExpense toDoExpense = getToDoExpenseById(id);
        toDoExpenseRepository.delete(toDoExpense);
        if(toDoExpenseRepository.existsById(id)){
            return false;
        }
        return true;
    }
    
}
