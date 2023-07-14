package com.yqcui.yqweb.controller;

import com.yqcui.yqweb.entity.Cart;
import com.yqcui.yqweb.service.CartService;
import com.yqcui.yqweb.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping("/addToCart")
    public Result addToCart(@RequestParam(name = "productId") Long productId,
                            @RequestParam(name = "userId") Long userId){
        Long cartId = cartService.getCartIdByUserId(userId);
        if(cartId == null){
            cartService.addItem(cartId, userId, productId, 1);
        }else{
            Cart cartItem = cartService.getCartItem(productId, cartId);
            if(cartItem == null){
                cartService.addItem(cartId, userId, productId, 1);
            }else{
                cartService.increaseItemNum(productId, cartId);
            }
        }
        return Result.ok();
    }
}
