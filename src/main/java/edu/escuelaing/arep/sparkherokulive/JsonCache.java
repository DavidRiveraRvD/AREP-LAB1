package edu.escuelaing.arep.sparkherokulive;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
import java.util.HashMap;
import org.json.JSONObject;

public class JsonCache implements Cache{
    private HashMap<String,JSONObject> requests= new HashMap<String,JSONObject>();

    @Override
    public boolean contais(String key) {
        return requests.containsKey(key);
    }

    @Override
    public JSONObject getValue(String key) {
        return (JSONObject) requests.get(key);
    }

    @Override
    public void addValue(String key, JSONObject newValue) {
        if(!requests.containsKey(key)){
            requests.put(key, newValue);
        }
    }

    @Override
    public void deleteValue(String key) {
        if(requests.containsKey(key)){
            requests.remove(key);
        }
    }

    @Override
    public void updateValue(String key, JSONObject newValue) {
        if(requests.containsKey(key)){
            requests.replace(key, newValue);
        }
    }


    public HashMap<String,JSONObject> getRequests() {
        return this.requests;
    }

   
    public void setRequests(HashMap<String,JSONObject> requests) {
        this.requests = requests;
    }
}
