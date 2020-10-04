package session4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Author: Maryam Karimi
 * Email: mkarimif@uwo.ca
 */
public class mkarimif_session4_q1 {

    public static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    public static class Solution {

        private Solution() {

        }

        public static String levelOrderTraversal(TreeNode<Integer> root) {

            final List<Integer> results = new ArrayList<>();

            if (root == null) return "";

            final Queue<TreeNode<Integer>> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {

                final TreeNode<Integer> curNode = queue.poll();
                results.add(curNode.data);

                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }

            return results.stream().map(String::valueOf).collect(Collectors.joining(" "));
        }

    }

    public static void checkTestCase(final int testNumber, final TreeNode<Integer> head, final String expected) {

        if (Solution.levelOrderTraversal(head).equals(expected)) {
            System.out.printf("Test Case #%d Passed %n", testNumber);
        } else {
            System.out.printf("Test Case #%d Failed  %n", testNumber);
        }
    }

    public static void main(String[] args) {

        /* Test Case #1 from the question
             1
              \
               2
                \
                 5
                /  \
               3    6
                \
                 4
         */
        checkTestCase(1, getTestCaseTree(1), "1 2 5 3 6 4");

        /* Test Case #2
             1
            / \
           2   3
          / \   \
         4   5   6
         */
        checkTestCase(2, getTestCaseTree(2), "1 2 3 4 5 6");

        /* Test Case #3
             1
            /
           2
          /
         3
         */
        checkTestCase(3, getTestCaseTree(3), "1 2 3");

        // Test Case 4: null root
        checkTestCase(4, null, "");
    }


    public static TreeNode<Integer> getTestCaseTree(int testCaseNumber) {
        final TreeNode<Integer> node1 = new TreeNode<>(1);
        final TreeNode<Integer> node2 = new TreeNode<>(2);
        final TreeNode<Integer> node3 = new TreeNode<>(3);
        final TreeNode<Integer> node4 = new TreeNode<>(4);
        final TreeNode<Integer> node5 = new TreeNode<>(5);
        final TreeNode<Integer> node6 = new TreeNode<>(6);

        if (testCaseNumber == 1) {
            node1.right = node2;
            node2.right = node5;
            node5.left = node3;
            node5.right = node6;
            node3.right = node4;
        }

        if (testCaseNumber == 2) {
            node1.left = node2;
            node1.right = node3;
            node2.left = node4;
            node2.right = node5;
            node3.right = node6;
        }

        if (testCaseNumber == 3) {
            node1.left = node2;
            node2.left = node3;
        }

        return node1;
    }
}
