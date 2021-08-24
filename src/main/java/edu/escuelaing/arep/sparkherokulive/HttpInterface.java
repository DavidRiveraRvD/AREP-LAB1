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

public class HttpInterface {
    public JSONObject getIntraDay(String identificadorDeBolsa);
    public JSONObject getDay(String idBolsa);
    public JSONObject getWeek(String idBolsa);
    public JSONObject getMonth(String idDeBolsa);
    public JSONObject chooseFunction(String function, String idBolsa);
}
