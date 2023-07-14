package com.yqcui.yqweb.repository;

import com.yqcui.yqweb.entity.Cart;
import com.yqcui.yqweb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Cart (user_id) VALUES (?1)", nativeQuery = true)
    void insertCartByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT cart_id FROM Cart WHERE user_id = (?1)", nativeQuery = true)
    Long getCartIdByUserId(Long userId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Cart (cart_id, user_id, product_id, product_num) VALUES (?1, ?2, ?3, ?4)",
    nativeQuery = true)
    void addItem(Long cartId, Long userId, Long productId, int productNum);

    @Query(value = "SELECT * FROM  Cart WHERE product_id = (?1) AND cart_id = (?2)", nativeQuery = true)
    Cart getCartItem(Long productId, Long cartId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Cart SET product_num = product_num+1 WHERE product_id=(?1) AND cart_id=(?2)", nativeQuery = true)
    void increaseItemNum(Long productId, Long cartId);
}
