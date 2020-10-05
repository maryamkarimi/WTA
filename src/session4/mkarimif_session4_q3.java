package session4;

/**
 * Author: Maryam Karimi
 * Email: mkarimif@uwo.ca
 */
public class mkarimif_session4_q3 {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static class Solution {

        private Solution() {

        }

        public static boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            return isValidBST(root.left, null, root.data) && isValidBST(root.right, root.data, null);
        }

        public static boolean isValidBST(TreeNode root, Integer min, Integer max) {
            if (root == null) return true;
            if ((min != null && root.data <= min) || (max != null && root.data >= max)) return false;
            return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
        }

    }

    public static void checkTestCase(final int testNumber, final TreeNode head, final boolean expected) {

        if (Solution.isValidBST(head) == expected) {
            System.out.printf("Test Case #%d Passed %n", testNumber);
        } else {
            System.out.printf("Test Case #%d Failed  %n", testNumber);
        }
    }

    public static void main(String[] args) {


         /* Test Case #1 from the question
             1
            / \
           5   2
          / \   \
         3   4   6
         */
        checkTestCase(1, getTestCaseTree(1), false);

        /* Test Case #2
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
        checkTestCase(2, getTestCaseTree(2), true);

        /* Test Case #3
             1
            / \
           2   3
          / \   \
         4   5   6
         */
        checkTestCase(3, getTestCaseTree(3), false);

        /* Test Case #4
             1
            /
           2
          /
         3
         */
        checkTestCase(4, getTestCaseTree(4), false);

        /* Test Case #5: null root
         */
        checkTestCase(5, null, true);
    }


    public static TreeNode getTestCaseTree(int testCaseNumber) {
        final TreeNode node1 = new TreeNode(1);
        final TreeNode node2 = new TreeNode(2);
        final TreeNode node3 = new TreeNode(3);
        final TreeNode node4 = new TreeNode(4);
        final TreeNode node5 = new TreeNode(5);
        final TreeNode node6 = new TreeNode(6);

        if (testCaseNumber == 1) {
            node1.right = node2;
            node1.left = node5;
            node2.left = node6;
            node5.left = node3;
            node5.right = node4;
        }

        if (testCaseNumber == 2) {
            node1.right = node2;
            node2.right = node5;
            node5.left = node3;
            node5.right = node6;
            node3.right = node4;
        }

        if (testCaseNumber == 3) {
            node1.left = node2;
            node1.right = node3;
            node2.left = node4;
            node2.right = node5;
            node3.right = node6;
        }

        if (testCaseNumber == 4) {
            node1.left = node2;
            node2.left = node3;
        }

        return node1;
    }
}
