CREATE TABLE rules (
    rule_id INT AUTO_INCREMENT PRIMARY KEY,
    terms_and_conditions VARCHAR(255),
    contribution_per_month DOUBLE,
    term_period INT,
    interest_rate DOUBLE,
    contribution_deadline DATETIME,
    community_start_date DATETIME
);
