package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    // тесты класса SavingAccount
    @Test
    public void shouldMinBalanceMoreMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    1_000,
                    10,
                    2
            );
        });
    }

    @Test
    public void shouldNegativeMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    -1_000,
                    10_000,
                    2
            );
        });

    }

    @Test
    public void shouldMinBalanceMoreThenInitialBalance() { // начальный баланс не должен быть меньше минимального баланса
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    3_000,
                    10_000,
                    2
            );
        });
    }

    @Test
    public void shouldMaxBalanceLessThenInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    10_001,
                    0,
                    10_000,
                    2
            );
        });
    }

    @Test
    public void shouldInitialBalanceEqualsMinBalance() {  // изначальный баланс может быть равен минимальному балансу
        SavingAccount account = new SavingAccount(
                200,
                200,
                10_000,
                0
        );

        Assertions.assertEquals(200, account.getBalance());
    }

    @Test
    public void shouldInitialBalanceMoreMinBalance() {  // изначальный баланс может быть больше минимального баланса
        SavingAccount account = new SavingAccount(
                201,
                200,
                10_000,
                0
        );

        Assertions.assertEquals(201, account.getBalance());
    }

    @Test
    public void shouldInitialBalanceLessMaxBalance() {  // изначальный баланс может быть меньше максимального баланса
        SavingAccount account = new SavingAccount(
                999,
                200,
                10_000,
                0
        );

        Assertions.assertEquals(999, account.getBalance());
    }

    @Test
    public void shouldInitialBalanceEqualsMaxBalance() {  // изначальный баланс может быть равен максимального баланса
        SavingAccount account = new SavingAccount(
                10_000,
                200,
                10_000,
                0
        );

        Assertions.assertEquals(10_000, account.getBalance());
    }

    //Тесты класса add
    @Test
    public void shouldAddLessThanMaxBalance() { // итоговый баланс меньше максимального
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
    public void shouldAddEqualThanMaxBalance() { // итоговый баланс равен максимальному
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(8_000);

        Assertions.assertEquals(2_000 + 8_000, account.getBalance());
    }

    @Test
    public void shouldAddMoreThanMaxBalance() { // итоговый баланс больше максимального
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(13_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddIfNegativeBalance() { // отрицательная сумма добавления
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(-3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddZero() { // нулевая сумма добавления
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    //Тесты класса pay
    @Test
    public void shouldPayMoreThanMinBalance() { // баланс после покупки больше минимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );
        account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldPayEqualMinBalance() { // баланс после покупки равен минимальному балансу
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );
        boolean expected = true;
        boolean actual = account.pay(2_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNegativePay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(-500);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }
    // тесты класса rate

    @Test
    public void shouldPositivePercent() {
        SavingAccount account = new SavingAccount(
                200,
                100,
                10_000,
                1
        );

        Assertions.assertEquals(2, account.yearChange());
    }

    @Test
    public void shouldZeroPercent() {  //должно показывать процент
        SavingAccount account = new SavingAccount(
                200,
                100,
                10_000,
                0
        );

        Assertions.assertEquals(0, account.getRate());
    }

    @Test
    public void shouldNegativePercent() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -1
            );
        });
    }

    @Test
    public void shouldPositivePercentBefore99() {
        SavingAccount account = new SavingAccount(
                99,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(4, account.yearChange());
    }

    @Test
    public void shouldPositivePercentFrom1() {
        SavingAccount account = new SavingAccount(
                1,
                0,
                10_000,
                100
        );

        Assertions.assertEquals(1, account.yearChange());
    }
}


