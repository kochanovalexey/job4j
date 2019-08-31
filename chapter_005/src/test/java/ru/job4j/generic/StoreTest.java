package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 29.08.2019
 */
public class StoreTest {
    @Test
    public void whenUserStoreHasClassUserInside() {
        UserStore store = new UserStore();
        store.add(new User("21221"));
        User result = store.findById("21221");
        assertThat(result, instanceOf(User.class));
    }
    @Test
    public void whenRoleStoreHasClassRoleInside() {
        RoleStore store = new RoleStore();
        store.add(new Role("34"));
        Role result = store.findById("34");
        assertThat(result, instanceOf(Role.class));
    }
    @Test
    public void whenDeleteUserFromUserStoreThanThatUserNotFoundInUserStore() {
        UserStore store = new UserStore();
        store.add(new User("22"));
        store.delete("22");
        User result = store.findById("22");
        assertNull(result);
    }
    @Test
    public void whenReplaceRoleThanThatRoleHasInRoleStore() {
        RoleStore store = new RoleStore();
        store.add(new Role("789"));
        Role role = new Role("356");
        store.replace("789", role);
        Role result = store.findById("356");
        assertThat(result, is(role));
    }
}