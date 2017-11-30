package com.dinya.peter.entity;

import com.dinya.peter.utils.ParseJson;
import com.dinya.peter.utils.WebUtils;
import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.Purchase;
import com.google.gson.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class IntegrationImpl implements Integration {

    private static Logger LOGGER = LogManager.getLogger(IntegrationImpl.class);

    private String developer;

    public Purchase buy(String itemId) {
        LOGGER.info("Purchasing item: " + itemId);
        Purchase purchase = null;
        try {
            final String jsonResponse = WebUtils.doBuy(developer, itemId);
            purchase = ParseJson.getInstance().get(jsonResponse,PurchaseImpl.class);
            if (purchase != null){
                LOGGER.info("Item has been successfully purchased: " + purchase.getItemId());
            }
        } catch (UnirestException|JsonSyntaxException e) {
            LOGGER.error("Error occurred while purchasing the item: " + itemId, e);
        }
        return purchase;
    }

    public List<Purchase> getPurchases() {
        LOGGER.info("Requesting all purchases...");
        List<Purchase> purchases = null;
        try{
            final String jsonResponse = WebUtils.getPurchases(developer);

            final PurchaseList purchaseList = ParseJson.getInstance().get(jsonResponse, PurchaseList.class);
            purchases = purchaseList.getPurchases();
            LOGGER.info("Prior purchases have been successfully requested." );
        }catch (UnirestException|JsonSyntaxException e){
            LOGGER.error("Error occurred while requesting all purchases." , e);
            purchases = new ArrayList<>();
        }
        return purchases;
    }

    public void consume(Purchase purchase) {
        LOGGER.info("Consuming purchase: " + purchase.getId());
        try {
            WebUtils.doConsume(developer, purchase.getId());
            LOGGER.info("Purchase successfully consumed: " + purchase.getId());
        } catch (UnirestException e) {
            LOGGER.error("Error occurred while consuming purchase: " + purchase.getId() , e);
        }
    }

    public IntegrationImpl(String developer) {
        this.developer = developer;
    }
}
