package deque;

public class LinkedListDeque<T> {
    private static class ListNode<T> {
        private T item;
        private ListNode<T> next;
        private ListNode<T> prev;

        public ListNode(T item, ListNode<T> prev, ListNode<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private ListNode<T> sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new ListNode<>(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T x) {
        ListNode<T> p = new ListNode<T>(x, sentinel, sentinel.next);
        sentinel.next.prev = p;
        sentinel.next = p;

        size += 1;
    }

    public void addLast(T x) {
        ListNode<T> p = new ListNode<T>(x, sentinel.prev, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;

        size += 1;
    }

    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }

        size -= 1;
        ListNode<T> p = sentinel.next;
        T ret = p.item;
        sentinel.next = p.next;
        p.next.prev = sentinel;
        return ret;
    }

    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }

        size -= 1;
        ListNode<T> p = sentinel.prev;
        T ret = p.item;
        sentinel.prev = p.prev;
        p.prev.next = sentinel;
        return ret;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        ListNode<T> p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " -> ");
            p = p.next;
        }
    }
}
