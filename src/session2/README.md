# WTA-Session2
Western Tech Alumni - Session 2 Homework

### Questions 1: [Array Left Rotation](https://www.hackerrank.com/challenges/array-left-rotation/problem)

Explanation: Used a helper array to store the first d element(s). Then, shift the last n - d element(s) to the beginning of the target array. Finally, copy the values from the helper array to the end of the target array.

Time Complexity: O(n) 

Space Complexity: O(n) worst case

### Question 2: [Two Characters](https://www.hackerrank.com/challenges/two-characters/problem)

Explanation: First, found all of the unique characters in the string. Then, mapped every two possible characters to the resulting string consisting of the two picked characters. (I did this running through the array only once, so the time complexity is O(n)). Then, checked which of the strings are valid, and found the maximum amongst the valid ones.

Time Complexity: O(n)

Space Complexity: O(1) -> worst case there will be 26 unique characters in the string and 325 entries in the map

### Questions 3: [Two Strings](https://www.hackerrank.com/challenges/two-strings/problem)

Explanation: Walk through both strings at the same time until we reach the end of both. Keep two boolean arrays for each string and update them as we see characters by setting the associated entry to true. At every step, take characters c1 from the first string and c2 from the same string. Then, if array2 has c1, or array1 has c2 (i.e. the other string has the same character that we're checking), return true. 

Time Complexity: O(n)

Space Complexity: O(1) -> two boolean arrays of size 26
