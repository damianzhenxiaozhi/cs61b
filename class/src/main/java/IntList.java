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

    public String toString() {
        if (rest == null) {
            return String.valueOf(first);
        }

        return first + " -> " + rest.toString();
    }

    public static void main(String[] args) {
        IntList L = new IntList(3, null);
        L.addFirst(2);
        System.out.println(L.toString());
    }
}
