package com.balance.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balance.balance.entity.dto.LoginDTO;
import com.balance.balance.entity.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    void save(LoginDTO loginDTO);
}
