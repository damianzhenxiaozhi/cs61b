package main.java;

import java.util.Arrays;

public class ArrayHigherOrder {
    public static class LengthComparator {
        public static int compare(String s1, String s2) {
            if (s1 != null && s2 == null) {
                return 1;
            } else if (s1 == null && s2 != null) {
                return -1;
            } else if (s1 == null && s2 == null) {
                return 0;
            } else {
                return s1.length() - s2.length();
            }
        }
    }

    public static String max(String[] a, LengthComparator c) {
        String maxStr = a[0];
        for (int i = 0; i < a.length; i += 1) {
            if (c.compare(a[i], maxStr) > 0) {
                maxStr = a[i];
            }
        }
        return maxStr;
    }

    public static String[][] step(String[][] arr) {
        String[][] stepped = new String[arr.length][arr.length];
        for (int i = 1; i < arr.length - 1; i += 1) {
            for (int j = 1; j < arr.length - 1; j += 1) {
                String[] temp = new String[9];
                int r = 0;
                for (int k = -1; k <= 1; k += 1) {
                    for (int m = -1; m <= 1; m += 1) {
                        temp[r] = arr[i+k][j+m];
                        r += 1;
                    }
                }
                stepped[i][j] = max(temp, new LengthComparator());
            }
        }

        return stepped;
    }

    public static void main(String[] args) {
        String[][] arr = {{null, null, null, null}, {null, "cat", "dogs", null}, {null, "cat", "dogs", null}, {null, null, null, null}};
        String[][] stepped = step(arr);
        System.out.println(Arrays.toString(stepped));
    }
}
