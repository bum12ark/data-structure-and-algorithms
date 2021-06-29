package data.structure;

import java.util.ArrayList;
import java.util.List;

public class MyQueue<T> {
    private List<T> queue = new ArrayList<>();

    public void enqueue(T t) {
        queue.add(t);
    }

    public T dequeue() {
        if (queue.isEmpty()) return null;
        return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<Integer>();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
    }
}
