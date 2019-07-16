package com.tw.apistackbase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    List<Employees> result = new ArrayList<>();
    //Map<Integer,Employees> EmployeesMap = new HashMap<>();


    @GetMapping()
    public ResponseEntity getAll() {
        result.add(new Employees(1,"Danny",18,"male"));
        return ResponseEntity.ok().body(result);
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody Employees employees) {
        result.add(employees);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody Employees employees) {
        for(int i=0;i<result.size();i++) {
            if(result.get(i).getId()==id){
                result.get(i).setName(employees.getName());
                result.get(i).setAge(employees.getAge());
                result.get(i).setGender(employees.getGender());
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        for(int i=0;i<result.size();i++) {
            if(result.get(i).getId()==id){
               result.remove(result.get(i));
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }





}
