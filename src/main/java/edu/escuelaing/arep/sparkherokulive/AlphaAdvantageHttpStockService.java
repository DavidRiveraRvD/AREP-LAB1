/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.sparkherokulive;

/**
 *
 * @author Usuario
 */
public class AlphaAdvantageHttpStockService extends HttpStockService{
    String stock = "fb";
    String fun = "TIME_SERIES_DAILY";

    @Override
    public String getURL(){
        return "https://www.alphavantage.co/query?function="+fun+"&symbol="fb+"&apikey=B94U975WONAHGDI1";
    }
    @Override
    public void setStock(String stock){
        this.stock = stock;
    }

    @Override
    public void setPeriod(String time) {
        this.fun= time;
    }
}
