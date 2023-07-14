package com.yqcui.yqweb.service;

import com.yqcui.yqweb.entity.CartItem;

public interface CartItemService {

    CartItem getCartItem(Long productId, Long userId);

    void addItem(Long cartId, Long productId, int productNum);

    void increaseItemNum(Long productId, Long cartId);
}
