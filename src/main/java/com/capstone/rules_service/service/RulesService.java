package com.capstone.rules_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.rules_service.entity.RulesEntity;
import com.capstone.rules_service.repository.RulesRepository;

@Service
public class RulesService {
    @Autowired
    RulesRepository rulesRepository;

    public List<RulesEntity> getAllRules(){
        return rulesRepository.findAll();
    }

    public RulesEntity getARule(int ruleId){
        RulesEntity rulesEntity = rulesRepository.findById(ruleId).orElse(null);
        return rulesEntity; 
    }

    public RulesEntity addARule(RulesEntity newRule){
        return rulesRepository.saveAndFlush(newRule);
    }

    public RulesEntity updateRule(RulesEntity editedRule){
        return rulesRepository.save(editedRule);  
    }

    public void deleteRule(int ruleId){
        rulesRepository.deleteById(ruleId);
    }

}
