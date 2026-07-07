package com.nhanshop.ecommerce.user.repository;

import com.nhanshop.ecommerce.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByfullName(String userName);
    boolean existsByemail(String userName);
    Optional<User> findByemail(String email);
    boolean existsByphoneNumber(String phoneNumber);
}
