package com.yqcui.yqweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CartItemId implements Serializable {

    @Column(name = "cart_id")
    private Long cartId; // matches the type of the Cart entity's primary key

    @Column(name = "product_id")
    private Long productId; // matches the type of the Product entity's primary key

}


