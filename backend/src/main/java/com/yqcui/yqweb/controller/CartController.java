package com.yqcui.yqweb.controller;

import com.yqcui.yqweb.entity.Cart;
import com.yqcui.yqweb.entity.CartItem;
import com.yqcui.yqweb.entity.CartItemId;
import com.yqcui.yqweb.service.CartItemService;
import com.yqcui.yqweb.service.CartService;
import com.yqcui.yqweb.service.ProductService;
import com.yqcui.yqweb.utils.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    private CartService cartService;
    private CartItemService cartItemService;
    private ProductService productService;

    public CartController(CartService cartService, CartItemService cartItemService, ProductService productService){
        this.cartService = cartService;
        this.cartItemService = cartItemService;
        this.productService = productService;
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

    @GetMapping("/getCart")
    public List<CartItem> getCart(@RequestParam(name = "userId") Long userId){
        Cart cart = cartService.getCartByUserId(userId);
        Long cartId = cartService.getCartIdByUserId(userId);
        List<CartItem> cartItems = cartItemService.getCartItem(cartId);
        if(cartItems == null || cartItems.size() == 0)
            return null;
        for (int i = 0; i <cartItems.size(); i++) {
            CartItem cartItem = cartItems.get(i);
            cartItem.setCart(cart);
            cartItem.setProduct(productService.getProductById(cartItem.getId().getProductId()));
        }
        System.out.println("in cart controller");
        System.out.println(cartItems.get(0));
        return cartItems;
    }

    @PostMapping("/emptyCart")
    public Result emptyCart(@RequestParam(name = "userId") Long userId){
        Long cartId = cartService.getCartIdByUserId(userId);
        cartItemService.emptyCart(cartId);
        return Result.ok();
    }
}
