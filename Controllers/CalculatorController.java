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
    public Double add(@RequestParam Double a,@RequestParam Double b){
        return appServices.addition(a,b);
    }

    @GetMapping("/sub")
    public Double sub(@RequestParam Double a,@RequestParam Double b){
        return appServices.sub(a,b);
    }

    @GetMapping("/memory")
    public Double memory(){
        return appServices.lastResult();
    }

    //clear list
    @PostMapping("/memory/clear")
    public void clear(){
        appServices.clear();
    }
}