package com.yqcui.yqweb.service.ServiceImpl;

import com.yqcui.yqweb.entity.CartItem;
import com.yqcui.yqweb.repository.CartItemRepository;
import com.yqcui.yqweb.service.CartItemService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void deleteFromCart(Long productId, Long userId) {
        cartItemRepository.deleteFromCart(productId, userId);
    }

    @Override
    public int getProductNum(Long cartId, Long productId) {
        return cartItemRepository.getProductNum(cartId, productId);
    }

    @Override
    public void decreaseProductNum(Long cartId, Long productId) {
        cartItemRepository.decreaseProductNum(cartId, productId);
    }

    @Override
    public List<CartItem> getCartItem(Long cartId) {
        return cartItemRepository.findAllByCart_CartId(cartId);
    }
}
