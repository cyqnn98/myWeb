package com.yqcui.yqweb.service;

import com.yqcui.yqweb.entity.Cart;
import com.yqcui.yqweb.entity.Product;

public interface CartService {
//    Cart saveCart(Long userId);
    void insertCartByUserId(Long userId);

    Long getCartIdByUserId(Long userId);

    void addItem(Long cartId, Long userId, Long productId, int productNum);

    Cart getCartItem(Long productId, Long cartId);

    void increaseItemNum(Long productId, Long cartId);
}
