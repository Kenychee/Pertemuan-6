package strukdat;

import java.util.Random;

public class MainProgramHeap {
    public static void main(String[] args) {
        int[] sizes = { 50000, 100000, 200000, 400000 };
        Random rand = new Random();
        for (int size : sizes) {
            Heap<Integer, Integer> heap = new Heap<>(size, true);
            for (int i = 0; i < size; i++) {
                heap.insert(rand.nextInt(), i);
            }

            long start = System.currentTimeMillis();
            heap.sort();
            long finish = System.currentTimeMillis();

            long timeElapsed = finish - start;
            System.out.println("Heap size: " + size + ", Time taken: " + timeElapsed + " milliseconds");
        }
    }
}