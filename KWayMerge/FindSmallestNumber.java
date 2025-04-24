package KWayMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindSmallestNumber {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {

        // Replace this placeholder return statement with your code
        List<Integer> mergedList = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < lists.size(); i++) {
            minHeap.add(new int[] { lists.get(i).get(0), i, 0, });
        }
        while (!minHeap.isEmpty()) {
            // take out smallest element and add to mergedList
            int[] smallestList = minHeap.poll();
            int elementValue = smallestList[0];
            int listIndex = smallestList[1];
            int elementIndex = smallestList[2];
            mergedList.add(elementValue);
            List<Integer> currentList = lists.get(listIndex);
            int nextElementIndex = elementIndex + 1;
            if (currentList.size() - 1 >= nextElementIndex) {
                minHeap.add(new int[] { lists.get(listIndex).get(nextElementIndex), listIndex, nextElementIndex });
            }

        }
        System.out.println(mergedList);

        return k - 1 > mergedList.size() ? mergedList.get(mergedList.size() - 1) : mergedList.get(k - 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(2, 6, 8), Arrays.asList(3, 7, 10),
                Arrays.asList(5, 8, 11));
        System.out.println(kSmallestNumber(lists, 5));
    }
}
