package com.yqcui.yqweb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`Cart_Item`")
public class CartItem {

    @EmbeddedId
    private CartItemId id;

    @MapsId("cart_id")
    @JoinColumns({
            @JoinColumn(name="cart_id", referencedColumnName="cart_id")
    })
    @ManyToOne
    private Cart cart;

    @MapsId("product_id")
    @JoinColumns({
            @JoinColumn(name="product_id", referencedColumnName="product_id")
    })
    @ManyToOne
    private Product product;

    @Column(name = "product_num")
    private int productNum;

}
