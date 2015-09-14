package com.hczhang.hummingbird.demo.basic;

/**
 * Created by steven on 7/15/15.
 */
public class HelloWorld {
    private String message;

    public void setMessage(String message){
        this.message  = message;
    }

    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
}
