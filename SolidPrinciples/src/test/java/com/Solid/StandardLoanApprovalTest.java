package com.Solid;
//Unit Tests for Standard Loan Rule

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StandardLoanApprovalTest {

    private StandardLoanApproval loanService;
    private CustomerAccount accountHighScore;
    private CustomerAccount accountLowScore;

    @BeforeEach
    void setup() {
        loanService = new StandardLoanApproval();
        accountHighScore = new CustomerAccount("Alice", 111, 10000, 720); // good score
        accountLowScore  = new CustomerAccount("Bob", 222, 10000, 650);   // bad score
    }

    @Test
    void testLoanApproved_Standard() {
        loanService.applyLoan(accountHighScore, 25000);
        // No assert for print statements → ensure no exceptions
    }

    @Test
    void testLoanDenied_Standard() {
        loanService.applyLoan(accountLowScore, 10000);
        // Test passes as long as method does not throw exceptions
    }

    @Test
    void testLoanInvalidAmount() {
        loanService.applyLoan(accountHighScore, -5000);
    }
}