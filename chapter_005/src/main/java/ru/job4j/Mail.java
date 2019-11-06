package ru.job4j;

import java.util.*;

/**
 * Class Класс Mail
 *
 * @author akochanov
 * @version 1
 * @since 05.11.2019
 */
public class Mail {

    /**
     * Найти одинаковые аккаунты
     * @param accounts - входящий map с акаунтами и почтой
     * @return - map с одинаковыми аккаунтами
     */
    public Map<String, Set<String>> findDuplicateAccounts(Map<String, List<String>> accounts) {
        Map<String, String> temp = new HashMap<>();
        Map<String, Set<String>> extendedAccount = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : accounts.entrySet()) {
            String foundUser = entry.getKey();
            for (String mail : entry.getValue()) {
                if (temp.containsKey(mail)) {
                    foundUser = temp.get(mail);
                    break;
                }
            }
            if (!extendedAccount.containsKey(foundUser)) {
                extendedAccount.put(foundUser, new HashSet<String>());
            }
            Set<String> mailList = extendedAccount.get(foundUser);
            for (String mail : entry.getValue()) {
                temp.put(mail, foundUser);
                mailList.add(mail);
            }
         }
        return  extendedAccount;
    }
}
