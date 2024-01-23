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

    // Создание CreditAccount с корректными параметрами
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

    /* Тесты на выбрасывание исключения при недопустимых значениях параметров:
     * 1. initialBalance < 0
     * 2. creditLimit < 0
     * 3. creditLimit = 0
     * 4. rate < 0
     * 5. rate = 0 */
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

    /*Тесты на метод Pay:
     * 1. Возвращает true, баланс изменяется - balance > 0 после оплаты
     * 2. Возвращает true, баланс изменяется - balance < 0, balance < creditLimit после оплаты
     * 3. Возвращает true, баланс изменяется - balance = 0 после оплаты
     * 4. Возвращает false, баланс не изменяется - balance < 0, balance > creditLimit после оплаты
     * 5. Возвращает true, баланс изменяется - balance < 0, balance = creditLimit после оплаты
     * 6. Возвращает false, баланс не изменяется - pay amount < 0
     * 7. Возвращает false, баланс не изменяется - pay amount = 0 */
    @Test
    public void shouldPayReturnTrueWhenTotalBalancePositiveLessThanCreditLimit() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                10
        );

        Assertions.assertTrue(account.pay(2_000));
        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldPayReturnTrueWhenTotalBalanceNegativeLessThanCreditLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                2_000,
                7
        );

        Assertions.assertTrue(account.pay(1_500));
        Assertions.assertEquals(-500, account.getBalance());
    }

    @Test
    public void shouldPayReturnTrueWhenTotalBalanceNull() {
        CreditAccount account = new CreditAccount(
                150,
                2_000,
                18
        );

        Assertions.assertTrue(account.pay(150));
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayReturnFalseWhenTotalBalanceGreaterThanCreditLimit() {
        CreditAccount account = new CreditAccount(
                500,
                1_000,
                17
        );

        Assertions.assertFalse(account.pay(2_500));
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldPayReturnTrueWhenTotalBalanceEqualsCreditLimit() {
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

    /* Тесты на метод add:
     * 1. Возвращает true, баланс увеличивается - initialBalance = 0
     * 2. Возвращает true, баланс увеличивается - initialBalance > 0
     * 3. Возвращает true, баланс увеличивается - initialBalance < 0, totalBalance > 0
     * 4. Возвращает true, баланс увеличивается - initialBalance < 0, totalBalance < 0
     * 5. Возвращает true, баланс увеличивается - initialBalance < 0, totalBalance = 0
     * 6. Возвращает false, баланс не изменяется - add amount < 0
     * 7. Возвращает false, баланс не изменяется - add amount = 0 */
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

    /* Тесты на метод yearChange:
    * 1. Возвращает 0, balance > 0
    * 2. Возвращает 0, balance = 0
    * 3. Возвращает процент согласно rate, balance < 0 */
    @Test
    public void shouldReturnNullYearChangeWhenBalancePositive() {
        CreditAccount account = new CreditAccount(
                600,
                1_000,
                10
        );

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullYearChangeWhenBalanceNull() {
        CreditAccount account = new CreditAccount(
                0,
                11_000,
                23
        );

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCountYearChangeWhenBalanceNegative() {
        CreditAccount account = new CreditAccount(
                0,
                800,
                15
        );

        account.pay(200);
        int expected = -30;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }
}
