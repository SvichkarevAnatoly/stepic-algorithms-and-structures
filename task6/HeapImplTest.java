import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class HeapImplTest {
    private AlgorithmData parseTestInputLine(String line) {
        return new AlgorithmData(line.replace("|", " "));
    }

    @Test
    public void testExtractMax() throws Exception {
        final List<Integer> arr = Arrays.asList(1, 6, 3);
        final HeapImpl heap = new HeapImpl(arr);
        final int max = heap.extractMax();
        assertEquals(6, max);
    }

    @Test
    public void testExtractAll() throws Exception {
        final List<Integer> arr = Arrays.asList(1, 3);
        final HeapImpl heap = new HeapImpl(arr);
        assertEquals(3, heap.extractMax());
        assertEquals(1, heap.extractMax());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExtractException() throws Exception {
        final Heap heap = new HeapImpl(Collections.<Integer>emptyList());
        heap.extractMax();
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
        final AlgorithmData ad = parseTestInputLine(inputString);

        final ArrayList<Integer> expectedFruitMasses = new ArrayList<>(Arrays.asList(1, 2, 2));
        assertEquals(expectedFruitMasses.size(), ad.fruitMasses.size());
        assertEquals(expectedFruitMasses, ad.fruitMasses);
        assertEquals(2, ad.K);
    }

    @Test
    public void testAlgorithmOnTaskSample() throws Exception {
        final ArrayList<Integer> fruitMasses = new ArrayList<>(Arrays.asList(1, 2, 2));
        final AlgorithmData ad = new AlgorithmData(fruitMasses, 2);

        final Heap heap = new HeapImpl(ad.fruitMasses);
        final int approaches = Main.measureApproaches(heap, ad.K);

        assertEquals(4, approaches);
    }

    @Test
    public void testAlgorithmOnCommentSample() throws Exception {
        final ArrayList<Integer> fruitMasses = new ArrayList<>(Arrays.asList(4, 3, 5));
        final AlgorithmData ad = new AlgorithmData(fruitMasses, 6);

        final Heap heap = new HeapImpl(ad.fruitMasses);
        final int approaches = Main.measureApproaches(heap, ad.K);

        assertEquals(4, approaches);
    }

    @Test
    public void testAlgorithmOnCommentSample2() throws Exception {
        final ArrayList<Integer> fruitMasses = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1));
        final AlgorithmData ad = new AlgorithmData(fruitMasses, 3);

        final Heap heap = new HeapImpl(ad.fruitMasses);
        final int approaches = Main.measureApproaches(heap, ad.K);

        assertEquals(3, approaches);
    }

    @Test
    public void testAlgorithmOnCommentSample3() throws Exception {
        final ArrayList<Integer> fruitMasses = new ArrayList<>(Arrays.asList(4, 1));
        final AlgorithmData ad = new AlgorithmData(fruitMasses, 6);

        final Heap heap = new HeapImpl(ad.fruitMasses);
        final int approaches = Main.measureApproaches(heap, ad.K);

        assertEquals(1, approaches);
    }

    @Test
    public void testAlgorithmOnCommentSample2_1() throws Exception {
        final String args = "12|1 4 8 9 10 40 45 50 60 70 80 100|100";
        final AlgorithmData ad = parseTestInputLine(args);

        final Heap heap = new HeapImpl(ad.fruitMasses);
        final int approaches = Main.measureApproaches(heap, ad.K);

        assertEquals(13, approaches);
    }

    @Test
    public void testAlgorithmOnCommentSample2_2() throws Exception {
        final String args = "7|1 3 5 7 9 11 13|25";
        final AlgorithmData ad = parseTestInputLine(args);

        final Heap heap = new HeapImpl(ad.fruitMasses);
        final int approaches = Main.measureApproaches(heap, ad.K);

        assertEquals(5, approaches);
    }

    @Test
    public void testAlgorithmOnCommentSample2_3() throws Exception {
        final String args = "10| 1 1 1 1 1 1 1 1 1 10|11";
        final AlgorithmData ad = parseTestInputLine(args);

        final Heap heap = new HeapImpl(ad.fruitMasses);
        final int approaches = Main.measureApproaches(heap, ad.K);

        assertEquals(4, approaches);
    }
}