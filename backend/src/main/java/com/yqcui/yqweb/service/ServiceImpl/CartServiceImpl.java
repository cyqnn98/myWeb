package com.yqcui.yqweb.service.ServiceImpl;

import com.yqcui.yqweb.entity.Cart;
import com.yqcui.yqweb.entity.CartItem;
import com.yqcui.yqweb.repository.CartRepository;
import com.yqcui.yqweb.service.CartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
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
    public Cart getCartByUserId(Long userId) {
        return cartRepository.getCartByUserId(userId);
    }

}
