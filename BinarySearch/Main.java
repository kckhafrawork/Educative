package EducativeIO.BinarySearch;

public class Main {
    public static void main(String[] args) {
        // int[] arr = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
        // int target = 8;
        // int index = new BinarySearch().binarySearch(arr, target);
        // System.out.println("index " + index);

        // int[] arr2 = { 12, 18, 5, 11, 30, 5 };
        // int target2 = 69;
        // ArrayList<Integer> res = new IndexesOfSubarraySum().subarraySum(arr2,
        // target2);
        // for (int r : res) {
        // System.out.println("res " + r);
        // }
        // int[] arr3 = { 1 };
        // int result = new MissingInArray().missingNimber(arr3);
        // System.out.println("RESULT " + result);
        // int[] arr4 = { 3, 1, 3, 3, 2 };
        // int result = new MajorityElement().majorityElement(arr4);
        int[] arr5 = { 4, 5, 2, 8, 1 };
        int res = new kthSmallest().kthSmallest(arr5, 2);
        System.out.println("RESULT " + res);

    }
}
