
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RepeatingCharacter {
    public static int longestRepeatingCharacterReplacement(String s, int k) {
        int start = 0;
        int mostFrequent = 0;
        int longestRepeatingCharLength = 0;
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            // update the frquency map
            charFrequency.put(s.charAt(end), charFrequency.getOrDefault(s.charAt(end), 0) + 1);

            // update mostFrequent number
            mostFrequent = Math.max(mostFrequent, charFrequency.get(s.charAt(end)));
            System.out.println("CHAR-MAP " + charFrequency);
            // handle window size
            int windowSize = end - start + 1;
            if (windowSize - mostFrequent > k) {
                charFrequency.put(s.charAt(start), charFrequency.get(s.charAt(start)) - 1);
                start++;
            }

            System.out.println("WINDOW-SIZE " + windowSize + " MOST-FREQUENT " + mostFrequent + " " + k);

            longestRepeatingCharLength = Math.max(longestRepeatingCharLength, end - start + 1);

        }
        return longestRepeatingCharLength;

    }

    // Driver code
    public static void main(String[] args) {
        // List<String> inputStrings = Arrays.asList("aabccbb", "abbcb", "abccde",
        // "abbcab", "bbbbbbbbb");
        List<String> inputStrings = Arrays.asList("dbcdddea");
        List<Integer> k = Arrays.asList(2, 1, 1, 2, 4);

        for (int i = 0; i < inputStrings.size(); ++i) {
            System.out.println((i + 1) + ".\tInput String: '" + inputStrings.get(i) + "'");
            System.out.println("\tk: " + k.get(i));
            System.out.println("\tLength of the longest substring with repeating characters: "
                    + longestRepeatingCharacterReplacement(inputStrings.get(i), k.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}