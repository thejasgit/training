package com.test.deploy;

import static spark.Spark.*;



import spark.*;

 
public class HelloSpark {
     public void main() {
    	get("/hello", (req, res) -> {
            return "Hello Spark MVC Framework!";
        });
    	
    	get("/demo", (req, res) -> {
            return "sffd!";
        });


        get("/stopServer", (req, res) ->{
        	System.out.println("Stoping Server");
            Spark.stop();
            return "server Shutdown";
        });
    }
}