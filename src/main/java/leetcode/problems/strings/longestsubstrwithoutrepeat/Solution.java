package leetcode.problems.strings.longestsubstrwithoutrepeat;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String input = "abba";
        System.out.println(longestSubStringWithoutRepeat(input));
    }

    private static int longestSubStringWithoutRepeat(String input) {
        Map<Character, Integer> charToLastIndex = new HashMap<>();
        var left = 0;
        var right = 0;
        int globalMax = Integer.MIN_VALUE;
        while(right < input.length()) {
            // update left
            if(charToLastIndex.containsKey(getCharAt(input, right))) left = Math.max(left, charToLastIndex.get(getCharAt(input, right)) + 1);
            // update map
            charToLastIndex.put(getCharAt(input, right), right);
            globalMax = Math.max(globalMax, right - left + 1);
            System.out.println(globalMax);
            right++;
        }
        return globalMax;
    }

    private static char getCharAt(String input, int right) {
        return input.charAt(right);
    }
}