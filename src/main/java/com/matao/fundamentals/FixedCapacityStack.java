package com.matao.fundamentals;

/**
 * Created by matao on 5/27/16.
 * <p>
 * Fixed Capacity Stack
 */
public class FixedCapacityStack<T> {
    private T[] array;
    private int size;       // current size of this stack
    private int capacity;   // the fixed capacity of this stack

    public FixedCapacityStack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        // generic array creation is disallowed in Java. Instead, we need to use a cast
        this.array = (T[]) new Object[capacity];
    }

    public void push(T item) {
        if (isFull()) {
            throw new RuntimeException("Fixed capacity stack overflow!");
        }
        array[size++] = item;
    }

    public T pop() {
        return array[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public static void main(String[] args) {
        FixedCapacityStack<Integer> fixedCapacityStack = new FixedCapacityStack<>(3);
        System.out.println("-------------- after initial -------------------");
        System.out.println("capacity: " + fixedCapacityStack.getCapacity());
        System.out.println("size: " + fixedCapacityStack.getSize());
        System.out.println("isEmpty: " + fixedCapacityStack.isEmpty());

        fixedCapacityStack.push(1);
        System.out.println("-------------- after push 1 item -------------------");
        System.out.println("capacity: " + fixedCapacityStack.getCapacity());
        System.out.println("size: " + fixedCapacityStack.getSize());
        System.out.println("isEmpty: " + fixedCapacityStack.isEmpty());

        fixedCapacityStack.push(2);
        fixedCapacityStack.push(3);
        System.out.println("-------------- after push another 2 items -------------------");
        System.out.println("capacity: " + fixedCapacityStack.getCapacity());
        System.out.println("size: " + fixedCapacityStack.getSize());
        System.out.println("isEmpty: " + fixedCapacityStack.isEmpty());

        System.out.println("-------------- after pop 1 item -------------------");
        fixedCapacityStack.pop();
        System.out.println("capacity: " + fixedCapacityStack.getCapacity());
        System.out.println("size: " + fixedCapacityStack.getSize());
        System.out.println("isEmpty: " + fixedCapacityStack.isEmpty());

        fixedCapacityStack.push(4);
        fixedCapacityStack.push(5);
        System.out.println("-------------- after push another 2 item2, stack over flow -------------------");
        System.out.println("capacity: " + fixedCapacityStack.getCapacity());
        System.out.println("size: " + fixedCapacityStack.getSize());
        System.out.println("isEmpty: " + fixedCapacityStack.isEmpty());
    }
}
