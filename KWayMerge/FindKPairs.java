package KWayMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    public int sum;
    public int i;
    public int j;

    Pair(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }

}

public class FindKPairs {

    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {

        // Replace this placeholder return statement with your code
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        int listLength = list1.length;
        for (int i = 0; i < Math.min(target, listLength); i++) {
            minHeap.add(new Pair(list1[i] + list2[0], i, 0));
        }
        int counter = 1;
        while (!minHeap.isEmpty() && counter <= target) {
            Pair pairs = minHeap.poll();
            int i = pairs.i;
            int j = pairs.j;
            int nextJ = j + 1;
            result.add(Arrays.asList(list1[i], list2[j]));
            if (nextJ < list2.length) {
                minHeap.add(new Pair(list1[i] + list2[nextJ], i, nextJ));
            }
            counter++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] list1 = new int[] { 1, 2, 300 };
        int[] list2 = new int[] { 1, 11, 20, 35, 300 };
        System.out.println(kSmallestPairs(list1, list2, 30));
    }
}
