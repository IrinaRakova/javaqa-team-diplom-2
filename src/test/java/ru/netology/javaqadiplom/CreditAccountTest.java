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
    public void shouldBePositiveInitialBalance() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                10
        );

        int expected = 10_000;
        int actual = credit.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeZeroInitialBalance() {
        CreditAccount credit = new CreditAccount(
                0,
                100_000,
                10
        );

        int expected = 0;
        int actual = credit.getBalance();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldBeIllegalArgumentExceptionForNegativeInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    CreditAccount credit = new CreditAccount(
                            -10_000,
                            100_000,
                            10
                    );
                });
    }

    @Test
    public void shouldBePositiveCreditLimit() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                10
        );

        int expected = 100_000;
        int actual = credit.getCreditLimit();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeZeroCreditLimit() {
        CreditAccount credit = new CreditAccount(
                10_000,
                0,
                10
        );

        int expected = 0;
        int actual = credit.getCreditLimit();

        Assertions.assertEquals(expected, actual);
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
    public void shouldBePositiveRate() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                10
        );

        int expected = 10;
        int actual = credit.getRate();

        Assertions.assertEquals(expected, actual);
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
    public void shouldBeIllegalArgumentExceptionForNegativeRate() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    CreditAccount credit = new CreditAccount(
                            10_000,
                            100_000,
                            -10
                    );
                });
    }

    @Test
    public void shouldPayIfAmountIsPositive() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                10
        );

        boolean expected = true;
        boolean actual = credit.pay(2_000);

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
    public void shouldNotPayIfAmountIsNegative() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                10
        );

        boolean expected = false;
        boolean actual = credit.pay(-2_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotPayIfBalanceLessThenLimit() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                10
        );

        boolean expected = false;
        boolean actual = credit.pay(200_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotPayIfAmountIsZero() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                10
        );

        boolean expected = false;
        boolean actual = credit.pay(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddIfAmountIsPositive() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                10
        );

        boolean expected = true;
        boolean actual = credit.add(2_000);

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
    public void shouldNotAddIfAmountIsNegative() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                10
        );

        boolean expected = false;
        boolean actual = credit.add(-2_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotAddIfAmountIsZero() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                10
        );

        boolean expected = false;
        boolean actual = credit.add(0);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculatePercentOnNegativeBalance() {
        CreditAccount credit = new CreditAccount(
                10_000,
                100_000,
                15
        );
        credit.balance = -10_000;

        int expected = -1500;
        int actual = credit.yearChange();

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