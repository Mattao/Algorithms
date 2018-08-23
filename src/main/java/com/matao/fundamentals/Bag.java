package com.matao.fundamentals;

import java.util.Iterator;

/**
 * Created by matao on 5/27/16.
 * <p>
 * A bag is a collection where removing items is not supported.
 * Its purpose is to provide clients with the ability to collect items
 * and then to iterate through the collected items
 * (the client can also test if a bag is empty and find its number of items).
 * The order of iteration is unspecified and should be immaterial to the client.
 */
public class Bag<T> implements Iterable<T> {
    private class Node {
        T item;
        Node next;
    }

    private Node head;
    private int size;

    public void add(T item) {
        Node node = new Node();
        node.item = item;
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        bag.add(101);
        bag.add(22);
        bag.add(90);
        for (Integer integer : bag) {
            System.out.println(integer);
        }
        System.out.println(bag.getSize());
    }
}
