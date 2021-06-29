package data.structure;

import java.util.ArrayList;
import java.util.Collections;

public class MaxHeap {
    private ArrayList<Integer> heapArray;

    public MaxHeap(int data) {
        this.init(data);
    }

    public void init(int data) {
        this.heapArray = new ArrayList<>();
        this.heapArray.add(null);
        this.heapArray.add(data);
    }

    public boolean moveUp(int insertedIdx) {
        if (insertedIdx <= 1) { // root node 일 경우
            return false;
        }
        int parentIdx = insertedIdx / 2;
        return this.heapArray.get(insertedIdx) > this.heapArray.get(parentIdx);
    }

    public void insert(int data) {
        if (heapArray == null) {
            this.init(data);
            return;
        }

        this.heapArray.add(data);
        int insertedIdx = this.heapArray.size() - 1;

        while (this.moveUp(insertedIdx)) {
            int parentIdx = insertedIdx / 2;
            Collections.swap(this.heapArray, insertedIdx, parentIdx);
            insertedIdx = parentIdx;
        }
    }

    public boolean moveDown(int poppedIdx) {
        int leftChildPoppedIdx = poppedIdx * 2;
        int rightChildPoppedIdx = poppedIdx * 2 + 1;

        // CASE1: 왼쪽 자식 노드도 없을 때 (자식 노드가 하나도 없을 때)
        if (leftChildPoppedIdx >= this.heapArray.size()) {
            return false;
        }
        // CASE2: 오른쪽 자식 노드만 없을 때
        if (rightChildPoppedIdx >= this.heapArray.size()) {
            return this.heapArray.get(leftChildPoppedIdx) > this.heapArray.get(poppedIdx);
        }
        // CASE3: 왼쪽 오른쪽 자식 노드가 모두 있을 때
        if (this.heapArray.get(leftChildPoppedIdx) > this.heapArray.get(rightChildPoppedIdx)) {
            return this.heapArray.get(leftChildPoppedIdx) > this.heapArray.get(poppedIdx);
        }
        if (this.heapArray.get(leftChildPoppedIdx) <= this.heapArray.get(rightChildPoppedIdx)) {
            return this.heapArray.get(rightChildPoppedIdx) > this.heapArray.get(poppedIdx);
        }

        return false;
    }

    public int pop() {
        if (this.heapArray == null) {
            return -1;
        }
        int returnedData = this.heapArray.get(1);
        // root 노드를 마지막 값으로 변경
        this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
        this.heapArray.remove(this.heapArray.size() - 1);

        int poppedIdx = 1;
        while (moveDown(poppedIdx)) {
            int leftChildPoppedIdx = poppedIdx * 2;
            int rightChildPoppedIdx = poppedIdx * 2 + 1;

            // CASE1: 오른쪽 노드만 없을 때
            if (rightChildPoppedIdx >= this.heapArray.size()) {
                if (this.heapArray.get(leftChildPoppedIdx) > this.heapArray.get(poppedIdx)) {
                    Collections.swap(this.heapArray, leftChildPoppedIdx, poppedIdx);
                    poppedIdx = leftChildPoppedIdx;
                }
            }
            // CASE2: 왼쪽/오른쪽 자식 노드가 모두 있을 때
            else {
                if (this.heapArray.get(leftChildPoppedIdx) > this.heapArray.get(rightChildPoppedIdx)) {
                    if (this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildPoppedIdx)) {
                        Collections.swap(this.heapArray, leftChildPoppedIdx, poppedIdx);
                        poppedIdx = leftChildPoppedIdx;
                    }
                } else {
                    if (this.heapArray.get(poppedIdx) < this.heapArray.get(rightChildPoppedIdx)) {
                        Collections.swap(this.heapArray, rightChildPoppedIdx, poppedIdx);
                        poppedIdx = rightChildPoppedIdx;
                    }
                }
            }
        }
        return returnedData;
    }
}
