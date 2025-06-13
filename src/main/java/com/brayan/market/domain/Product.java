package com.brayan.market.domain;

import lombok.Getter;
import lombok.Setter;

public class Product {

    @Getter @Setter
    private int productId;

    @Getter @Setter
    private String productName;

    @Getter @Setter
    private int categoryId;

    @Getter @Setter
    private double price;

    @Getter @Setter
    private int stock;

    @Getter @Setter
    private boolean active;

    @Getter @Setter
    private Category category;
}
