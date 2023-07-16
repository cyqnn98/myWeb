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

//    @Override
//    public List<CartItem> getCart(Long userId) {
//        List<Object> objects = .getCart(userId);
//        List<CartItem> cartItems = new ArrayList<>();
//        for(Object ob: objects){
//            Object[] obs = (Object[]) ob;
//            System.out.println("cartId");
//            System.out.println(obs[0]);
//            System.out.println("productId");
//            System.out.println(obs[1]);
//            System.out.println("productNum");
//            System.out.println(obs[2]);
//            CartItem cartItem = new CartItem((Long)obs[0], (Long) obs[1], (Integer) obs[2]);
//            cartItems.add(cartItem);
//        }
//        return cartItems;
//    }
}
