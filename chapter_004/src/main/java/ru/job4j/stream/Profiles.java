package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Класс Profiles
 *
 * @author akochanov
 * @version 1
 * @since 18.07.2019
 */
public class Profiles {
    /**
     * Метод возращающий список адресов
     * @param profiles  - список профилей
     * @return - список адресов
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress()).collect(Collectors.toList());
    }
}
