package ru.job4j.list;

import java.util.Arrays;

/**
 * Class Класс Node
 *
 * @author akochanov
 * @version 1
 * @since 11.09.2019
 */
public class Node<T> {

    /**
     * Значение
     */
    T value;

    /**
     * Следующий Node
     */
    Node<T> next;

    /**
     * Конструктор
     * @param value - значение
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Метод проверяющий на зацикленность узлов
     * @param first - первый Node
     * @return - результат
     */
    public static boolean hasCycle(Node first) {
        Node currentNode = first;
        Node[] nodes = new Node[10];
        int index = 0;
        while (currentNode.next != null) {
            for (int i = 0; i < index; i++){
                if (currentNode == nodes[i]) {
                    return true;
                }
            }
            if (index == nodes.length) {
                Arrays.copyOf(nodes, (index * 3) / 2 + 1);
            }
            nodes[index++] = currentNode;
            currentNode = currentNode.next;
        }
        return false;
    }
}
