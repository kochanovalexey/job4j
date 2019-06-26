package ru.job4j.comparator;

import java.util.Comparator;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 19.06.2019
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int maxIndex = left.length() > right.length() ? right.length() : left.length();
        int result = 0;
        for (int index = 0; index < maxIndex && result == 0; index++) {
            char leftChar = left.charAt(index);
            char rightChar = right.charAt(index);
            result = Character.compare(leftChar, rightChar);
        }
        if (result == 0 && left.length() != right.length()) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
