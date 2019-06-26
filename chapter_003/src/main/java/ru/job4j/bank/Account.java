package ru.job4j.bank;

import java.util.Comparator;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 26.06.2019
 */
public class Account {

    /**
     * Количество денег
     */
    int value;

    /**
     * Реквизиты
     */
    String requisites;

    /**
     * Конструктор
     * @param value - количество денег
     * @param requisites - реквизиты
     */
    public Account(int value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Геттер value
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * Геттер requisites
     * @return requisites
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     * Пополнение денег
     * @param amount - сумма
     */
    public void refill(double amount) {
        this.value =(int) (this.value+ amount);
    }

    /**
     * Перевод на счет другого аккаунта
     * @param account - аккаунт
     * @param amount - сумма
     * @return - результат операции
     */
    public boolean transfer(Account account, double amount) {
        if (this.value < amount) {
            return false;
        }
        this.value =(int) (this.value - amount);
        account.refill(amount);
        return true;
    }
}
