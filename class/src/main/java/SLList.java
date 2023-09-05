package main.java;

public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /** creates an empty list */
    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        size += 1;

        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public int size() {
        return size;
    }

    public String toString() {
        IntNode p = sentinel.next;
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

    public static void main(String[] args) {
        SLList L = new SLList(10);
        L.addFirst(5);
        L.addLast(15);
        System.out.println(L.size());
        System.out.println(L.toString());
    }
}
