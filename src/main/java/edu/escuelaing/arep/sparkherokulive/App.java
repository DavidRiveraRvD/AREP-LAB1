package edu.escuelaing.arep.sparkherokulive;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import java.io.IOException;
import org.json.JSONObject;

public class App {
    /**
     * This main method uses SparkWeb static methods and lambda functions to
     * create a simple Hello World web app. It maps the lambda function to the
     * /hello relative URL.
     */
    public static void main(String[] args) {
        staticFiles.location("/public");
        port(getPort());
        options("/*",
        (request, response) -> {

            String accessControlRequestHeaders = request
                    .headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers",
                        accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request
                    .headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods",
                        accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        get("/results", (req, res) -> resultsPage(req, res));
        get("/facade", (req,res) -> facadePage(req, res));
    }

    /**
     * Get the JSON object of the solicited values
     * @param req
     * @param res
     * @return
     * @throws IOException
     */
    private static JSONObject facadePage(Request req, Response res) throws IOException {
        res.type("application/json");
        String funcion= req.queryParams("function");
        String empresa= req.queryParams("empresa");
        String key= funcion + empresa;
        if(cache.contais(key)){
            return cache.getValue(key);
        }else{
            JSONObject currentRequest= httpConectionInterface.chooseFunction(funcion,empresa);
            cache.addValue(key, currentRequest);
            return currentRequest;
        }
    }


    private static String resultsPage(Request req, Response res) {
        return req.queryParams("firstname") + " " +
                req.queryParams("lastname");
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
