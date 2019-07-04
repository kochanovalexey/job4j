package ru.job4j;

import java.util.*;

/**
 * Class Класс сортировки департаментов
 *
 * @author akochanov
 * @version 1
 * @since 03.07.2019
 */
public class SortDepartment {
    /**
     * Метод сортирующий департаменты
     * @param array - массив департаментов
     * @return - отсортированный массив департаментов
     */
    public String[] sort(String[] array) {
        Set<String> treeSet = new TreeSet<String>();
        treeSet.addAll(Arrays.asList(array));
        fillMissingDepartments(treeSet, array);
        return treeSet.toArray(new String[0]);
    }

    /**
     * Метод сортирующий департаменты в обратном порядке
     * @param array - массив департаментов
     * @return - отсортированный массив департаментов
     */
    public String[] sortDescending(String[] array) {
        DepartmentComparator departmentComparator = new DepartmentComparator();
        Set<String> treeSet = new TreeSet<String>(departmentComparator);
        treeSet.addAll(Arrays.asList(array));
        fillMissingDepartments(treeSet, array);
        return treeSet.toArray(new String[0]);
    }

    /**
     * Метод заполняет недостающие подразделения в коллекции
     * @param treeSet - коллекция департаментов
     * @param array - массив депортаментов
     */
    public void fillMissingDepartments(Set<String> treeSet, String[] array) {
        for (String value : array) {
            String[] words = value.split("\\\\\\\\");
            StringBuilder temp = new StringBuilder(words[0]);
            treeSet.add(temp.toString());
            for (int i = 1; i < words.length; i++) {
                temp.append("\\\\");
                temp.append(words[i]);
                treeSet.add(temp.toString());
            }
        }
    }

    class DepartmentComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String[] firstStrings = o1.split("\\\\");
            String[] secondStrings = o2.split("\\\\");
            int result = (-1) * firstStrings[0].compareTo(secondStrings[0]);
            if (result == 0) {
                result = o1.substring(firstStrings[0].length()).compareTo(o2.substring(secondStrings[0].length()));
            }
            return result;
        }
    }
}
