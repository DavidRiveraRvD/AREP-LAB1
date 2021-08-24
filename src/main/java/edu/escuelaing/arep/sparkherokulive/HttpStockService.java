/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.sparkherokulive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;


public abstract class HttpStockService {

    private static final String USER_AGENT = "Mozilla/5.0";
    private HashMap<URL, String> cache = new HashMap <URL, String> ();

    public  String getStockInfo() throws IOException {
    String responseStr = "None";
    URL obj = new URL(getURL());
    if(!(cache.containskey(obj))){ 
        String responseStr = "none";
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            responseStr = response.toString();
            // print result
            System.out.println(responseSrt);

        } else {
            System.out.println("GET request not worked");
        }
        System.out.println( "GET DONE" );
        cache.put(obj,str);
    }else{
        return cache.get(obj)        
    }
    return responseStr;
    
    }   
    public abstract String getURL();

    public abstract void setPeriod(String time)

    public abstract void setStock(String stock);
} 