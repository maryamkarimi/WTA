import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Author: Maryam Karimi
 * Email: mkarimif@uwo.ca
 */
public class mkarimif_session2_q2 {

    public static class Solution {

        public static int alternate(final String s) {

            final Set<Character> characters = s.chars()
                                               .mapToObj(a -> (char) a)
                                               .collect(Collectors.toSet());

            final Map<Set<Character>, StringBuilder> map = new HashMap<>();

            // O(1) because max number of characters is 26
            characters.forEach(character1 -> characters.stream()
                                                       .filter(character2 -> !character1.equals(character2))
                                                       .forEach(filteredChar -> map.put(new HashSet<>(Arrays.asList(character1, filteredChar)), new StringBuilder())));


            // O(n)
            for (final Character c : s.toCharArray()) {
                map.entrySet()
                   .stream()
                   .filter(entry -> entry.getKey().contains(c))
                   .forEach(entry -> entry.getValue().append(c));
            }

            return map.values()
                      .stream()
                      .filter(stringBuilder -> isAlternating(stringBuilder.toString()))
                      .map(StringBuilder::length)
                      .max(Integer::compareTo)
                      .orElse(0);
        }

        private static boolean isAlternating(final String s) {
            if (s.length() < 3) return true;

            for (int i = 2; i < s.length(); i++) {
                if (s.charAt(i - 2) != s.charAt(i)) return false;
            }

            return true;
        }
    }

    public static void checkTestCase(final String s, final int expected) {
        if (Solution.alternate(s) == expected) {
            System.out.printf("Passed for s=%s %n", s);
        } else {
            System.out.printf("Failed for s=%s %n", s);
        }
    }

    public static void main(String[] args) throws IOException {

        // Test Case 1 from the question
        checkTestCase("abaacdabd", 4);

        // Test Case 2 from the question
        checkTestCase("beabeefeab", 5);

        // Test Case 3
        checkTestCase("abcd", 2);

        // Test Case 4
        checkTestCase("asdcbsdcagfsdbgdfanfghbsfdab", 8);

        // Test Case 5
        checkTestCase("hajjhkjajhkkjakhaha", 10);

        // Test Case 6
        checkTestCase("abccba", 0);

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter new values:");

        final int length = Integer.parseInt(bufferedReader.readLine());

        final String s = bufferedReader.readLine();

        System.out.println("Answer = " + Solution.alternate(s));

        bufferedReader.close();
    }
}
