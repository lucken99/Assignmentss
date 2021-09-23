package com.lalit;

public class PriorityQueue<T> implements Iterable<T> {

    private HeapNode<T>[] heap;
    private int size;
    private int maxCapacity;


    private static class HeapNode<T> {
        private int priority;
        private T data;

        public HeapNode(int priority, T data) {
            this.priority = priority;
            this.data = data;
        }

        public String toString() {
            return "HeapNode priority: " + priority + " data: " + data;
        }
    }

    public PriorityQueue() {
        this(256);
    }
    public PriorityQueue(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        HeapNode<T>[] heap = (HeapNode<T>[]) new HeapNode[maxCapacity];
        this.heap = heap;
        size = 0;
    }
    public PriorityQueue(int[] priorities, T[] data) {
        this(data.length);
        for (int i = 0; i < data.length; i++) {
            enqueue(priorities[i], data[i]);
        }
    }

    public int size() {
        return size;
    }

    public void enqueue(int priority, T elem) {
        if (size() >= maxCapacity) {
            return;
        }

        heap[size()] = new HeapNode<T>(priority, elem);
        size++;
        percolateUp(getIndexAtLast());
    }

    public T peekMin() {
        if (size() <= 0) {
            return null;
        }

        HeapNode<T> result = heap[0];
        if (result != null) {
            return result.data;
        }

        return null;
    }

    public T dequeueMin() {
        if (size() <= 0) {
            return null;
        }

        HeapNode<T> min = heap[0];
        if (size() == 1) {
            heap[0] = null;
            size--;
        } else {
            HeapNode<T> last = heap[getIndexAtLast()];
            heap[getIndexAtLast()] = null;
            size--;
            heap[0] = last;
            percolateDown(0);
        }

        if (min != null) {
            return min.data;
        }

        return null;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

        HeapNode<T>[] heap = (HeapNode<T>[]) new HeapNode[maxCapacity];
        this.heap = heap;
        size = 0;
    }

    public T[] toArray() {
        T[] result = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = (T) heap[i].data;
        }
        return result;
    }


    private void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = getParentIndex(index);
            if (heap[index].priority < heap[parentIndex].priority) {
                swap(index, parentIndex);
            } else {
                return;
            }
            index = getParentIndex(index);
        }
    }

    private void percolateDown(int index) {
        while (index * 2 + 1 < size) {
            int minChildIndex = getMinChildIndex(index);
            if (heap[minChildIndex].priority < heap[index].priority) {
                swap(index, minChildIndex);
            } else {
                return;
            }
            index = minChildIndex;
        }
    }

    private void swap(int indexA, int indexB) {
        HeapNode<T> temp = heap[indexA];
        heap[indexA] = heap[indexB];
        heap[indexB] = temp;
    }

    public int getIndexAtLast() {
        return size - 1;
    }

    public int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    public int getLeftChildIndex(int i) {
        return i * 2 + 1;
    }

    public int getRightChildIndex(int i) {
        return i * 2 + 2;
    }

    public int getMinChildIndex(int index) {
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);

        if (right > getIndexAtLast()) {
            return left;
        }
        if (heap[left].priority < heap[right].priority) {
            return left;
        } else {
            return right;
        }
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int pos = 0;
            @Override
            public boolean hasNext() {
               return pos < size;
            }

            @Override
            public T next() {
               return (T) heap[pos++].data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < size; i++) {
            sb.append(heap[i].data);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(" }");
        return sb.toString();
    }

}
