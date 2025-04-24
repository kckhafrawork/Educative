
public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        // Replace this placeholder return statement with your code
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 3, 4, 4, 4, 2 }));
    }
}
