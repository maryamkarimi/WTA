package session4;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Maryam Karimi
 * Email: mkarimif@uwo.ca
 */
public class mkarimif_session4_q2 {

    public static class Solution {

        private Solution() {

        }

        static int lilysHomework(int[] arr) {

            final Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], i);
            }

            int[] sortedArray = arr.clone();
            Arrays.sort(sortedArray);

            int swapCount = 0;
            for (int i = 0; i < sortedArray.length; i++) {
                if (i == map.get(sortedArray[i])) continue;
                int index = map.get(sortedArray[i]);
                map.put(arr[i], index);
                swapCount++;
            }

            reverse(sortedArray);

            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], i);
            }

            int swapCount2 = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i == map.get(sortedArray[i])) continue;
                int index = map.get(sortedArray[i]);
                map.put(arr[i], index);
                swapCount2++;
            }

            return Math.min(swapCount, swapCount2);
        }

        public static void reverse(int[] arr) {
            for(int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = temp;
            }
        }
    }

    public static void checkTestCase(final int testNumber, final int[] arr, final int expected) {

        if (Solution.lilysHomework(arr) == expected) {
            System.out.printf("Test Case #%d Passed %n", testNumber);
        } else {
            System.out.printf("Test Case #%d Failed  %n", testNumber);
        }
    }

    public static void main(String[] args) {

        // Test Case 1 from the question
        checkTestCase(1, new int[] {7, 15, 12, 3}, 2);


        // Test case 2 from the question
        checkTestCase(2, new int[] {2, 5, 3, 1}, 2);

        // Test case 3
        checkTestCase(3, new int[] {1, 2, 3, 4}, 0);

        // Test case 3
        checkTestCase(4, new int[] {1, 2, 3, 4}, 0);

        // Test case 4
        checkTestCase(5, new int[] {4, 6, 2, 8}, 2);
    }
}
