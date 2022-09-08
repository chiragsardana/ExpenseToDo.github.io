package com.sbk.MicroserviceBasedApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbk.MicroserviceBasedApplication.model.ToDoExpense;
import com.sbk.MicroserviceBasedApplication.service.ToDoExpenseService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/ToDoExpense")
public class ToDoExpenseController {
    private ToDoExpenseService toDoExpenseService;

    public ToDoExpenseController(ToDoExpenseService toDoExpenseService) {
        this.toDoExpenseService = toDoExpenseService;
    }
    @GetMapping()
    @ResponseBody
    public String homePage(){
        return "<h1><center>Welcome to ToDoExpense By Chirag19CSU071</center></h1>";
    }
    @PostMapping("/save")
    public ResponseEntity<ToDoExpense> saveExpense(@RequestBody ToDoExpense toDoExpense){
        return new ResponseEntity<ToDoExpense>(toDoExpenseService.save(toDoExpense), HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<ToDoExpense>> get(){
        return new ResponseEntity<List<ToDoExpense>>(toDoExpenseService.getAllExpenses(), HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ToDoExpense> getExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<ToDoExpense>(toDoExpenseService.getToDoExpenseById(id), HttpStatus.OK);
    }
    @GetMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Boolean>(toDoExpenseService.deleteToDoExpenseById(id), HttpStatus.OK);
    }
    @PostMapping("/updateById/{id}")
    public ResponseEntity<ToDoExpense> updateExpenseById(@PathVariable("id") Long id, @RequestBody ToDoExpense toDoExpense){
        return new ResponseEntity<ToDoExpense>(toDoExpenseService.updateToDoExpenseById(id, toDoExpense), HttpStatus.OK);
    }
}
