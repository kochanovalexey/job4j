package ru.job4j.stream;

import java.util.Comparator;
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

    List<Address> collectUniqueAndSorted(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress()).sorted(new AddressComparator()).distinct().collect(Collectors.toList());
    }

    class AddressComparator implements Comparator<Address> {

        @Override
        public int compare(Address o1, Address o2) {
            return o1.getCity().compareTo(o2.getCity());
        }
    }
}

