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

    // после этого все зарубить
    @Test
    public void shouldBeIllegalArgumentExceptionForNegativeInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    CreditAccount credit = new CreditAccount(
                            -100_000,
                            -50_000,
                            10
                    );
                });
    }

    @Test
    public void shouldBeIllegalArgumentExceptionForNegativeCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    CreditAccount credit = new CreditAccount(
                            10_000,
                            -100_000,
                            10
                    );
                });
    }
    @Test
    public void shouldBeZeroRate() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                0
        );

        int expected = 0;
        int actual = credit.getRate();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSubtractAmountFromBalance() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                10
        );

        credit.pay(2_000);

        int expected = 8_000;
        int actual = credit.getBalance();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldAddAmountToBalance() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                10
        );

        credit.add(2_000);

        int expected = 12_000;
        int actual = credit.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculatePercentOnNegativeBalanceLessThen100() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                15
        );
        credit.balance = -50;

        int expected = -7;
        int actual = credit.yearChange();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotCalculatePercentOnPositiveBalance() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                15
        );
        credit.balance = 10_000;

        int expected = 0;
        int actual = credit.yearChange();

        Assertions.assertEquals(expected, actual);
    }

}
