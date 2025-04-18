package EducativeIO.BinarySearch;

public class BinarySearch {
    public int binarySearch(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target == arr[middle]) {
                return middle;
            }
            if (target > arr[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public int recursiveBinarySearch(int arr[], int target) {
        return 0;
    }

}
