package com.matao.fundamentals.exercises;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by matao on 2018/9/29.
 * <p>
 * Write a Queue implementation that uses a circular linked list,
 * which is the same as a linked list except that no links are null
 * and the value of last.next is first whenever the list is not empty.
 * Keep only one Node instance variable (last).
 */
public class Ex_1_3_29<T> implements Iterable<T> {

    private class Node {
        private T item;
        private Node next;
    }

    private int size;
    private Node last;

    public Ex_1_3_29() {
        last = null;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(T item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            node.next = node;
            last = node;
        } else {
            node.next = last.next;
            last.next = node;
            last = node;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }

        T item = last.next.item;
        if (last.next == last) {
            last = null;
        } else {
            last.next = last.next.next;
        }
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }

        return last.next.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private int n = size;
        private Node current = last;

        public boolean hasNext() {
            return n > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();

            T item = current.next.item;
            current = current.next;
            n--;
            return item;
        }
    }

    public static void main(String[] args) {
        Ex_1_3_29<Integer> queue = new Ex_1_3_29<>();
        System.out.println("-------------- after initial -------------------");
        System.out.println("size: " + queue.getSize());
        System.out.println("isEmpty: " + queue.isEmpty());

        queue.enqueue(1);
        System.out.println("-------------- after enqueue 1 item -------------------");
        System.out.println("size: " + queue.getSize());
        System.out.println("isEmpty: " + queue.isEmpty());

        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("---------------- iteration starts --------------------");
        for (Integer integer : queue) {
            System.out.println(integer);
        }

        System.out.println();

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("---------------- iteration ends   --------------------");

        System.out.println();
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("-------------- after dequeue 1 item -------------------");
        System.out.println("size: " + queue.getSize());
        System.out.println("isEmpty: " + queue.isEmpty());

        System.out.println();
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("size: " + queue.getSize());
        System.out.println("isEmpty: " + queue.isEmpty());
    }
}
