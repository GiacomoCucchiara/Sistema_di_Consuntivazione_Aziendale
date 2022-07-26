package com.balance.balance.repository;

import com.balance.balance.entity.model.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDayRepository extends JpaRepository<WorkDay, Long> {


}
