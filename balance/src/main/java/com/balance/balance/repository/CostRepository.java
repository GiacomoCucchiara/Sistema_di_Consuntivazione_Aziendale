package com.balance.balance.repository;

import com.balance.balance.entity.model.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends JpaRepository<Cost, Long> {


}
