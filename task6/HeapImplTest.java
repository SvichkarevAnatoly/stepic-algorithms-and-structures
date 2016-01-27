import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class HeapImplTest {
    @Test
    public void testExtractMax() throws Exception {
        final List<Integer> arr = Arrays.asList(1, 6, 3);
        final HeapImpl heap = new HeapImpl(arr);
        final int max = heap.extractMax();
        assertEquals(6, max);
    }

    @Test
    public void testAdd() throws Exception {
        final List<Integer> arr = Collections.singletonList(1);
        final HeapImpl heap = new HeapImpl(arr);
        heap.add(6);
        final int max = heap.extractMax();
        assertEquals(6, max);
    }

    @Test
    public void testAlgorithmDataParse() throws Exception {
        final String inputString =
                "3\n" +
                "1 2 2\n" +
                "2";
        final Scanner sc = new Scanner(inputString);
        final AlgorithmData ad = new AlgorithmData(sc);

        final ArrayList<Integer> expectedFruitMasses = new ArrayList<>(Arrays.asList(1, 2, 2));
        assertEquals(expectedFruitMasses.size(), ad.fruitMasses.size());
        assertEquals(expectedFruitMasses, ad.fruitMasses);
        assertEquals(2, ad.K);
    }
}