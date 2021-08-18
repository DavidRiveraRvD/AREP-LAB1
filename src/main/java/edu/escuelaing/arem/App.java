package edu.escuelaing.arem;

import static spark.Spark.*;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Spark Web app started ..." );
        get("/hello", (req, res) -> "Hello World");
        
    }
}
