
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertListIntersection {
    public static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {
        // Replace this placeholder return statement with your code
        int listALength = intervalLista.length;
        int listBLength = intervalListb.length;
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < listALength && j < listBLength) {
            int firstA = intervalLista[i][0];
            int secondA = intervalLista[i][1];
            int firstB = intervalListb[j][0];
            int secondB = intervalListb[j][1];
            int start = Math.max(firstA, firstB);
            int end = Math.min(secondA, secondB);
            if (start <= end) {
                result.add(new int[] { start, end });
            }
            if (secondA < secondB) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[][] {});
    }

    public static void main(String[] args) {
        int[][][] inputIntervalLista = {
                { { 1, 2 } },
                { { 1, 4 }, { 5, 6 }, { 9, 15 } },
                { { 3, 6 }, { 8, 16 }, { 17, 25 } },
                { { 4, 7 }, { 9, 16 }, { 17, 28 }, { 39, 50 }, { 55, 66 }, { 70, 89 } },
                { { 1, 3 }, { 5, 6 }, { 7, 8 }, { 12, 15 } }
        };

        int[][][] inputIntervalListb = {
                { { 1, 2 } },
                { { 2, 4 }, { 5, 7 }, { 9, 15 } },
                { { 2, 3 }, { 10, 15 }, { 18, 23 } },
                { { 3, 6 }, { 7, 8 }, { 9, 10 }, { 14, 19 }, { 23, 33 }, { 35, 40 }, { 45, 59 }, { 60, 64 },
                        { 68, 76 } },
                { { 2, 4 }, { 7, 10 } }
        };

        for (int i = 0; i < inputIntervalLista.length; i++) {
            System.out.println(i + 1 + ".\t Interval List A: " + Arrays.deepToString(inputIntervalLista[i]));
            System.out.println("\t Interval List B: " + Arrays.deepToString(inputIntervalListb[i]));
            System.out.println("\t Intersecting intervals in 'A' and 'B' are: " +
                    Arrays.deepToString(intervalsIntersection(inputIntervalLista[i], inputIntervalListb[i])));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
