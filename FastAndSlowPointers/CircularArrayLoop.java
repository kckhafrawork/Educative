
public class CircularArrayLoop {
    public static int nextStep(int pointer, int value, int size) {
        int result = (pointer + value) % size;
        if (result < 0) {
            result += size;
        }
        return result;
    }

    public static boolean isNotACycle(int[] nums, boolean isPrevForward, int pointer) {
        boolean isCurrentForward = nums[pointer] > 0;
        if (isPrevForward != isCurrentForward || nums[pointer] % nums.length == 0) {
            return true;
        }
        ;
        return false;
    }

    public static boolean circularArrayLoop(int[] nums) {

        // Replace this placeholder return statement with your code
        for (int i = 0; i < nums.length; i++) {
            boolean isForward = nums[i] > 0;
            int slow = i;
            int fast = i;
            while (true) {
                slow = nextStep(slow, nums[slow], nums.length);
                if (isNotACycle(nums, isForward, slow)) {
                    break;
                }

                fast = nextStep(fast, nums[fast], nums.length);
                if (isNotACycle(nums, isForward, fast)) {
                    break;
                }

                fast = nextStep(fast, nums[fast], nums.length);
                if (isNotACycle(nums, isForward, fast)) {
                    break;
                }
                if (fast == slow) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String args[]) {
        int[] nums = { 1, 3, -4, 1 };
        System.out.println(circularArrayLoop(nums));
    }
}
