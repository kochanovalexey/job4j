package ru.job4j;

import org.junit.Test;

import java.util.*;
import static org.junit.Assert.*;

/**
 * Class Класс тестирующий Mail
 *
 * @author akochanov
 * @version 1
 * @since 05.11.2019
 */
public class MailTest {
    @Test
    public void testMail() {
        Mail mail = new Mail();
        Map<String, List<String>> accounts = new LinkedHashMap<>( );
        accounts.put("user1", Arrays.asList("xxx@ya.ru","foo@gmail.com", "lol@mail.ru"));
        accounts.put("user2", Arrays.asList("foo@gmail.com", "ups@pisem.net"));
        accounts.put("user3", Arrays.asList("xyz@pisem.net", "vasya@pupkin.com"));
        accounts.put("user4", Arrays.asList("ups@pisem.net", "aaa@bbb.ru"));
        accounts.put("user5", Arrays.asList("xyz@pisem.net"));

        Map<String, List<String>> extended = new HashMap<>();
        Set<String> user1 = new HashSet<String>(Arrays.asList("xxx@ya.ru","foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru"));
        Set<String> user3 = new HashSet<String>(Arrays.asList("xyz@pisem.net", "vasya@pupkin.com"));

        Map<String, Set<String>> result = mail.findDuplicateAccounts(accounts);
        assertTrue(result.get("user1").containsAll(user1));
        assertTrue(result.get("user3").containsAll(user3));
    }
}
