package com.balance.balance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.balance.balance.entity.dto.RegistryDTO;
import com.balance.balance.entity.model.Registry;

@Repository

public interface RegistryRepository extends JpaRepository<Registry, Long> {

    List<Registry> findBySurname(String surname);

    List<Registry> findByName(String name);

    void save(RegistryDTO registryDTO);

    @Query(value = "SELECT * FROM registry WHERE usergroup_id = :id", nativeQuery = true)
    List<Registry> findByUserGroupId(@Param("id") Long id);

}
