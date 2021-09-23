package com.lalit;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> implements Iterable {
    private int size;
    private int capacity;
    private Object[] data;

    public Stack(int capacity){
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T elem) {
        if (size == capacity) {
            increaseCapacity();
        }
        data[size++] = elem;
    }

    // Increase the capacity to store more elements.
    private void increaseCapacity() {
        capacity *= 2;
        data = Arrays.copyOf(data, capacity);
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T elem = (T) data[--size];
        data[size] = null;
        return elem;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return (T) data[size - 1];
    }

    public boolean contains(T elem) {
        return true;
    }

    public void reverse() {
        for(int i = 0; i < size / 2; i++) {
            T temp = (T) data[i];
            data[i] = data[size - 1 - i];
            data[size - 1 - i] = temp;
        }
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private int pos = size - 1;

            @Override
            public boolean hasNext() {
                return pos >= 0;
            }

            @Override
            public T next() {
                return (T) data[pos--];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        int i = size-1;
        while (i >= 0) {
            sb.append(data[i]);
            if (i != 0) {
                sb.append(", ");
            }
            i--;
        }
        sb.append(" ]");
        return sb.toString();
    }

}
