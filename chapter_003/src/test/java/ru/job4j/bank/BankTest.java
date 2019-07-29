package ru.job4j.bank;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 26.06.2019
 */
public class BankTest {

    @Test
    public void whenTransfer850WhenSecondUserAccountRiseTo850() {
        Bank bank = new Bank();
        User firstUser = new User("Petrov Ivan", "qwerty");
        Account account1 = new Account(100, "2828100-113");
        Account account2 = new Account(1500, "2828100-222");
        Account account3 = new Account(900, "2828100-563");
        bank.addUser(firstUser);
        bank.addAccountToUser(firstUser.getPassport(), account1);
        bank.addAccountToUser(firstUser.getPassport(), account2);
        bank.addAccountToUser(firstUser.getPassport(), account3);

        User secondUser = new User("Semonov Alex", "123456789");
        Account account4 = new Account(320, "8281922-321");
        bank.addUser(secondUser);
        bank.addAccountToUser(secondUser.getPassport(), account4);
        bank.transferMoney(firstUser.getPassport(), account2.getRequisites(), secondUser.getPassport(), account4.getRequisites(), 850);
        assertThat(account4.getValue(), is(1170));
    }

    @Test
    public void whenDeleteUserAccount() {
        Bank bank = new Bank();
        User firstUser = new User("Petrov Ivan", "qwerty");
        Account account1 = new Account(100, "2828100-113");
        Account account2 = new Account(1500, "2828100-222");
        Account account3 = new Account(900, "2828100-563");
        bank.addUser(firstUser);
        bank.addAccountToUser(firstUser.getPassport(), account1);
        bank.addAccountToUser(firstUser.getPassport(), account2);
        bank.addAccountToUser(firstUser.getPassport(), account3);

        bank.deleteAccountFromUser("qwerty", account2);
        List<Account> result = bank.getUserAccounts("qwerty");
        List<Account> expect = List.of(
                account1,
                account3
        );
        assertThat(result, is(expect));
    }
}
