package com.matao.fundamentals;

import java.util.Iterator;

/**
 * Created by matao on 5/27/16.
 * <p>
 * 背包是一种不支持从中删除元素的集合数据类型
 * 它的目的就是用来收集元素并迭代遍历所有元素,
 * 迭代的顺序不确定
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
