package data.structure;

import java.util.ArrayList;
import java.util.Collections;

public class MyHeap {
    private ArrayList<Integer> heapArray = new ArrayList<>();

    public MyHeap() {
        this.heapArray.add(null);
    }

    public boolean moveUp(int insertedIdx) {
        if (insertedIdx <= 1) {
            return false;
        }
        int parentIdx = insertedIdx / 2;
        return this.heapArray.get(insertedIdx) > this.heapArray.get(parentIdx);
    }

    public void insert(int data) {
        this.heapArray.add(data);
        int insertedIdx = this.heapArray.size() - 1;

        while (moveUp(insertedIdx)) {
            int parentIdx = insertedIdx / 2;
            Collections.swap(this.heapArray, insertedIdx, parentIdx);
            insertedIdx = parentIdx;
        }
    }

    public void maxHeapify(int insertedIdx) {
        int leftChildIdx = insertedIdx * 2;
        int rightChildIdx = insertedIdx * 2 + 1;
        int maxChildIdx = insertedIdx;

        if (leftChildIdx < this.heapArray.size()
                && this.heapArray.get(leftChildIdx) > this.heapArray.get(maxChildIdx)) {
            maxChildIdx = leftChildIdx;
        }

        if (rightChildIdx < this.heapArray.size()
                && this.heapArray.get(rightChildIdx) > this.heapArray.get(maxChildIdx)) {
            maxChildIdx = rightChildIdx;
        }

        if (maxChildIdx != insertedIdx) {
            Collections.swap(this.heapArray, maxChildIdx, insertedIdx);
            this.maxHeapify(maxChildIdx);
        }
    }

    public int pop() {
        // 루트 노드 교체 및 삭제
        Collections.swap(this.heapArray, 1, this.heapArray.size() - 1);
        Integer retData = this.heapArray.remove(this.heapArray.size() - 1);

        // 루트부터 재정렬
        this.maxHeapify(1);
        return retData;
    }

    public static void main(String[] args) {
        MyHeap myHeapTest = new MyHeap();
        myHeapTest.insert(15);
        myHeapTest.insert(10);
        myHeapTest.insert(8);
        myHeapTest.insert(5);
        myHeapTest.insert(4);
        myHeapTest.insert(20);
        System.out.println(myHeapTest.heapArray);

        myHeapTest.pop();
        System.out.println(myHeapTest.heapArray);
    }
}
