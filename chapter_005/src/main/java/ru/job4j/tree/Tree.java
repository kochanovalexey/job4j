package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * Class Класс Tree
 *
 * @author akochanov
 * @version 1
 * @since 14.10.2019
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * Root
     */
    Node<E> root;

    public Tree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> opParent = this.findBy(parent);
        boolean result = opParent.isPresent() && !this.findBy(child).isPresent();
        if (result) {
            Node<E> sourceParent = opParent.get();
            sourceParent.add(new Node<>(child));
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        return new Iterator<E>() {
            Queue<Node<E>> queueData = data;

            @Override
            public boolean hasNext() {
                return !this.queueData.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NullPointerException();
                }
                Node<E> node = data.poll();
                for (Node<E> child : node.leaves()) {
                    data.offer(child);
                }
                return node.getValue();
            }
        };
    }
}
