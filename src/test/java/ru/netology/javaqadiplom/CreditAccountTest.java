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
        Assertions.assertEquals(200, account.getCreditLimit());
        Assertions.assertEquals(3, account.getRate());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenInitialBalanceNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -7_000,
                    28_000,
                    9
            );
        });
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenCreditLimitNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    100,
                    -100,
                    11
            );
        });
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenCreditLimitNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    167,
                    0,
                    1
            );
        });
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

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenRateNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    6_200,
                    8_000,
                    0
            );
        });
    }

    @Test
    public void shouldReturnTrueWhenTotalBalancePositiveLessThanCreditLimit() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                10
        );

        Assertions.assertTrue(account.pay(2_000));
        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldReturnTrueWhenTotalBalanceNegativeLessThanCreditLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                2_000,
                7
        );

        Assertions.assertTrue(account.pay(1_500));
        Assertions.assertEquals(-500, account.getBalance());
    }

    @Test
    public void shouldReturnTrueWhenTotalBalanceNull() {
        CreditAccount account = new CreditAccount(
                150,
                2_000,
                18
        );

        Assertions.assertTrue(account.pay(150));
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldReturnFalseWhenTotalBalanceGreaterThanCreditLimit() {
        CreditAccount account = new CreditAccount(
                500,
                1_000,
                17
        );

        Assertions.assertFalse(account.pay(2_500));
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldReturnFalseWhenTotalBalanceEqualsCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                500_000,
                13
        );

        Assertions.assertTrue(account.pay(500_000));
        Assertions.assertEquals(-500_000, account.getBalance());
    }

    @Test
    public void shouldReturnFalseWhenPayAmountNegative() {
        CreditAccount account = new CreditAccount(
                200,
                7_000,
                10
        );

        Assertions.assertFalse(account.pay(-100));
        Assertions.assertEquals(200, account.getBalance());
    }

    @Test
    public void shouldReturnFalseWhenPayAmountNull() {
        CreditAccount account = new CreditAccount(
                8_900,
                9_999,
                10
        );

        Assertions.assertFalse(account.pay(0));
        Assertions.assertEquals(8_900, account.getBalance());
    }

    @Test
    public void shouldReturnTrueWhenAddToNullBalance() {
        CreditAccount account = new CreditAccount(
                0,
                200_000,
                4
        );

        Assertions.assertTrue(account.add(500));
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldReturnTrueWhenAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                7_000,
                100_000,
                8
        );

        Assertions.assertTrue(account.add(1_000));
        Assertions.assertEquals(8_000, account.getBalance());
    }

    @Test
    public void shouldReturnTrueWhenAddToNegativeBalanceTotalPositive() {
        CreditAccount account = new CreditAccount(
                -900,
                10_000,
                3
        );

        Assertions.assertTrue(account.add(1_900));
        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldReturnTrueWhenAddToNegativeBalanceTotalNegative() {
        CreditAccount account = new CreditAccount(
                -4_000,
                10_000,
                3
        );

        Assertions.assertTrue(account.add(2_000));
        Assertions.assertEquals(-2_000, account.getBalance());
    }

    @Test
    public void shouldReturnTrueWhenAddToNegativeBalanceTotalNull() {
        CreditAccount account = new CreditAccount(
                -9_999,
                10_000,
                3
        );

        Assertions.assertTrue(account.add(9_999));
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldReturnFalseWhenAddNegativeAmount() {
        CreditAccount account = new CreditAccount(
                500,
                10_000,
                3
        );

        Assertions.assertFalse(account.add(-200));
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldReturnFalseWhenAddNullAmount() {
        CreditAccount account = new CreditAccount(
                -1_500,
                20_000,
                7
        );

        Assertions.assertFalse(account.add(0));
        Assertions.assertEquals(-1_500, account.getBalance());
    }
}
