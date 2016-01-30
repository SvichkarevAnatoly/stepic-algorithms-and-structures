import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class AlgorithmTest {
    private int expected;
    private String argsLine;

    public AlgorithmTest(String argsLine, int expected) {
        this.expected = expected;
        this.argsLine = argsLine;
    }

    private AlgorithmData parseTestInputLine(String line) {
        return new AlgorithmData(line.replace("|", " "));
    }

    @Parameterized.Parameters(name = "{index}: \"{0}\"->{1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"12|1 4 8 9 10 40 45 50 60 70 80 100|100", 13},
                {"7|1 3 5 7 9 11 13|25", 5},
                {"10| 1 1 1 1 1 1 1 1 1 10|11", 4}
        });
    }

    @Test
    public void testAlgorithmFromCommentDatasets() throws Exception {
        final AlgorithmData ad = parseTestInputLine(argsLine);
        final Heap heap = new HeapImpl(ad.fruitMasses);
        final int approaches = Main.measureApproaches(heap, ad.K);

        assertEquals(expected, approaches);
    }
}
