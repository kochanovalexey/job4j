package ru.job4j.stream;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return city.equals(address.city) && street.equals(address.street) && home == address.home && apartment == address.apartment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }


    public String getCity() {
        return city;
    }
}
