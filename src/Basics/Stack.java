package Basics;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by matao on 5/27/16.
 */
public class Stack<T> implements Iterable<T>{
    private int initialCapacity;    // 初始时stack的大小
    private int size;               // stack中元素数量

    private T[] array;

    public Stack(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.size = 0;

        array = (T[]) new Object[initialCapacity];
    }

    public void push(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[size] = item;
        size++;
    }

    public T pop() {
        size--;
        T popItem = array[size];
        array[size] = null;     // 该元素被pop,不会再访问,但因为还被数组引用故不会被回收。故将该引用置为null
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return popItem;
    }

    public void resize(int newCapacity) {
        T[] tmp = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = array[i];
        }
        array = tmp;
    }

    // 获取stack中含有元素的数量
    public int getSize() {
        return size;
    }

    // 获取stack当前容量
    public int getCapacity() {
        return array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 迭代
    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<T> {

        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            --i;
            return array[i];
        }

        @Override
        public void remove() {

        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(3);
        System.out.println("size: " + stack.getSize());
        System.out.println("capacity: " + stack.getCapacity());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("--------------- after push 3 items ----------------------");
        System.out.println("size: " + stack.getSize());
        System.out.println("capacity: " + stack.getCapacity());

        stack.push(4);
        System.out.println("--------------- after push another 1 item ----------------------");
        System.out.println("size: " + stack.getSize());
        System.out.println("capacity: " + stack.getCapacity());

        stack.pop();
        stack.pop();
        System.out.println("--------------- after pop 2 items ----------------------");
        System.out.println("size: " + stack.getSize());
        System.out.println("capacity: " + stack.getCapacity());

        stack.pop();
        System.out.println("--------------- after pop another 1 item ----------------------");
        System.out.println("size: " + stack.getSize());
        System.out.println("capacity: " + stack.getCapacity());
    }
}
