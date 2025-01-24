package com.capstone.rules_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.rules_service.entity.RulesEntity;

public interface RulesRepository extends JpaRepository<RulesEntity,Integer>{

}
