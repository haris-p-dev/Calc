package com.example.demo.Services;

import org.springframework.stereotype.Service;

@Service
public class AppServices {

    private Double result=null;  //Important: variable must be used in wrapper class to accept null as value

     public AppServices(){}   //default constructor

    //retrieve the last element
    public Double lastResult(){
         return result;
    }

    //addition logic
    public Double addition(Double a, Double b){
        result=a+b;
        return result;
    }

    //sub logic
    public Double sub(Double a, Double b){
         result=a-b;
        return result;
    }

    //clear variable
    public void clear(){
        result = null;
    }

}
