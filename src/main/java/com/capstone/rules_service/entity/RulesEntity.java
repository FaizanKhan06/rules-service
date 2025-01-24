package com.capstone.rules_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rules")
public class RulesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rule_id")
    private int ruleId;

    @Column(name = "terms_and_conditions")
    private String termsAndConditions;

    @Column(name = "contribution_per_month")
    private double contributionPerMonth;

    @Column(name = "term_period")
    private int termPeriod;

    @Column(name = "interest_rate")
    private double interestRate;

    @Column(name = "contribution_deadline")
    private LocalDateTime contributionDeadline;

    @Column(name = "community_start_date")
    private LocalDateTime communityStartDate;

}
