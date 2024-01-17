package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);


        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }


    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSavingRateNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1000,
                    200,
                    10000,
                    -15


            );
        });
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSavingRateNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1000,
                    200,
                    10000,
                    0


            );
        });
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSavingMinBalanceNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1000,
                    -200,
                    10000,
                    15


            );
        });
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSavingInitBalanceNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    0,
                    1000,
                    10000,
                    15


            );
        });
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSavingInitBalanceNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    -100,
                    200,
                    10000,
                    15


            );
        });
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSavingMinBalanceOverMaxBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    20_000,
                    9000,
                    15


            );
        });
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSavingMinBalanceNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1000,
                    0,
                    10000,
                    15


            );
        });
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSavingMaxBalanceNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    100,
                    100,
                    -100,
                    15


            );
        });
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionWhenSavingMaxBalanceNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1000,
                    1000,
                    0,
                    15


            );
        });
    }


    @Test
    public void FalseWhenAccountNullAfterPay() {
        SavingAccount account = new SavingAccount(
                200,
                100,
                500,
                15);

        boolean actual = account.pay(200);


        Assertions.assertFalse(actual);

    }

    @Test
    public void FalseWhenAccountNegativeBalaceAfterPay() {
        SavingAccount account = new SavingAccount(
                100,
                100,
                500,
                15);

        boolean actual = account.pay(200);

        Assertions.assertFalse(actual);
    }
    @Test
    public void FalseWhenAccountZeroBalaceAfterPay() {
        SavingAccount account = new SavingAccount(
                100,
                100,
                500,
                15);

        boolean actual = account.pay(100);

        Assertions.assertFalse(actual);

    }

    @Test
    public void TrueWhenAccountMoreMinBalanceAfterPay() {
        SavingAccount account = new SavingAccount(
                2000,
                100,
                5000,
                15);

        boolean actual = account.pay(200);


        Assertions.assertTrue(actual);

    }

    @Test
    public void FalseWhenAccountNegativeAfterAdd() {
        SavingAccount account = new SavingAccount(
                200,
                100,
                500,
                15);

        boolean actual = account.add(-100);


        Assertions.assertFalse(actual);

    }

    @Test
    public void FalseWhenAccountAddZero() {
        SavingAccount account = new SavingAccount(
                200,
                100,
                500,
                15);

        boolean actual = account.add(0);


        Assertions.assertFalse(actual);

    }
    @Test
    public void FalseWhenAccountAddOverMaxBalance() {
        SavingAccount account = new SavingAccount(
                200,
                100,
                500,
                15);

        boolean actual = account.add(600);


        Assertions.assertFalse(actual);

    }

    @Test
    public void TrueWhenAmountPlusBalanceLessMinBalanceAfterAdd() {
        SavingAccount account = new SavingAccount(
                2000,
                100,
                5000,
                15);

        boolean actual = account.add(200);


        Assertions.assertTrue(actual);

    }

    @Test
    public void shouldCountPercentYear() {
        SavingAccount account = new SavingAccount(
                200,
                100,
                3500,
                15
        );

     int actual = account.yearChange();

        Assertions.assertEquals(30,actual );

    }
    @Test
    public void shouldReturnNullYearChangeWhenBalanceNull() {
        SavingAccount account = new SavingAccount(
                0,
                100,
                3500,
                15
        );

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCountYearChangeWhenBalanceNegative() {
        SavingAccount account = new SavingAccount(
                -100,
                100,
                3500,
                15
        );


        int expected = -15;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }


}
