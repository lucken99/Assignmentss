package com.company;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    // Internal Node class to represent data
    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // Insert a node to the tail of linked list (default)
    public void insert(T data) {
        insertAtLast(data);
    }

    // Insert a node to the tail of the linked list
    public void insertAtLast(T data) {
        if (isEmpty()) {
            head = tail = new Node<T>(data, null, null);
        } else {
            tail.next = new Node<T>(data, tail, null);
            tail = tail.next;
        }
        size++;
    }

    // Insert an element to the beginning of this linked list
    public void insertAtFirst(T data) {
        if (isEmpty()) {
            head = tail = new Node<T>(data, null, null);
        } else {
            head.prev = new Node<T>(data, null, head);
            head = head.prev;
        }
        size++;
    }

    // Insert an element at a specified position
    public void insertAtPosition(int index, T data) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Illegal index");
        } else if (index == 0) {
            insertAtFirst(data);
        } else if (index == size) {
            insertAtLast(data);
        } else {
            Node<T> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            Node<T> newNode = new Node<T>(data, curr, curr.next);
            curr.next.prev = newNode;
            curr.next = newNode;

            size++;
        }
    }

    // Delete the first value at the head of linked list and return the data
    public T deleteFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        T data = head.data;
        head = head.next;
        --size;

        if (isEmpty()) {
            tail = null;
        } else {
            head.prev = null;     // memory cleanup
        }

        return data;
    }

    // Delete the last value at the tail and return the data of the deleted value
    public T deleteLast() {
        if (isEmpty()){
            throw new RuntimeException("Empty list");
        }
        T data = tail.data;
        tail = tail.prev;
        --size;

        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;    // memory cleanup
        }

        return data;
    }
    // Delete an arbitrary node and return the data from linked list
    private T delete(Node<T> node) {
       if (node.prev == null) return deleteFirst();
       if (node.next == null) return deleteLast();

       // deleting the node from linked list
       node.next.prev = node.prev;
       node.prev.next = node.next;

       T data = node.data;

       // memory cleanup
        node.data = null;
        node = node.prev = node.next = null;

        --size;

        return data;
    }

    // Delete a node at a particular index
    public T deleteAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index");
        }

        int i = 0;
        Node<T> curr;

        // Search from front or from back depends on index
        if (index < size / 2) {
            for (i = 0, curr = head; i != index; i++) {
                curr = curr.next;
            }
        } else {
            for (i = size - 1, curr = tail; i != index; i--) {
                curr = curr.prev;
            }
        }

        return delete(curr);
    }

    // Delete a particular value from linked list returns true if deleted else false
    public boolean delete(Object obj) {
        Node<T> curr;

        if (obj == null) {
            for (curr = head; curr != null; curr = curr.next) {
                if (curr.data == null) {
                    delete(curr);
                    return true;
                }
            }
        } else {
            for (curr = head; curr != null; curr = curr.next) {
                if (obj.equals(curr.data)) {
                    delete(curr);
                    return true;
                }
            }
        }
        return false;
    }

    public T center() {
        Node<T> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public void reverse() {
        Node<T> curr = head;
        Node<T> newHead = null;
        while (curr != null) {
            Node<T> nextNode = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = nextNode;
        }
        head = newHead;

    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T data = curr.data;
                curr = curr.next;
                return data;
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
        Node<T> curr = head;
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) {
                sb.append(", ");
            }
            curr = curr.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

}
