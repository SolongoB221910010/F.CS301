import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    @Test
    public void testFibonacci() {
        Map<Integer, Integer> cache = new HashMap<>();
        assertEquals(0, Fibonacci.fibonacci(0, cache));
        assertEquals(1, Fibonacci.fibonacci(1, cache));
        assertEquals(5, Fibonacci.fibonacci(5, cache));
        assertEquals(55, Fibonacci.fibonacci(10, cache));
        assertEquals(6765, Fibonacci.fibonacci(20, cache));
    }
}
