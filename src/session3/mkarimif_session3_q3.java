package session3;


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

            final int[] frequencies = new int[CHAR_NUM];
            for (char task : tasks) {
                frequencies[task - 'A']++;
            }

            final PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

            for (int f : frequencies) {
                if (f > 0) queue.add(f);
            }

            int maxFrequency = queue.poll();
            int idle = (maxFrequency - 1) * n;

            while (!queue.isEmpty()) {
                idle -= Math.min(maxFrequency - 1, queue.poll());
            }

            return Math.max(0, idle) + tasks.length;
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
