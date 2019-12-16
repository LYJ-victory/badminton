package com.badminton.repository;

import com.badminton.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ASUS on 2019/12/7.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
