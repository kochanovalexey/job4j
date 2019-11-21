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
        this.users.entrySet().stream()
                .filter(user -> passport.equals(user.getKey().getPassport()))
                .filter(user -> !(user.getValue().contains(account)))
                .forEach(user -> user.getValue().add(account));
    }

    /**
     * Удалить аккаунт у пользователя
     * @param passport - пароль пользователя
     * @param account - акаунт
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.users.entrySet().stream().
                forEach(user -> {
                            if (passport.equals(user.getKey().getPassport())) {
                                int index = user.getValue().indexOf(account);
                                if (!(index == -1)) {
                                    user.getValue().remove(index);
                                }
                                return;
                            }
                });
    }

    /**
     * Получить все аккаунты пользователя
     * @param passport - пароль пользователя
     * @return - список аккаунтов
     */
    public List<Account> getUserAccounts(String passport) {
        return this.users.entrySet().stream()
                .filter(user -> passport.equals(user.getKey().getPassport()))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(new ArrayList<>());
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
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
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
        return accounts.stream()
                .filter(account -> requisite.equals(account.getRequisites()))
                .findFirst()
                .orElse(null);
    }
}
