package com.example.demo.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Service
public class AppServices {

    private ArrayList<Long> list= new ArrayList<>();

    //retrieve the last element
    public long lastResult(){
        if(list.isEmpty()){
            return 000000000000000;   //only solution I thought
        }
        else return list.get(0);
    }

    //addition logic
    public long addition(long a, long b){
        list.add(0,a+b);
        return a+b;
    }

    //sub logic
    public long sub(long a, long b){
        if(a==0 && b==0) {
            throw new ArithmeticException("Division with a=0 and b=0 is undefined.");
        }
        else if(b==0){
               throw new ArithmeticException("Cannot divide by zero.");
            }
        else list.add(0,a/b);
        return a/b;
    }

    //clear list
    public String clear(){
        if (list.isEmpty()) {
            return "List is already clear";
        }
        else{
            list.set(0,null);
            return  "List cleared" ;}
    }

}
