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
public class ServiceInstance {
    private static  ServiceInstance _instance  = new ServiceInstance();
    private HttpStockService serviceAlpha;
    private HttpStockService serviceIEX;

    private ServiceInstance(){

        serviceAlpha = new AlphaHttpStockService();
        serviceIEX = new IEXHttpStockService();
    }

    public static ServiceInstance getInstance(){
        return _instance;
    }

    public HttpStockService getServiceAlpha() {
        return serviceAlpha;
    }
    public HttpStockService getServiceIEX() {
        return serviceIEX;
    }
}