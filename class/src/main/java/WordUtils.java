package main.java;

public class WordUtils {

    public static String longestWord(SLList<String> list) {
        int size = list.size();
        String s = "";
        for (int i = 0; i < size; i++) {
            if (list.get(i).length() > s.length()) {
                s = list.get(i);
            }
        }

        return s;
    }
}
