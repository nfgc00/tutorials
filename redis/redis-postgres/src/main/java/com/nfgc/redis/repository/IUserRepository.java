package com.nfgc.redis.repository;

import com.nfgc.redis.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
