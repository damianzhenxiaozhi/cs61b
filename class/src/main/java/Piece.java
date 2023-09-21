package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class Piece {
    private int longitude;
    private int latitude;

    public Piece(int x, int y) {
        longitude = x;
        latitude = y;
    }

    public static Piece[][] groupByLat(Piece[] p) {
        int width = (int) Math.sqrt(p.length);
        Piece[][] latGroup = new Piece[width][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (latGroup[j][0] == null) {
                    latGroup[j][0] = p[i];
                    break;
                } else if (latGroup[j][0].latitude == p[i].latitude) {
                    int counter;
                    for (counter = 0; counter < width; counter++) {
                        if (latGroup[j][counter] == null) {
                            break;
                        }
                    }
                    latGroup[j][counter] = p[i];
                    break;
                }
            }
        }
        return latGroup;
    }

    public Piece[][] solvePuzzle(Piece[] scattered) {
        Piece[][] grouped = groupByLat(scattered);
        return null;
    }

    public static Piece[] sortHalf(Piece[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(e -> e.longitude));
        Piece[] ret = new Piece[arr.length];
        int lower = (int) Math.floor((double) arr.length / 2); // 2
        int upper = (int) Math.ceil((double) arr.length / 2); // 3

        System.arraycopy(arr, 0, ret, upper, lower);
        System.arraycopy(arr, upper, ret, 0, lower);
        ret[lower] = arr[lower];

        return ret;
    }

    public static void main(String[] args) {
        Piece[] arr = new Piece[5];
        arr[0] = new Piece(4, 5);
        arr[1] = new Piece(3, 8);
        arr[2] = new Piece(5, 7);
        arr[3] = new Piece(6, 6);
        arr[4] = new Piece(10, 10);

        Piece[] pieces = sortHalf(arr);
        System.out.println(Arrays.toString(pieces));
    }
}
