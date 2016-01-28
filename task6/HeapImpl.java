import java.util.ArrayList;
import java.util.List;

public class HeapImpl implements Heap {
    private List<Integer> arr;

    public HeapImpl() {
        arr = new ArrayList<>();
    }

    public HeapImpl(List<Integer> arr) {
        this.arr = new ArrayList<>(arr);
        buildHeap();
    }

    private void buildHeap() {
        final int size = arr.size();
        for (int i = size / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    public void siftDown(int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < arr.size() && arr.get(left) > arr.get(i)) {
            largest = left;
        }
        if (right < arr.size() && arr.get(right) > arr.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            siftDown(largest);
        }
    }

    private void swap(int i1, int i2) {
        int tmp = arr.get(i2);
        arr.set(i2, arr.get(i1));
        arr.set(i1, tmp);
    }

    public void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (arr.get(i) <= arr.get(parent)) {
                return;
            }
            swap(i, parent);
            i = parent;
        }
    }

    @Override
    public void add(int element) {
        arr.add(element);
        siftUp(arr.size() - 1);
    }

    @Override
    public void addAll(List<Integer> elements) {
        elements.forEach(this::add);
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public int extractMax() {
        if (arr.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int result = arr.get(0);
        final int removed = arr.remove(arr.size() - 1);
        if (!arr.isEmpty()) {
            arr.set(0, removed);
            siftDown(0);
        }
        return result;
    }

    @Override
    public int popMax() {
        if (arr.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return arr.get(0);
    }
}
