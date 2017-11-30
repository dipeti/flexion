package com.dinya.peter.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WebUtils {
    private static final Logger LOGGER = LogManager.getLogger(WebUtils.class);

    public synchronized static String doBuy(String developer, String itemId) throws UnirestException{
        String url = UriConst.buildBuyURL(developer, itemId);
        HttpResponse<JsonNode> response = doPost(url);
        return response.getBody().toString();
    }

    public static String  getPurchases(String developer) throws UnirestException {
        String url = UriConst.buildPurchasesURL(developer);
        HttpResponse<JsonNode> response = doGet(url);
        return response.getBody().toString();
    }

    public static void doConsume(String developer, String purchaseId) throws UnirestException {
        String url = UriConst.buildConsumeURL(developer, purchaseId);
        doPost(url);
    }

    private static HttpResponse<JsonNode> doPost(String url) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.post(url).asJson();
        return handleResponse(response);
    }



    private static HttpResponse<JsonNode> doGet(String url) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(url).asJson();
        return handleResponse(response);
    }

    private static HttpResponse<JsonNode> handleResponse(HttpResponse<JsonNode> response) throws UnirestException {
        int status = response.getStatus();
        if (status != 200){
            throw new UnirestException("Error! Status code: " + status);
        }
        LOGGER.debug(response.getBody().toString());
        return response;
    }



}
