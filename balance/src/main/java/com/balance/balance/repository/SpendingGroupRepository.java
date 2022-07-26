package com.balance.balance.repository;

import com.balance.balance.entity.model.SpendingGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendingGroupRepository extends JpaRepository<SpendingGroup, Long> {
}
