package com.yqcui.yqweb.repository;

import com.yqcui.yqweb.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    @Query(value = "SELECT* FROM Cart_Item WHERE product_id = (?1) AND cart_id = (?2)", nativeQuery = true)
    CartItem getCartItem(@Param("productId")Long productId, @Param("cartId")Long cartId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Cart_Item (cart_id, product_id, product_num) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void addItem(Long cartId, Long productId, int productNum);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Cart_Item SET product_num = product_num+1 WHERE product_id=(?1) AND cart_id=(?2)", nativeQuery = true)
    void increaseItemNum(Long productId, Long cartId);
}
