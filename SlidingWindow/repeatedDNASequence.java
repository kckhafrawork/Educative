
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class repeatedDNASequence {
    public static List<String> findRepeatedDnaSequences(String s) {
        int k = 10;
        List<String> result = new ArrayList<>();
        if (s.length() < k) {
            return result;
        }

        Set<String> seen = new HashSet<>();
        Set<String> added = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            if (seen.contains(sub) && !added.contains(sub)) {
                result.add(sub);
                added.add(sub);
            } else {
                seen.add(sub);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> testCases = Arrays.asList(
                "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
                "AAAAAAAAAAAAA",
                "ACGTACGTACGTACGTACGTACGTACGTACGT",
                "GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG",
                "GTACGTACGTACGCCCCCCCCGGGGG");

        for (int i = 0; i < testCases.size(); i++) {
            System.out.println((i + 1) + ".\tInput: \"" + testCases.get(i) + "\"");

            List<String> result = findRepeatedDnaSequences(testCases.get(i));
            System.out.println("\n\tOutput: " + result);
            System.out.println("-" + new String(new char[100]).replace('\0', '-') + "\n");
        }
    }
}
