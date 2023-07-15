package com.yqcui.yqweb.service;

import com.yqcui.yqweb.entity.Cart;

public interface CartService {
    Cart addToCart(Cart cart);
//    Cart saveCart(Long userId);
    void insertCartByUserId(Long userId);

    Long getCartIdByUserId(Long userId);

}
