package com.yqcui.yqweb.service.ServiceImpl;

import com.yqcui.yqweb.entity.Cart;
import com.yqcui.yqweb.entity.Product;
import com.yqcui.yqweb.repository.CartRepository;
import com.yqcui.yqweb.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    public void insertCartByUserId(Long userId) {
        cartRepository.insertCartByUserId(userId);
    }

    @Override
    public Long getCartIdByUserId(Long userId) {
        return cartRepository.getCartIdByUserId(userId);
    }

    @Override
    public void addItem(Long cartId, Long userId, Long productId, int productNum) {
        cartRepository.addItem(cartId, userId, productId, productNum);
    }

    @Override
    public Cart getCartItem(Long productId, Long cartId) {
        return cartRepository.getCartItem(productId, cartId);
    }

    @Override
    public void increaseItemNum(Long productId, Long cartId) {
        cartRepository.increaseItemNum(productId, cartId);
    }
}
