package main.java;

public class SLList<T> {
    private static class ListNode<T> {
        public T item;
        public ListNode<T> next;

        public ListNode(T i, ListNode n) {
            item = i;
            next = n;
        }
    }

    private ListNode<T> sentinel;
    private int size;

    /** creates an empty list */
    public SLList() {
        sentinel = new ListNode<T>(null, null);
        size = 0;
    }

    public SLList(T x) {
        sentinel = new ListNode<T>(null, null);
        sentinel.next = new ListNode<T>(x, null);
        size = 1;
    }

    public SLList(T[] array) {
        sentinel = new ListNode<T>(null, null);
        size = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            sentinel.next = new ListNode<T>(array[i], sentinel.next);
            size += 1;
        }
    }

    public void addFirst(T x) {
        sentinel.next = new ListNode<T>(x, sentinel.next);
        size += 1;
    }

    public T getFirst() {
        return sentinel.next.item;
    }

    public void addLast(T x) {
        size += 1;

        ListNode<T> p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new ListNode<T>(x, null);
    }

    public int size() {
        return size;
    }

    public String toString() {
        ListNode<T> p = sentinel.next;
        if (p == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder(String.valueOf(p.item));
        p = p.next;
        while (p != null) {
            sb.append(" -> ");
            sb.append(p.item);
            p = p.next;
        }

        return sb.toString();
    }

    public void deleteFirst() {
        if (sentinel.next == null) {
            return;
        }

        sentinel.next = sentinel.next.next;
        size -= 1;
    }

    public T get(int i) {
        ListNode<T> p = sentinel.next;
        int s = 0;
        while (s <= i && p != null) {
            p = p.next;
        }

        return p == null ? null : p.item;
    }

    public static void main(String[] args) {
        SLList L = new SLList(10);
        L.addFirst(5);
        L.addLast(15);
        System.out.println(L.size());
        System.out.println(L.toString());
    }
}
