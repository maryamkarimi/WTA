import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author: Maryam Karimi
 * Email: mkarimif@uwo.ca
 */
public class mkarimif_session3_q3 {

    public static class Solution {

        private static final int CHAR_NUM = 26;

        public static int leastInterval(final char[] tasks, final int n) {

            final int[] frequency = new int[CHAR_NUM];
            for (char task : tasks) {
                frequency[task - 'A']++;
            }

            final PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

            for (final int freq : frequency) {
                if (freq > 0) {
                    queue.add(freq);
                }
            }

            int counter = 0;
            while (!queue.isEmpty()) {

                final int queueSize = queue.size();
                final int[] temp = new int[n + 1];
                for (int i = 0; i < n + 1; i++) {
                    if (!queue.isEmpty()) {
                        temp[i] = queue.poll();
                    }
                }

                for (final int f : temp) {
                    if (f - 1 > 0) {
                        queue.add(f - 1);
                    }
                }


                counter += queue.isEmpty() ? queueSize : n + 1;
            }

            return counter;
        }
    }


    public static void main(String[] args) {
        // Example 1 from the question
        System.out.println(Solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2) == 8 ? "Test 1 Passed" : "Test 1 Failed");

        // Example 2 from the question
        System.out.println(Solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0) == 6 ? "Test 2 Passed" : "Test 2 Failed");

        // Example 3 from the question
        System.out.println(Solution.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2) == 16 ? "Test 3 Passed" : "Test 3 Failed");

        // Test Case #4
        System.out.println(Solution.leastInterval(new char[]{'A', 'B', 'C'}, 5) == 3 ? "Test 4 Passed" : "Test 4 Failed");

        // Test Case #5
        System.out.println(Solution.leastInterval(new char[]{'A', 'A', 'B', 'B', 'C', 'C'}, 3) == 7 ? "Test 5 Passed" : "Test 5 Failed");

        // Test Case #6
        System.out.println(Solution.leastInterval(new char[]{'A', 'A', 'A'}, 1) == 5 ? "Test 6 Passed" : "Test 6 Failed");

    }
}
