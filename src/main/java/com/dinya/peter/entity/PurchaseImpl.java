package com.dinya.peter.entity;

import com.flexionmobile.codingchallenge.integration.Purchase;

/**
 * Created by dipet on 2017. 11. 29..
 */
public class PurchaseImpl implements Purchase {

    private String id;
    private boolean consumed;
    private String itemId;

    public String getId() {
        return id;
    }

    public boolean getConsumed() {
        return consumed;
    }

    public String getItemId() {
        return itemId;
    }
}
