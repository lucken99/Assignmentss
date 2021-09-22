package com.company;

public class Queue<T> implements Iterable<T> {
    private Object[] data;
    private int front;
    private int rear;

    public Queue(int capacity) {
        data = new Object[capacity + 1];
        front = 0;
        rear = 0;
    }

    public void enqueue(T elem) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        data[rear++] = elem;
        rear = adjustsIndex(rear, data.length);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        front = adjustsIndex(front, data.length);
        return (T) data[front++];
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        front = adjustsIndex(front, data.length);
        return (T) data[front];
    }

    public boolean contains(T elem) {
        for (int i = front; i <= rear; i++) {
            if (elem == data[i]) {
                return true;
            }
        }
        return false;
    }

    public void reverse() {
        for(int i = front; i < rear / 2; i++) {
            T temp = (T) data[i];
            data[i] = data[rear - 1 - i];
            data[rear - 1 - i] = temp;
        }
    }

    public int size() {
        return adjustsIndex(rear + data.length - front, data.length);
    }

    public int adjustsIndex(int index, int size) {
        return index >= size ? index - size : index;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (front + data.length - rear) % data.length == 1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private int pos = front;

            @Override
            public boolean hasNext() {
                return pos < rear;
            }

            @Override
            public T next() {
                return (T) data[pos++];
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
        sb.append("[ ");
        int i = front;
        while (i < rear) {
            sb.append(data[i]);
            if (i != rear - 1) {
                sb.append(", ");
            }
            i++;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
