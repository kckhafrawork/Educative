package TopKElements;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given a string, str, rearrange it so that any two adjacent characters are not the same. 
If such a reorganization of the characters is possible, output any possible valid arrangement. Otherwise, return an empty string.
*/
public class ReorganizeString {
    public static String reorganizeString(String string1) {

        // Replace this placeholder return statement with your code
        Map<Character, Integer> charCounter = new HashMap<>();
        for (char c : string1.toCharArray()) {
            int freq = charCounter.getOrDefault(c, 0) + 1;
            charCounter.put(c, freq);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxFreqChar = new PriorityQueue<Map.Entry<Character, Integer>>(
                (item1, item2) -> item2.getValue() - item1.getValue());

        maxFreqChar.addAll(charCounter.entrySet());

        Map.Entry<Character, Integer> previous = null;
        StringBuilder result = new StringBuilder(string1.length());
        while (!maxFreqChar.isEmpty() || previous != null) {

            if (previous != null && maxFreqChar.isEmpty())
                return "";

            Map.Entry<Character, Integer> currentEntry = maxFreqChar.poll();
            int count = currentEntry.getValue() - 1;
            result.append(currentEntry.getKey());

            if (previous != null) {
                maxFreqChar.add(previous);
                previous = null;
            }

            if (count != 0) {
                previous = new AbstractMap.SimpleEntry<>(currentEntry.getKey(), count);

            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("abb"));
    }
}
