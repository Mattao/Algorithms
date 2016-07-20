package Fundamentals;

import java.util.Iterator;

/**
 * Created by matao on 5/27/16.
 */
public class Queue<T> implements Iterable<T>{
    private class Node {
        T item;
        Node next;
    }

    private Node head;  // point to the first node
    private Node tail;  // point to the last node
    private int size;   // size of elements

    public boolean isEmpty() {
        return head == null;    // or size == 0
    }

    public int getSize() {
        return size;
    }

    public void enqueue(T item) {
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            tail = node;
            head = tail;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T dequeue() {
        T item = head.item;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        }
        size--;
        return item;
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
        Queue<Integer> queue = new Queue<>();
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
        for (Integer integer: queue) {
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
