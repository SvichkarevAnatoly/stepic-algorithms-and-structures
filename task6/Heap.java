import java.util.List;

public interface Heap {
    void add(int element);

    int extractMax();

    void addAll(List<Integer> elements);

    boolean isEmpty();
}
