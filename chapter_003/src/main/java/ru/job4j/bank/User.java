package ru.job4j.bank;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 26.06.2019
 */
public class User implements Comparable {

    /**
     * Наименование
     */
    private String name;

    /*
     * Пароль
     */
    private String passport;

    /**
     * Конструктор
     * @param name - Наименование
     * @param passport - Пароль
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Геттер name
     * @return - name
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер passport
     * @return - passport
     */
    public String getPassport() {
        return passport;
    }

    @Override
    public int hashCode() {
        return this.passport.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account account = (Account) obj;
        return super.equals(account.requisites);
    }

    @Override
    public int compareTo(Object o) {
        if (o == this);
        if (o == null || getClass() != o.getClass()) {
            return -1;
        }
        User User = (User) o;
        return this.passport.compareTo(User.passport);
    }
}
