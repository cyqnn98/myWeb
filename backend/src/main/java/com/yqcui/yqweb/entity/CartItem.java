package com.yqcui.yqweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Cart cart;

    @MapsId("product_id")
    @JoinColumns({
            @JoinColumn(name="product_id", referencedColumnName="product_id")
    })

    @ManyToOne
    @JsonIgnore
    private Product product;

    @Column(name = "product_num")
    private int productNum;

    public CartItemId getId() {
        return id;
    }

    public void setId(CartItemId id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
}
