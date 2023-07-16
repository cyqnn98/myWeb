package com.yqcui.yqweb.service;

import com.yqcui.yqweb.entity.Cart;
import com.yqcui.yqweb.entity.CartItem;

import java.util.List;

public interface CartService {
    Cart addToCart(Cart cart);
//    Cart saveCart(Long userId);
    void insertCartByUserId(Long userId);

    Long getCartIdByUserId(Long userId);

    Cart getCartByUserId(Long userId);

//    List<CartItem> getCart(Long userId);
}
