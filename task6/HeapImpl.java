import java.util.List;

public class HeapImpl implements Heap {
    private List<Integer> arr;

    public HeapImpl(List<Integer> arr) {
        this.arr = arr;
        buildHeap();
    }

    private void buildHeap() {
        final int size = arr.size();
        for (int i = size / 2 - 1; i > 0; i--) {
            siftDown(i);
        }
    }

    @Override
    public void siftDown(int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < arr.size() && arr.get(left) > arr.get(i)){
            largest = left;
        }
        if (right < arr.size() && arr.get(right) > arr.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            int tmp = arr.get(largest);
            arr.set(largest, arr.get(i));
            arr.set(i, tmp);

            siftDown(largest);
        }
    }

    @Override
    public void siftUp(int i) {

    }
}
