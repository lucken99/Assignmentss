package com.lalit;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DoublyLinkedList<Integer> dl = new DoublyLinkedList<Integer>();
        dl.insert(2);
        dl.insert(3);
        dl.insert(4);
        dl.insert(5);
        System.out.println(dl);
        dl.reverse();
        System.out.println(dl);
        System.out.println(dl.center());
//        System.out.println(dl);

        Stack<Integer> st = new Stack<Integer>(5);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        System.out.println(st);
        Iterator it = st.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        st.reverse();
        System.out.println(st);

        Queue<Integer> q = new Queue<Integer>(16);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q);
        System.out.println(q.contains(6));
        q.reverse();
        System.out.println(q);

        PriorityQueue<String> pq = new PriorityQueue<String>();
        pq.enqueue(10, "lalit");
        pq.enqueue(8, "kartik");
        pq.enqueue(4, "rohit");
        pq.enqueue(1, "jhgff");
        System.out.println(pq);



        HashTable<Integer, String> ht = new HashTable<Integer, String>();
        ht.insert(1, "lucky");
        ht.insert(2, "lalit");
        ht.insert(3, "rohit");
        ht.insert(4, "kartik");
        System.out.println(ht);
    }
}
