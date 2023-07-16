package com.yqcui.yqweb.repository;

import com.yqcui.yqweb.entity.Cart;
import com.yqcui.yqweb.entity.CartItem;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Cart (user_id) VALUES (?1)", nativeQuery = true)
    void insertCartByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT cart_id FROM Cart WHERE user_id = (?1)", nativeQuery = true)
    Long getCartIdByUserId(Long userId);


    @Query(value = "SELECT * FROM Cart WHERE user_id = (?1)", nativeQuery = true)
    Cart getCartByUserId(Long userId);

//    @Query(value = "SELECT ci.cart_id, ci.product_id, ci.product_num FROM Cart_Item ci " +
//            "JOIN Cart c ON c.cart_id = ci.cart_id " +
//            "WHERE c.user_id = ?1", nativeQuery = true)
//    List<Object> getCart(Long userId);

}
