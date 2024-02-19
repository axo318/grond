package com.grond;

import com.grond.catalog.api.CatalogObject;
import com.grond.shared.SharedObject;

public class Main {
    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject("Hello world!");
        System.out.println(sharedObject.name());

        CatalogObject catalogObject = new CatalogObject("w");
    }
}