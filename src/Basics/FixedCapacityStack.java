package Basics;

/**
 * Created by matao on 5/27/16.
 */
public class FixedCapacityStack<T> {
    private T[] array;
    private int size;       // 元素数量
    private int capacity;   // 容量

    public FixedCapacityStack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.array = (T[]) new Object[capacity];
    }

    public void push(T item) {
        if (size == capacity) {
            throw new RuntimeException("stack over flow!");
        }
        array[size++] = item;
    }

    public T pop() {
        return array[--size];
    }

    public boolean isEmpty() {
        return size == 0;
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

        fixedCapacityStack.push(4);
        System.out.println("-------------- after push another 1 item, stack over flow -------------------");
        System.out.println("capacity: " + fixedCapacityStack.getCapacity());
        System.out.println("size: " + fixedCapacityStack.getSize());
        System.out.println("isEmpty: " + fixedCapacityStack.isEmpty());
    }
}
