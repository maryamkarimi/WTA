# WTA-Session4
Western Tech Alumni - Session 4 Homework


### Questions 1: [Level Order Traversal](https://www.hackerrank.com/challenges/tree-level-order-traversal/problem)

Explanation: Used a queue to perform a BFS on the tree. Start by adding the root to the queue, and keep polling (adding the removed item to the result array), and if the current node has any left or right children, add those to the queue as well. Continue the same process until the queue is empty (i.e. all the nodes are visited)
```
Time Complexity: O(n) since every node is processed once

Space Complexity: O(n) since at worst we'll have too keep all nodes in the queue
```


### Question 2: [Lily's Homework](https://www.hackerrank.com/challenges/lilys-homework/problem)

Explanation: An array is beautiful if it's sorted, either in ascending or descending order. First, sort the array (this will take O(nlog(n)) time) and then swap elements if needed to move them in their correct positions. I also used a map to keep track of value -> index mappings for quicker lookup.
```
Time Complexity: O(n log(n))

Space Complexity: O(n)
```


### Questions 3: [Validate BST](https://www.hackerrank.com/challenges/is-binary-search-tree/problem)

Explanation: Created a helper method that gets called recursively. It holds minimum and maximum variables. The min gets updated when we branch right, and the max gets updated when we branch left. If at any point our node isn't within the min/max range, we return false. When we reach a null node, we return true.
```
Time Complexity: O(n) since we visit every node once

Space Complexity: O(n) 
```
