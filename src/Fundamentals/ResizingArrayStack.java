package Fundamentals;

import java.util.Iterator;

/**
 * Created by matao on 5/27/16.
 * The implementation of auto-scaled array stack
 */
public class ResizingArrayStack<T> implements Iterable<T>{
    private T[] array = (T[]) new Object[1];    // initial capacity is 1
    private int size;                           // the size of elements

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }

    private void resize(int newCapacity) {
        T[] tempArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }

    public void push(T item) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        array[size++] = item;
    }

    public T pop() {
        T item = array[--size];
        array[size] = null; // 避免对象游离
        if (size > 0 && size == getCapacity() / 4) {
            resize(getCapacity() / 2);
        }
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {

        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return array[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
        System.out.println("-------------- after initial -------------------");
        System.out.println("capacity: " + stack.getCapacity());
        System.out.println("size: " + stack.getSize());
        System.out.println("isEmpty: " + stack.isEmpty());

        stack.push(1);
        System.out.println("-------------- after push 1 item -------------------");
        System.out.println("capacity: " + stack.getCapacity());
        System.out.println("size: " + stack.getSize());
        System.out.println("isEmpty: " + stack.isEmpty());

        stack.push(2);
        System.out.println("-------------- after push another 1 item -------------------");
        System.out.println("capacity: " + stack.getCapacity());
        System.out.println("size: " + stack.getSize());
        System.out.println("isEmpty: " + stack.isEmpty());

        stack.push(3);
        System.out.println("-------------- after push another 1 item -------------------");
        System.out.println("capacity: " + stack.getCapacity());
        System.out.println("size: " + stack.getSize());
        System.out.println("isEmpty: " + stack.isEmpty());

        System.out.println("-------------- Iterator start -------------------");
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-------------- Iterator end -------------------");

        stack.pop();
        System.out.println("-------------- after pop 1 item -------------------");
        System.out.println("capacity: " + stack.getCapacity());
        System.out.println("size: " + stack.getSize());
        System.out.println("isEmpty: " + stack.isEmpty());

        stack.pop();
        System.out.println("-------------- after pop another 1 item -------------------");
        System.out.println("capacity: " + stack.getCapacity());
        System.out.println("size: " + stack.getSize());
        System.out.println("isEmpty: " + stack.isEmpty());

    }
}
