package EducativeIO.BinarySearch;

import java.util.ArrayList;

/**
 * Given an array arr[] containing only non-negative integers,
 * your task is to find a continuous subarray (a contiguous sequence of
 * elements)
 * whose sum equals a specified value target.
 * You need to return the 1-based indices of the leftmost and rightmost elements
 * of this subarray.
 * You need to find the first subarray whose sum is equal to the target.
 * 
 * Note: If no such array is possible then, return [-1]
 */
public class IndexesOfSubarraySum {
    public ArrayList<Integer> subarraySum(int arr[], int target) {
        int left = 0;
        int right = 0;
        int sum = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // If current sum becomes more or equal,
            // set end and try adjusting left
            if (sum >= target) {
                right = i;
                // While current sum is greater,
                // remove left elements of current window
                while (sum > target && left < right) {
                    sum -= arr[left];
                    left++;
                }

                // If we found a subarray
                if (sum == target) {
                    result.add(left + 1); // Convert to 1-based indexing
                    result.add(right + 1);
                    return result;
                }

            }
        }

        result.add(-1);
        return result;
    }

}
