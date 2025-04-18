package EducativeIO.BinarySearch;

import java.util.Arrays;

public class MissingInArray {
    public int missingNimber(int arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 != arr[i]) {
                return i + 1;
            }
        }
        return arr.length + 1;
    }
}
