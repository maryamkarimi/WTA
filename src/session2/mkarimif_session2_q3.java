package session2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Author: Maryam Karimi
 * Email: mkarimif@uwo.ca
 */
public class mkarimif_session2_q3 {

    public static class Solution {

        private static final int CHAR_COUNT = 26;

        private enum Answer {
            YES,
            NO
        }

        public static String twoStrings(final String s1, final String s2) {

            final boolean[] hasCharS1 = new boolean[CHAR_COUNT];
            final boolean[] hasCharS2 = new boolean[CHAR_COUNT];

            int s1Index = 0;
            int s2Index = 0;

            while (s1Index < s1.length() || s2Index < s2.length()) {

                if (s1Index < s1.length()) {
                    char s1Char = s1.charAt(s1Index);
                    hasCharS1[s1Char - 'a'] = true;
                    if (hasCharS2[s1Char - 'a']) return Answer.YES.toString();
                }


                if (s2Index < s2.length()) {
                    char s2Char = s2.charAt(s2Index);
                    hasCharS2[s2Char - 'a'] = true;
                    if (hasCharS1[s2Char - 'a']) return Answer.YES.toString();
                }


                s1Index++;
                s2Index++;
            }

            return Answer.NO.toString();
        }
    }

    public static void checkTestCase(final String s1, final String s2, final Solution.Answer expected) {

        if (Solution.twoStrings(s1, s2).equals(expected.toString())) {
            System.out.printf("Passed for s1=%s s2=%s %n", s1, s2);
        } else {
            System.out.printf("Failed for s1=%s s2=%s %n", s1, s2);
        }
    }

    public static void main(String[] args) throws IOException {

        // Test Case 1 from the question
        checkTestCase("hello", "world", Solution.Answer.YES);

        // Test Case 2 from the question
        checkTestCase("hi", "world", Solution.Answer.NO);

        // Test Case 3
        checkTestCase("", "art", Solution.Answer.NO);

        // Test Case 4
        checkTestCase("smoothie", "elephant", Solution.Answer.YES);

        // Test Case 5
        checkTestCase("apple", "orange", Solution.Answer.YES);

        // Test Case 6
        checkTestCase("chips", "mango", Solution.Answer.NO);

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter new values:");

        final int testCasesCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCasesCount; i++) {
            final String s1 = bufferedReader.readLine();
            final String s2 = bufferedReader.readLine();
            System.out.println("Answer = " + Solution.twoStrings(s1, s2));
        }

        bufferedReader.close();
    }
}
