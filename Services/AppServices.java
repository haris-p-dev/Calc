package com.example.demo.Services;

import org.springframework.stereotype.Service;

@Service
public class AppServices {

    private double result=0;

     public AppServices(){}   //default constructor

    //retrieve the last element
    public double lastResult(){
            return result;   //minor bug. returns status 405
    }

    //addition logic
    public double addition(double a, double b){
        result=a+b;
        return result;
    }

    //sub logic
    public double sub(double a, double b){
        if(a==0 && b==0) {
            throw new ArithmeticException("Division with a=0 and b=0 is undefined.");
        }
        else if(b==0){
               throw new ArithmeticException("Cannot divide by zero.");
            }
        else result=a/b;
        return result;
    }

    //clear variable
    public void clear(){
        result = 0;
    }

}
