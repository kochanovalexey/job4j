package ru.job4j.stream;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс тестирующий Profiles
 *
 * @author akochanov
 * @version 1
 * @since 18.07.2019
 */
public class ProfilesTest {
    @Test
    public void whenListProfilesCollectWhenListAddress() {
        Profiles prof = new Profiles();
        Address address1 = new Address("Moscow", "Leningradskay", 107, 2);
        Address address2 = new Address("Kiev", "Maydan", 16, 34);
        Address address3 = new Address("Saint-Petersburg", "Koroleva", 7, 798);
        List<Profile> profiles = List.of(
                new Profile(address1),
                new Profile(address2),
                new Profile(address3)
        );
        List<Address> result = prof.collect(profiles);
        List<Address> expect = List.of(
                address1,
                address2,
                address3
        );
        assertThat(result, is(expect));
    }
}
