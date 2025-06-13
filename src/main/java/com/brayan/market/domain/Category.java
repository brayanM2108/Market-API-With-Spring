package com.brayan.market.domain;

import lombok.Getter;
import lombok.Setter;

public class Category {
    @Getter@Setter
    private int categoryId;

    @Getter@Setter
    private String categoryName;

    @Getter@Setter
    private boolean active;
}
