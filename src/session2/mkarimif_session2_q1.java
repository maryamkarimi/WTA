package session2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: Maryam Karimi
 * Email: mkarimif@uwo.ca
 */
public class mkarimif_session2_q1 {

   public static class Solution {
       /**
        * @param arr the target array to rotate
        * @param n   the length of the array
        * @param d   the number of rotations
        * @return single line of space-separated integers denoting the final state of the array after d rotations
        */
       public static String rotate(int[] arr, int n, int d) {

           if (n == 1) return String.valueOf(arr[0]);

           if (d > n) d = d % n;

           int[] helper = Arrays.copyOfRange(arr, 0, d);

           for (int i = d; i < n; i++) {
               arr[i - d] = arr[i];
           }

           for (int i = n - d; i < n; i++) {
               arr[i] = helper[i - n + d];
           }

           return Arrays.stream(arr)
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining(" "));
       }
   }

    public static void checkTestCase(final int[] arr, final int n, final int d, final String expected) {
        String testArray = Arrays.stream(arr)
                                 .mapToObj(Integer::toString)
                                 .collect(Collectors.joining(","));
        if (Solution.rotate(arr, n, d).equals(expected)) {
            System.out.printf("Passed for array=[%s] d=%d %n", testArray, d);
        } else {
            System.out.printf("Failed for array=[%s] d=%d %n", testArray, d);
        }
    }

    public static void main(String[] args) throws IOException {

        // Test Case 1 from the question
        checkTestCase(new int[]{1, 2, 3, 4, 5}, 5, 2, "3 4 5 1 2");

        // Test Case 2: # of rotations = length of array (no change)
        checkTestCase(new int[]{1, 2, 3, 4, 5}, 5, 5, "1 2 3 4 5");

        // Test Case 3: # of rotations > length of array
        checkTestCase(new int[]{1, 2, 3, 4, 5}, 5, 6, "2 3 4 5 1");

        // Test Case 4: array with length = 1
        checkTestCase(new int[]{1}, 1, 20, "1");

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter new values:");

        final String[] firstLine = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(firstLine[0]);

        int d = Integer.parseInt(firstLine[1]);

        final int[] arr = Stream.of(bufferedReader.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();

        System.out.println("Answer = " + Solution.rotate(arr, n, d));

        bufferedReader.close();
    }
}
