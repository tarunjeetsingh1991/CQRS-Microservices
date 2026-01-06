package com.Solid;

//Unit Tests for CustomerAccount

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerAccountTest {

    private CustomerAccount account;

    @BeforeEach
    void setup() {
        account = new CustomerAccount("Tom", 123456, 10000, 720);
    }

    @Test
    void testDepositValidAmount() {
        account.deposit(5000);
        Assertions.assertEquals(15000, account.getBalance());
    }

    @Test
    void testDepositInvalidAmount() {
        account.deposit(-200);
        Assertions.assertEquals(10000, account.getBalance());
    }

    @Test
    void testWithdrawValidAmount() {
        account.withdraw(3000);
        Assertions.assertEquals(7000, account.getBalance());
    }

    @Test
    void testWithdrawInvalidAmount() {
        account.withdraw(15000); // > balance
        Assertions.assertEquals(10000, account.getBalance());
    }

    @Test
    void testShowDetails_NoException() {
        Assertions.assertDoesNotThrow(() -> account.showDetails());
    }
}