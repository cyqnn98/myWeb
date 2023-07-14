package com.yqcui.yqweb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "`Cart`")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

//    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<CartItem> cartItems = new HashSet<>();

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products = new HashSet<>();


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "product_num", nullable = false)
    private int productNum;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

//    public Set<CartItem> getCartItems() {
//        return cartItems;
//    }
//
//    public void setCartItems(Set<CartItem> cartItems) {
//        this.cartItems = cartItems;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
