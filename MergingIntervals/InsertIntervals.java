
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertIntervals {
    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {

        // Replace this placeholder return statement with your code
        LinkedList<int[]> result = new LinkedList<>();
        List<int[]> newExistingIntervals = new ArrayList<>();
        boolean newIntervalActive = true;
        for (int i = 0; i < existingIntervals.length; i++) {
            if (newIntervalActive && newInterval[0] < existingIntervals[i][0]) {
                newExistingIntervals.add(newInterval);
                newExistingIntervals.add(existingIntervals[i]);
                newIntervalActive = false;
            } else {
                newExistingIntervals.add(existingIntervals[i]);
            }
        }
        if (existingIntervals[existingIntervals.length - 1][0] < newInterval[0]) {
            newExistingIntervals.add(newInterval);
        }

        result.add(newExistingIntervals.get(0));
        for (int i = 0; i < newExistingIntervals.size(); i++) {
            System.out.println(newExistingIntervals.get(i)[0] + " " + newExistingIntervals.get(i)[1]);
            int[] prevInterval = result.getLast();
            int currentFirst = newExistingIntervals.get(i)[0];
            int currentSecond = newExistingIntervals.get(i)[1];

            if (prevInterval[1] >= currentFirst) {
                prevInterval[1] = Math.max(currentSecond, prevInterval[1]);
            } else {
                result.add(newExistingIntervals.get(i));
            }

        }
        return result.toArray(new int[][] {});
    }

    public static void main(String[] args) {
        int[][] newIntervals = {
                { 5, 7 },
                { 8, 9 },
                { 10, 12 },
                { 1, 3 },
                { 1, 10 }
        };

        int[][][] existingIntervals = {
                { { 1, 2 }, { 3, 5 }, { 6, 8 } },
                { { 1, 3 }, { 5, 7 }, { 10, 12 } },
                { { 8, 10 }, { 12, 15 } },
                { { 5, 7 }, { 8, 9 } },
                { { 3, 5 } }
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.print((i + 1) + ".\tExisting intervals: ");
            System.out.println(Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
            int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
