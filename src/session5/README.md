# WTA-Session5
Western Tech Alumni - Session 5 Homework


### Questions 1: [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

Explanation: Used dynamic programming as this problem can be broken into sub-problems. I took a bottom up approach, knowing how many unique ways there are for 1 and 2 steps, and then built the next values from these cases. This is because at every stage, we can either take 1 or 2 steps. So all we need to do is add dp[n - 1] and dp[n - 2] to get the value for dp[n]
```
Time Complexity: O(n) calculate dp[n] for each number from 1 to n

Space Complexity: O(n) to keep the dp array
```


### Question 2: [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

Explanation: I took a dynamic programming approach (Kadane's algorithm). Starting from the beginning of the array, calculated the maximum sum up to an index and stored it in the same index of the array. The maximum sum for each index will either be the value at the index, or the max sum of values prior to the index plus the value at the index (whichever is larger). I used a max variable to keep track of the maximum sum encountered throughout the whole loop, which is the final result to be returned. 
```
Time Complexity: O(n) loop through the whole array once

Space Complexity: O(1) only one variable used to keep track of max
```
