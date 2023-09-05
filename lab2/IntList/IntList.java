package IntList;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using... recursion! */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Returns the ith item of this IntList. */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    /** Method to return a string representation of an IntList */
    public String toString() {
        if (rest == null) {
            // Converts an Integer to a String!
            return String.valueOf(first);
        } else {
            return first + " -> " + rest.toString();
        }
    }

    /**
     * Method to create an IntList from an argument list.
     * You don't have to understand this code. We have it here
     * because it's convenient with testing. It's used like this:
     *
     * IntList myList = IntList.of(1, 2, 3, 4, 5);
     * will create an IntList 1 -> 2 -> 3 -> 4 -> 5 -> null.
     *
     * You can pass in any number of arguments to IntList.of and it will work:
     * IntList mySmallerList = IntList.of(1, 4, 9);
     */
    public static IntList of(int ...argList) {
        if (argList.length == 0)
            return null;
        int[] restList = new int[argList.length - 1];
        System.arraycopy(argList, 1, restList, 0, argList.length - 1);
        return new IntList(argList[0], IntList.of(restList));
    }

    /** Returns an IntList identical to L, but with
     *  each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        if (L == null) {
            return null;
        }

        IntList ret = new IntList(L.first + x, null);
        IntList p = ret;
        L = L.rest;
        while (L != null) {
            p.rest = new IntList(L.first + x, null);
            L = L.rest;
            p = p.rest;
        }

        return ret;
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        if (L == null) {
            return null;
        }

        int size = L.size();
        int[] array = new int[size];
        int i = 0;
        while (L != null) {
            array[i] = L.first + x;
            L = L.rest;
            i++;
        }
        return IntList.of(array);
    }
}
