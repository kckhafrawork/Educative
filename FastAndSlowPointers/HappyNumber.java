
public class HappyNumber {
    public static int squareDigitSum(int sum) {
        // String nString = String.valueOf(sum);
        // int result = 0;
        // for (char digitSttring : nString.toCharArray()) {
        // int digit = Character.getNumericValue(digitSttring);
        // result += Math.pow(digit, 2);

        // }

        int num = sum;
        int result = 0;
        while (num > 0) {
            result += Math.pow((num % 10), 2);
            num /= 10;
        }
        return result;
    }

    public static boolean isHappyNumber(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = squareDigitSum(slow);
            fast = squareDigitSum(squareDigitSum(fast));
        } while (slow != 1 && fast != 1 && slow != fast);
        if (slow == 1 || fast == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(23));
    }
}
