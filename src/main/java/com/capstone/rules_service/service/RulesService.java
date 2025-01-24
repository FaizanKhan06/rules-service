package com.capstone.rules_service.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.capstone.rules_service.entity.RulesEntity;
import com.capstone.rules_service.pojo.RulesInputPojo;
import com.capstone.rules_service.pojo.RulesOutputPojo;
import com.capstone.rules_service.repository.RulesRepository;

@Service
public class RulesService {
    @Autowired
    RulesRepository rulesRepository;

    // public List<RulesEntity> getAllRules() {
    // return rulesRepository.findAll();
    // }

    public RulesOutputPojo getARule(int ruleId) {
        RulesEntity rulesEntity = rulesRepository.findById(ruleId).orElse(null);
        if (rulesEntity != null) {
            RulesOutputPojo rulesOutputPojo = new RulesOutputPojo();
            BeanUtils.copyProperties(rulesEntity, rulesOutputPojo);
            return rulesOutputPojo;
        }
        return null;
    }

    public RulesOutputPojo addARule(RulesInputPojo newRule) {

        RulesEntity rulesEntity = new RulesEntity();
        BeanUtils.copyProperties(newRule, rulesEntity);

        rulesEntity = rulesRepository.saveAndFlush(rulesEntity);

        RulesOutputPojo rulesOutputPojo = new RulesOutputPojo();
        BeanUtils.copyProperties(rulesEntity, rulesOutputPojo);

        RestClient restClient = RestClient.create();
        // TODO: Change the localhost to container name
        String response = restClient.put()
                .uri("http://localhost:5002/api/communities/" + newRule.getCommunityId() + "?ruleId="
                        + rulesOutputPojo.getRuleId())
                .retrieve().body(String.class);

        System.out.println(response);

        return rulesOutputPojo;
    }

    // public RulesEntity updateRule(RulesEntity editedRule) {
    // return rulesRepository.save(editedRule);
    // }

    // public void deleteRule(int ruleId) {
    // Optional<RulesEntity> ruleOptional = rulesRepository.findById(ruleId);
    // if (ruleOptional.isPresent()) {
    // RulesEntity rulesEntity = ruleOptional.get();
    // rulesEntity.setDeleted(true);
    // rulesRepository.save(rulesEntity);
    // } else {
    // throw new RuntimeException("Rule not found with ID: " + ruleId);
    // }
    // }

}
