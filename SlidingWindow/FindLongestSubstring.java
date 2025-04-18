package EducativeIO.SlidingWindow;

import java.util.HashMap;

public class FindLongestSubstring {
    public static int findLongestSubstring(String str) {
        int longestSubstring = 0;
        if (str.length() < 1) {
            return 0;
        }
        int start = 0;
        HashMap<Character, Integer> seenChar = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            if (seenChar.containsKey(str.charAt(end))) {
                if (start < seenChar.get(str.charAt(end)) + 1) {
                    start = seenChar.get(str.charAt(end)) + 1;
                }

            }

            seenChar.put(str.charAt(end), end);

            longestSubstring = Math.max(longestSubstring, end - start + 1);

        }

        // Replace this placeholder return statement with your code
        return longestSubstring;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubstring("abcdbea"));
    }
}
