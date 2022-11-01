import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class Dummy {
    void throwExp() throws Exception {
        throw new Exception("Custom Exception");
    }
}

public class DemoTest {

    @Test
    public void testWithAssertFalse() {
        boolean condition = false;
        assertFalse(condition);
    }

    @Test
    public void testWithAssertTrue() {
        boolean condition = true;
        assertTrue(condition, "Provided condition is false");
    }

    @Test
    public void testWithAssertNull() {
        Object val1 = null;
        assertNull(val1);
    }

    @Test
    public void testWithAssertNotNull() {
        Object val1 = "A";
        assertNotNull(val1, "Provided value is Null");
    }


    @Test
    public void testWithAssertSame() {
        String val1 = new String("A");
        String val2 = new String("B");
        String val3 = val1;

        assertSame(val1, val3);
        assertNotSame(val1, val2);
    }

    @Test
    public void testWithAssertEqual() {
        String val1 = new String("A");
        String val2 = new String("B");
        String val3 = val1;

        assertEquals(val1, val3);
        assertNotEquals(val1, val2);
    }

    @Test
    public void testWithAssertArrayEqual() {
        char[] arr1 = {'a', 'b', 'c', 'd'};
        char[] arr2 = {'a', 'b', 'c', 'd'};

        assertArrayEquals(arr1, arr2);
    }

    @Test
    public void testWithAssertIterablesEqual() {
        Iterable<String> arrayList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        Iterable<String> linkedList = new LinkedList<>(Arrays.asList("A", "B", "C"));

        assertIterableEquals(arrayList, linkedList);
    }

    @Test
    public void testFailInAScenerio() {
        int val1 = 1;
        int val2 = 1;
        if (val1 != val2) {
            fail("Received values do not match");
        }
    }

    @Test
    public void testAssertThrows() {
        String str = null;
        assertThrows(NullPointerException.class, () -> str.length());
    }

    @Test
    public void testAssertThrowsAndThenAssert() {
        Dummy dummyClass = new Dummy();
        Exception exception = assertThrows(Exception.class, () -> dummyClass.throwExp());
        assertEquals("Custom Exception", exception.getMessage());
    }

    @Test
    public void testAssertTimeout() {
        assertTimeout(Duration.ofMillis(300), () -> {
            Thread.sleep(200);
            return "result";
        });
    }

    @Test
    public void testAssertTimeoutPreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(300), () -> {
            Thread.sleep(200);
            return "result";
        });
    }
}
