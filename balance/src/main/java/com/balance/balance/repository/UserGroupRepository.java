package com.balance.balance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.balance.balance.entity.model.UserGroup;
import com.balance.balance.entity.view.UserGroupView;

@Repository

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {


    List<UserGroupView> findOneByNameEquals(@Param("name") String name);

}
