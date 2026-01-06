package com.Solid;

//Unit Tests for Premium Loan Rule

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PremiumLoanApprovalTest {

    private PremiumLoanApproval loanService;
    private CustomerAccount premiumAccount;
    private CustomerAccount nonPremiumAccount;

    @BeforeEach
    void setup() {
        loanService = new PremiumLoanApproval();
        premiumAccount = new CustomerAccount("John", 333, 10000, 780);
        nonPremiumAccount = new CustomerAccount("Dave", 444, 10000, 700);
    }

    @Test
    void testPremiumLoanApproved() {
        loanService.applyLoan(premiumAccount, 40000); // valid (<= balance * 5)
    }

    @Test
    void testPremiumLoanDenied() {
        loanService.applyLoan(nonPremiumAccount, 20000); // credit score low
    }

    @Test
    void testPremiumLoanInvalidAmount() {
        loanService.applyLoan(premiumAccount, 0);
    }
}