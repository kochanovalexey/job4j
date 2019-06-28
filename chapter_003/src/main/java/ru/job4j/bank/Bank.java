package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 26.06.2019
 */
public class Bank {

    /**
     *  Список пользователей с аккаунтами
     */
    private TreeMap<User, ArrayList<Account>> users = new TreeMap<>();

    /**
     * Добавить пользователя
     * @param user - пользователь
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Удалить пользователя
     * @param user - пользователь
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * Добваить аккаунт пользователю
     * @param passport - пароль пользователя
     * @param account - аккаунт
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, ArrayList<Account>> user : this.users.entrySet()) {
            if (passport.equals(user.getKey().getPassport())) {
                if (!(user.getValue().contains(account))) {
                    user.getValue().add(account);
                }
                return;
            }
        }
    }

    /**
     * Удалить аккаунт у пользователя
     * @param passport - пароль пользователя
     * @param account - акаунт
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, ArrayList<Account>> user : this.users.entrySet()) {
            if (passport.equals(user.getKey().getPassport())) {
                int index = user.getValue().indexOf(account);
                if (!(index == -1)) {
                    user.getValue().remove(index);
                }
                return;
            }
        }
    }

    /**
     * Получить все аккаунты пользователя
     * @param passport - пароль пользователя
     * @return - список аккаунтов
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        for (Map.Entry<User, ArrayList<Account>> user : this.users.entrySet()) {
            if (passport.equals(user.getKey().getPassport())) {
                accounts = user.getValue();
                break;
            }
        }
        return accounts;
    }

    /**
     * Перевод денег с одного аккаунта на другой
     * @param srcPassport - пароль пользователя от которого переводятся деньги
     * @param srcRequisite - реквизиты аккаунта от которого переводятся деньги
     * @param destPassport - пароль пользователя к которому переводятся деньги
     * @param dstRequisite - реквизиты аккаунта к которому переводятся деньги
     * @param amount - сумма перевода
     * @return - результат операции
     */
    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        List<Account> srcAccounts = getUserAccounts(srcPassport);
        Account srcAccount = getUserAccount(srcAccounts, srcRequisite);
        if (srcAccount == null) {
            return false;
        }
        List<Account> dstAccounts = getUserAccounts(destPassport);
        Account dstAccount = getUserAccount(dstAccounts, dstRequisite);
        if (dstAccount == null) {
            return false;
        }
        return srcAccount.transfer(dstAccount, amount);


    }

    /**
     * Получение акаунта из списка аккаунтов
     * @param accounts - список аккаунтов
     * @param requisite - реквизиты
     * @return - искомый аккаунт
     */
    public Account getUserAccount(List<Account> accounts, String requisite) {
        Account srcAccount = null;
        for (Account account : accounts) {
            if (requisite.equals(account.getRequisites())) {
                srcAccount = account;
                break;
            }
        }
        return srcAccount;
    }
}
