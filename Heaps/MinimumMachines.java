
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumMachines {
    public static int minimumMachines(int[][] tasks) {

        // Replace this placeholder return statement with your code
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> machines = new PriorityQueue<>();
        for (int[] task : tasks) {
            int start = task[0];
            int end = task[1];

            if (!machines.isEmpty() && machines.peek() <= start)
                machines.poll();

            machines.add(end);
        }

        return machines.size();
    }

    public static void main(String[] args) {
        int[][] tasks = { { 1, 6 }, { 2, 3 }, { 2, 5 }, { 7, 8 } };
        System.out.println(minimumMachines(tasks));
    }
}
