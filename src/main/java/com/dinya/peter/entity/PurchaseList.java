package com.dinya.peter.entity;

import com.flexionmobile.codingchallenge.integration.Purchase;

import java.util.Arrays;
import java.util.List;

public class PurchaseList {
    private PurchaseImpl[] purchases;

    public List<Purchase> getPurchases() {
        return Arrays.asList(purchases);
    }
}
