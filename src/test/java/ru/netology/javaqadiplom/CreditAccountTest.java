package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldCreateCreditAccountPositive() {
        CreditAccount account = new CreditAccount(
                30,
                200,
                3
        );

        Assertions.assertEquals(30, account.getBalance());
        Assertions.assertEquals(3, account.getRate());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenRateNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    500,
                    10_000,
                    -10
            );
        });
    }
}
