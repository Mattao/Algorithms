package com.matao.fundamentals;

import java.util.Iterator;

/**
 * Created by matao on 5/27/16.
 * The implementation of stack with node-list
 */
public class Stack<T> implements Iterable<T> {
    private class Node {
        T item;
        Node next;
    }

    private Node top;  // top of a stack
    private int size;   // size of elements

    public boolean isEmpty() {
        return top == null;    // or size == 0
    }

    public int getSize() {
        return size;
    }

    public void push(T item) {
        Node oldTop = top;
        top = new Node();
        top.item = item;
        top.next = oldTop;
        size++;
    }

    public T pop() {
        T item = top.item;
        top = top.next;
        size--;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private Node current = top;

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
        Stack<Integer> stack = new Stack<>();
        System.out.println("-------------- after initial -------------------");
        System.out.println("size: " + stack.getSize());
        System.out.println("isEmpty: " + stack.isEmpty());

        stack.push(1);
        System.out.println("-------------- after push 1 item -------------------");
        System.out.println("size: " + stack.getSize());
        System.out.println("isEmpty: " + stack.isEmpty());

        stack.push(2);
        stack.push(3);
        System.out.println("---------------- iteration starts --------------------");
        for (Integer integer : stack) {
            System.out.println(integer);
        }

        System.out.println();

        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("---------------- iteration ends   --------------------");

        System.out.println();
        System.out.println("pop: " + stack.pop());
        System.out.println("-------------- after pop 1 item -------------------");
        System.out.println("size: " + stack.getSize());
        System.out.println("isEmpty: " + stack.isEmpty());
    }
}
