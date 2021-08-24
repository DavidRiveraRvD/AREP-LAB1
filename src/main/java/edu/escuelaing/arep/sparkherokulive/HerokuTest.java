/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.escuelaing.arep.sparkherokulive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class HerokuTest {
    private static HashMap<URL, String> cache = new HashMap <URL, String> ();
    /**
     * @param nUrl
     * @return
     * @throws IOException
     */
    public static String testHerokuConnection(String nUrl) throws IOException {
        String responseStr= "";
        String inputLine = "None";
        URL obj = new URL(nUrl);
        if(!(cache.containsKey(obj))) {
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader( new InputStreamReader( con.getInputStream() ) );
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append( inputLine );
            }
            responseStr= response.toString();
            cache.put(obj,responseStr);
        }else{
            responseStr=cache.get(obj);
        }
        return responseStr;
    }
}
