import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HeapImplTest {
    @Test
    public void testExtractMax() throws Exception {
        List<Integer> arr = Arrays.asList(1, 6, 3);
        final HeapImpl heap = new HeapImpl(arr);
        final int max = heap.extractMax();
        assertEquals(6, max);
    }
}