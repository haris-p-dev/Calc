package com.example.demo.Controllers;

import com.example.demo.Services.AppServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class CalculatorController {

    private final AppServices appServices;

    public CalculatorController(AppServices appServices) {
        this.appServices = appServices;
    }

    @GetMapping("/add")
    public double add(@RequestParam double a,@RequestParam double b){
        return appServices.addition(a,b);
    }

    @GetMapping("/sub")
    public double sub(@RequestParam double a,@RequestParam double b){
        return appServices.sub(a,b);
    }

    @GetMapping("/memory")
    public double memory(){
        return appServices.lastResult();
    }

    //clear list
    @PostMapping("/memory/clear")
    public void clear(){
        appServices.clear();
        System.out.println("Memory cleared");  //message will be shown in terminal
    }
}
