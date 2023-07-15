package com.yqcui.yqweb.controller;

import com.yqcui.yqweb.entity.CartItem;
import com.yqcui.yqweb.service.CartItemService;
import com.yqcui.yqweb.service.CartService;
import com.yqcui.yqweb.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    private CartService cartService;
    private CartItemService cartItemService;

    public CartController(CartService cartService, CartItemService cartItemService){
        this.cartService = cartService;
        this.cartItemService = cartItemService;
    }

    @PostMapping("/addToCart")
    public Result addToCart(@RequestParam(name = "productId") Long productId,
                            @RequestParam(name = "userId") Long userId){
        Long cartId = cartService.getCartIdByUserId(userId);
        CartItem cartItem = cartItemService.getCartItem(productId, cartId);
        if(cartItem == null){
            cartItemService.addItem(cartId, productId, 1);
        }else{
            cartItemService.increaseItemNum(productId, cartId);
        }
        return Result.ok();
    }

    @PostMapping("/deleteFromCart")
    public Result deleteFromCart(@RequestParam(name = "productId") Long productId,
                                 @RequestParam(name = "userId") Long userId){
        Long cartId = cartService.getCartIdByUserId(userId);
        int productNum = cartItemService.getProductNum(cartId, productId);
        if(productNum == 1){
            cartItemService.deleteFromCart(productId, userId);
        }else{
            cartItemService.decreaseProductNum(cartId, productId);
        }
        return Result.ok();
    }
}
