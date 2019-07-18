package ru.job4j.stream;

/**
 * Class Класс Адресов
 *
 * @author akochanov
 * @version 1
 * @since 18.07.2019
 */
public class Address {
    /**
     * Город
     */
    private String city;
    /**
     * Улица
     */
    private String street;
    /**
     * Дом
     */
    private int home;
    /**
     * Апартаменты
     */
    private int apartment;

    /**
     * Конструктор
     * @param city - город
     * @param street - улица
     * @param home - дом
     * @param apartment - апартаменты
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

}
