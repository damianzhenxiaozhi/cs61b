package IntList;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IncreaseTest {
    @Test
    public void testIncrList() {
        IntList L = IntList.of(3, 4, 5);
        IntList L1 = IntList.incrList(L, 2);

        assertEquals("5 -> 6 -> 7", L1.toString());
        assertEquals("3 -> 4 -> 5", L.toString());
    }

    @Test
    public void testDIncrList() {
        IntList L = IntList.of(3, 4, 5);
        IntList L1 = IntList.incrList(L, 2);

        assertEquals("5 -> 6 -> 7", L1.toString());
        assertEquals("3 -> 4 -> 5", L.toString());
    }
}
