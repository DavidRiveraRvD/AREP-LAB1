/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
package edu.escuelaing.arep.sparkherokulive;

import org.json.JSONObject;

public class Cache {
    public boolean contais(String key);
    public JSONObject getValue(String key);
    public void addValue(String key, JSONObject newValue);
    public void deleteValue(String key);
    public void updateValue(String key, JSONObject newValue);


}
