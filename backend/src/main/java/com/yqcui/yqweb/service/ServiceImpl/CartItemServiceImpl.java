package com.yqcui.yqweb.service.ServiceImpl;

import com.yqcui.yqweb.entity.CartItem;
import com.yqcui.yqweb.repository.CartItemRepository;
import com.yqcui.yqweb.service.CartItemService;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {
    private CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository){
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem getCartItem(Long productId, Long userId) {
        return cartItemRepository.getCartItem(productId, userId);
    }

    @Override
    public void addItem(Long cartId, Long productId, int productNum) {
         cartItemRepository.addItem(cartId, productId, productNum);
    }

    @Override
    public void increaseItemNum(Long productId, Long userId) {
        cartItemRepository.increaseItemNum(productId, userId);
    }
}
