package com.example.demo.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.w3c.dom.ranges.Range;

import java.util.ArrayList;

@Service
public class AppServices {

    private ArrayList<Long> list= new ArrayList<>();

//    //give value in index 0
//    public void setListElement(long x) {
//        list.set(0,x);
//    }

    //retrieve the last element
    public long lastResult(){
        return list.get(0);
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
        else
        list.add(0,a/b);
        return a/b;
    }

    public void clear(){
        list.set(0,null);
    }

}
