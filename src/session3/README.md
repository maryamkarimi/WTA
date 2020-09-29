# WTA-Session3
Western Tech Alumni - Session 3 Homework


### Questions 1: [Cycle Detection](https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem)
```
Explanation: Used two pointers with different speeds. If there is not a cycle, the faster pointer will reach null and return false. If there is a cycle, the two pointers will eventually meet each other and the function will return true.

Time Complexity: O(n)

Space Complexity: O(1)
```


### Question 2: [Implement Queue using Stack](https://leetcode.com/problems/implement-queue-using-stacks/)
```
Explanation: Use two stacks. Whenever push is called, push items to the first stack. Whenever a pop is called, if the second stack has content, call pop on it, otherwise, push all items from the first stack to the second one, and then call pop. Keep track of the bottom element (front) in the first stack for peek. If stack 2 is not empty, call peek on it, otherwise, use the stored front element.

Time Complexity: 

push = O(1)

peek = O(1)

pop = O(n) worst case

empty = O(1)


Space Complexity: 

push = O(n)

peek = O(1)

pop = O(1)

empty = O(1)
```


### Questions 3: [Task Scheduler](https://leetcode.com/problems/task-scheduler/)
```
Explanation: First, find the frequencies of all the tasks. Then, add the frequency counts to a max-heap queue. Calculate the max number of possible idle steps, and then subtract from it by polling an item from the queue until the queue isn't empty. At the end, the result would be number of idle steps + number of tasks

Time Complexity: O(n)

Space Complexity: O(n)
```
