package com.capstone.rules_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.rules_service.entity.RulesEntity;

@Repository
public interface RulesRepository extends JpaRepository<RulesEntity, Integer> {
}
