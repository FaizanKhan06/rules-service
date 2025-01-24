package com.capstone.rules_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.rules_service.entity.RulesEntity;
import com.capstone.rules_service.service.RulesService;

@RestController
@RequestMapping("/api/rules")
public class RulesController {

        @Autowired
        RulesService rulesService;

        @GetMapping(" ")
        public ResponseEntity<List<RulesEntity>>getAllRules(){
            return new ResponseEntity<>(rulesService.getAllRules(),HttpStatus.OK);
        }
        
        @GetMapping("/{rid}")        
        public ResponseEntity<RulesEntity>getARule(@PathVariable("rid")int ruleId){
            return new ResponseEntity<>(rulesService.getARule(ruleId),HttpStatus.OK);
        }
        
        @PostMapping(" ")
        public ResponseEntity<RulesEntity> addARule(@RequestBody RulesEntity newRule){
            return new ResponseEntity<>(rulesService.addARule(newRule),HttpStatus.OK);
        }

        @PutMapping(" ")
        public ResponseEntity<RulesEntity>updateTransaction(RulesEntity editedRule){
            return new ResponseEntity<>(rulesService.updateRule(editedRule),HttpStatus.OK);
        }

        @DeleteMapping("/{rid}")
        public ResponseEntity<Void> deleteRule(@PathVariable("rid")int ruleId){
            rulesService.deleteRule(ruleId);
            return new ResponseEntity<>(HttpStatus.OK);
        }

}   
