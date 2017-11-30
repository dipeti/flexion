package com.dinya.peter.utils;


public class UriConst {
    private static final String DEVELOPER_WILDCARD = "{developerId}";
    private static final String ITEM_WILDCARD = "{itemId}";
    private static final String PURCHASE_ID_WILDCARD =  "{purchaseId}";
    private static final String BASE_API_URL = "http://sandbox.flexionmobile.com/javachallenge/rest/developer";
    private static final String BUY_PATH = "/" + DEVELOPER_WILDCARD + "/buy/" + ITEM_WILDCARD;
    private static final String PURCHASES_PATH = "/" + DEVELOPER_WILDCARD  + "/all";
    private static final String CONSUME_PATH = "/" + DEVELOPER_WILDCARD + "/consume/" + PURCHASE_ID_WILDCARD;

    public static String buildBuyURL(String developerId, String itemId){
        StringBuilder sb = new StringBuilder();
        return sb.append(BASE_API_URL)
                .append(
                        BUY_PATH.replace(DEVELOPER_WILDCARD, developerId)
                                .replace(ITEM_WILDCARD,itemId)).toString();
    }

    public static String buildPurchasesURL(String developerId){
        StringBuilder sb = new StringBuilder();
        return sb.append(BASE_API_URL)
                .append(
                        PURCHASES_PATH.replace(DEVELOPER_WILDCARD, developerId)).toString();
    }

    public static String buildConsumeURL(String developerId, String purchaseId){
        StringBuilder sb = new StringBuilder();
        return sb.append(BASE_API_URL)
                .append(
                        CONSUME_PATH.replace(DEVELOPER_WILDCARD, developerId)
                                    .replace(PURCHASE_ID_WILDCARD, purchaseId)).toString();
    }
}
