package com.yqcui.yqweb.repository;

import com.yqcui.yqweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNum(long phoneNum);
    User getUserByEmail(String email);
}
