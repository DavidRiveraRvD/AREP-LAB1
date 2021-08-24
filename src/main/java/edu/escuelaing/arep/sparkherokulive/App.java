package edu.escuelaing.arep.sparkherokulive;

import com.sun.istack.internal.logging.Logger;
import static spark.Spark.*;
import spark.Request;
import spark.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
public class App{
    /**
     * This main method uses SparkWeb static methods and lambda functions to
     * create a simple Hello World web app. It maps the lambda function to the
     * /hello relative URL.
     */
    public static void main(String[] args) {
        // root is 'src/main/resources', so put files in 'src/main/resources/public'
        staticFiles.location("/public"); // Static files
        port(getPort());
        staticFiles.location( "/public" );
        get("/facadealpha", "application/json", (req, res) -> facadeAlpha(req,res));
        get("/facadeiex", "application/json", (req, res) -> facadeIEX(req,res));
    }
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    private static String  facadeAlpha(Request req,  Response res){
        String stock = req.queryParams("st");
        String time = req.queryParams("se");
        String key = stock+":"+time;
        String responseStr ="None";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getServiceAlpha();
        if ( (stock!=null && stock!="") &&(time!=null && time!="")) {
            stockService.setStock(stock);
            stockService.setPeriod(time);
        }
        try {
            responseStr =stockService.TimeSeries();
        } catch (IOException e) {
            Logger.getLogger(App.class.getName()).log( Level.SEVERE,null,e);
        }
        return responseStr;
    }
    /**
     * This method create a new URL to the IEXHttpStockService, create a new connection http ,
     * and return response from the external API
     * @param req web client request
     * @param res web server response
     * @return an html response with the info from the web client
     */
    private static String  facadeIEX(Request req, Response res){
        String stock = req.queryParams("st");
        String responseStr ="None";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getServiceIEX();
        if ( stock != null && stock != "" ) {
                stockService.setStock( stock );
            }
        try {
                responseStr = stockService.TimeSeries();
        } catch (IOException e) {
                Logger.getLogger( App.class.getName() ).log( Level.SEVERE, null, e );
        }
        return responseStr;
    }
}
