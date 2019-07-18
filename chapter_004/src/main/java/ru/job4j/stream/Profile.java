package ru.job4j.stream;

/**
 * Class Класс Профилей
 *
 * @author akochanov
 * @version 1
 * @since 18.07.2019
 */
public class Profile {
    /**
     * Адрес
     */
    private Address address;

    /**
     * Адрес
     * @param address
     */
    public Profile(Address address) {
        this.address = address;
    }

    /**
     * Getter Адреса
     * @return - адрес
     */
    public Address getAddress() {
        return address;
    }
}
