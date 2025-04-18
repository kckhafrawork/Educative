package EducativeIO.MergingIntervals;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] intervals) {
        // Replace this placeholder return statement with your code
        if (intervals.length < 1) {
            return new int[][] {};
        }
        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int currentFirst = intervals[i][0];
            int currentSecond = intervals[i][1];
            int[] lastAddedInterval = result.getLast();
            int prevSecond = lastAddedInterval[1];
            if (prevSecond >= currentFirst) {
                lastAddedInterval[1] = Math.max(prevSecond, currentSecond);
            } else {
                result.add(intervals[i]);
            }

        }
        // result
        return result.toArray(new int[][] {});
    }

    public static void main(String[] args) {
        int[][][] allIntervals = {
                { { 1, 5 }, { 3, 7 }, { 4, 6 } },
                { { 1, 5 }, { 4, 6 }, { 6, 8 }, { 11, 15 } },
                { { 3, 7 }, { 6, 8 }, { 10, 12 }, { 11, 15 } },
                { { 1, 5 } },
                { { 1, 9 }, { 3, 8 }, { 4, 4 } },
                { { 1, 2 }, { 3, 4 }, { 8, 8 } },
                { { 1, 5 }, { 1, 3 } },
                { { 1, 5 }, { 6, 9 } },
                { { 0, 0 }, { 1, 18 }, { 1, 3 } }
        };

        int index = 1;
        for (int[][] intervals : allIntervals) {
            System.out.println(index + ".\tIntervals to merge: " + Arrays.deepToString(intervals));
            int[][] result = mergeIntervals(intervals);
            System.out.println("\tMerged intervals: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            index++;
        }
    }
}
