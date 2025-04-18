package EducativeIO.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an integer array nums, find and return all unique triplets [nums[i], nums[j], nums[k]], where the indexes satisfy i≠j, i≠k, and j≠k and the sum of the elements nums[i] + nums[j] + nums[k] == 0.
 */
public class sumOfThreeValues {
    public static List<List<Integer>> threeSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current number is greater than 0, break the loop (no valid triplets
            // possible)
            if (nums[i] > 0) {
                break;
            }
            // Skip duplicate values for the pivot
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Use two-pointer technique
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                List<Integer> tempResults = new ArrayList<>();
                int total = nums[left] + nums[right] + nums[i];

                if (total < 0) {
                    left++;
                } else if (total > 0) {
                    right--;
                } else {
                    // Found a triplet
                    tempResults.add(nums[i]);
                    tempResults.add(nums[left]);
                    tempResults.add(nums[right]);
                    results.add(tempResults);
                    left++;
                    right--;
                    // Skip duplicates for low and high pointers
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    continue;
                }

            }

        }
        return results;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 0, 2, -2, 1, -1 };

        System.out.println(sumOfThreeValues.threeSum(arr));

    }
}
