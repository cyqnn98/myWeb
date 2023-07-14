package com.yqcui.yqweb.repository;

import com.yqcui.yqweb.entity.Cart;
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
}
