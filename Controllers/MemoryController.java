package com.example.demo.Controllers;


import com.example.demo.Services.AppServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/calc/memory")
public class MemoryController {

    private AppServices appServices;

    //error here
    @GetMapping("/calc/memory")
    public long memory(){
        return appServices.lastResult();
    }


    //error here
    //clear list
    @PostMapping("/clear")
    public long clear(){
       appServices.clear();
        return appServices.lastResult();
    }








}
