package EducativeIO.TwoPointers;

public class SortColors {
    public int[] sortColors(int[] colors) {
        // Initialize the start, current, and end pointers
        int start = 0;
        int current = 0;
        int end = colors.length - 1;

        // Iterate through the list until the current pointer exceeds the end pointer
        while (current <= end) {
            if (colors[current] == 0) {
                // If the current element is 0 (red), swap it with the element at the start
                // pointer
                // This ensures the red element is placed at the beginning of the array
                int temp = colors[start];
                colors[start] = colors[current];
                colors[current] = temp;

                // move both the start and current piunters one position forward
                current++;
                start++;
            } else if (colors[current] == 1) {
                current++;
            } else {
                int temp = colors[current];
                colors[current] = colors[end];
                colors[end] = temp;
                end--;
            }
        }

        return colors;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 0, 1, 0, 2, 2, 0, 0, 1, 1 };
        int[] results = new SortColors().sortColors(arr);
        for (int i = 0; i < results.length; i++) {
            System.out.println("Results " + results[i]);
        }

    }
}
