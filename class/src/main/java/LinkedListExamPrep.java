package main.java;

import org.junit.Test;

import java.util.Arrays;

public class LinkedListExamPrep {
    public static void fillGrid(int[] LL, int[] UR, int[][] S) {
        int N = S.length;
        int KL = 0, KR = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i < j) {
                    S[i][j] = UR[KR];
                    KR += 1;
                } else if (i > j) {
                    S[i][j] = LL[KL];
                    KL += 1;
                }
            }
        }
    }

    @Test
    public void testFillGrid() {
        int[] LL = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0};
        int[] UR = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[][] S = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        fillGrid(LL, UR, S);
        for (int i = 0; i < S.length; i++) {
            System.out.println(Arrays.toString(S[i]));
        }
    }

    public class IntList {
        private int first;
        private IntList rest;
        public IntList(int f, IntList r) {
            this.first = f;
            this.rest = r;
        }

        public static void evenOdd(IntList lst) {
            if (lst == null || lst.rest == null) {
                return;
            }

            IntList odd = lst.rest;
            IntList oddFirst = odd;
            while (odd != null && odd.rest != null) {
                lst.rest = lst.rest.rest;
                odd.rest = odd.rest.rest;
                lst = lst.rest;
                odd = odd.rest;
            }
            lst.rest = oddFirst;
        }

        public void print() {
            IntList p = this;
            while (p != null) {
                System.out.println(p.first + " ");
                p = p.rest;
            }
            System.out.println();
        }

        public static IntList[] partition(IntList lst, int k) {
            IntList[] array = new IntList[k];
            int index = 0;
            IntList L = reverse(lst);
            while (L != null) {
                IntList prevAtIndex = array[index];
                IntList next = L.rest;
                L.rest = prevAtIndex;
                array[index] = L;
                L = next;
                index = (index + 1) % k;
            }

            return array;
        }

        public static IntList reverse(IntList lst) {
            IntList p = lst;
            IntList prev = null;
            while (p != null) {
                IntList next = p.rest;
                p.rest = prev;
                prev = p;
                p = next;
            }

            return prev;
        }

        public static IntList reverseRecursive(IntList lst) {
            if (lst == null) {
                return null;
            }

            // base case
            if (lst.rest == null) {
                return lst;
            }

            IntList next = lst.rest;
            IntList head = reverseRecursive(next);
            next.rest = lst;
            lst.rest = null;
            return head;
        }
    }

    @Test
    public void testEvenOld() {
        IntList L = new IntList(4, null);
        L = new IntList(3, L);
        L = new IntList(2, L);
        L = new IntList(1, L);
        L = new IntList(0, L);
        IntList.evenOdd(L);
        L.print();
    }

    @Test
    public void testPartition() {
        IntList L = new IntList(1, null);
        L = new IntList(2, L);
        L = new IntList(3, L);
        L = new IntList(4, L);
        L = new IntList(5, L);
        IntList[] array = IntList.partition(L, 2);
        for (int i = 0; i < array.length; i++) {
            array[i].print();
        }
    }
}
