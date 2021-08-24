/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.escuelaing.arep.sparkherokulive;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Usuario
 */
public class HttpConnect implements HttpInterface{

    private static final String Standard_URL = "https://www.alphavantage.co/query?function=%s&symbol=%s&apikey=B94U975WONAHGDI1";
    private static final String IntraDay_URL = "https://www.alphavantage.co/query?function=%s&symbol=%s&interval=5min&apikey=B94U975WONAHGDI1";
    /**
     * @param 
     * @return 
     */
    @Override
    public JSONObject getIntraDay(String idBolsa) {
        try {
            return new JSONObject(IOUtils.toString(new URL(String.format(IntraDay_URL,"TIME_SERIES_INTRADAY",idBolsa)),Charset.forName("UTF-8")));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject("{}");
    }

    /**
     * @param
     * @return
     */
    @Override
    public JSONObject getDay(String idBolsa) {
       try {
            return new JSONObject(IOUtils.toString(new URL(String.format(Standard_URL,"TIME_SERIES_DAILY",idBolsa)),Charset.forName("UTF-8")));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject("{}");
    }

    /**
     * @param 
     * @return 
     */
    @Override
    public JSONObject getWeek(String idBolsa) {
        try {
            return new JSONObject(IOUtils.toString(new URL(String.format(Standard_URL,"TIME_SERIES_WEEKLY",idBolsa)),Charset.forName("UTF-8")));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject("{}");
    }

    @Override
    public JSONObject getMonth(String idBolsa) {
        try {
            return new JSONObject(IOUtils.toString(new URL(String.format(Standard_URL,"TIME_SERIES_MONTHLY",idBolsa)),Charset.forName("UTF-8")));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject("{}");
    }

    @Override
    public JSONObject chooseFunction(String funtion, String idBolsa){
        JSONObject value= null;
        switch(funtion){
            case "intraDay":
                value= getIntraDay(idBolsa);
                break;
            case "day":
                value= getDay(idBolsa);
                break;
            case "week":
                value= getWeek(Bolsa);
                break;
            case "month":
                value= getMonth(idBolsa);
                break;
        }
        return value;
    }

} 