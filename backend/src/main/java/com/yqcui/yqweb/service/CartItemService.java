package com.yqcui.yqweb.service;

import com.yqcui.yqweb.entity.CartItem;

import java.util.List;

public interface CartItemService {

    CartItem getCartItem(Long productId, Long userId);

    void addItem(Long cartId, Long productId, int productNum);

    void increaseItemNum(Long productId, Long cartId);

    void deleteFromCart(Long productId, Long userId);

    int getProductNum(Long cartId, Long productId);

    void decreaseProductNum(Long cartId, Long productId);

    List<CartItem> getCartItem(Long cartId);

    void emptyCart(Long cartId);
}
