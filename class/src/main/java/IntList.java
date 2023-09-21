package main.java;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList L) {
        first = f;
        rest = L;
    }

    public void addFirst(int x) {
        IntList L = new IntList(first, rest);
        first = x;
        rest = L;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }

        return 1 + rest.size();
    }

    public String toString() {
        if (rest == null) {
            return String.valueOf(first);
        }

        return first + " -> " + rest.toString();
    }

    public void square(int x) {
        // base case
        if (rest == null) {
            rest = new IntList(first * first, new IntList(x, null));
            return;
        }

        rest.square(x);

        rest = new IntList(first * first, rest);
    }

    public void addAdjacent() {
        IntList p = this;
        while (p.rest != null) {
            if (p.first == p.rest.first) {
                p.first = 2 * p.first;
                p.rest = p.rest.rest;
            } else {
                p = p.rest;
            }
        }
    }

    public static void main(String[] args) {
        IntList L = new IntList(3, null);
        L.addFirst(2);
        L.addFirst(1);
        L.square(7);
        System.out.println(L.toString());
        L.square(8);
        System.out.println(L.toString());
        L.addAdjacent();
        System.out.println(L.toString());
    }
}
