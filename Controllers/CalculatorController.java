package com.example.demo.Controllers;


import com.example.demo.Services.AppServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorController {

    private final AppServices appServices;

    public CalculatorController(AppServices appServices) {
        this.appServices = appServices;
    }

    @GetMapping("/add")
    public long add(long a, long b){
        return appServices.addition(a,b);
    }

    @GetMapping("/sub")
    public long sub(long a, long b){
        return appServices.sub(a,b);
    }
}
