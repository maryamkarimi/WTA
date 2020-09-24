
/**
 * Author: Maryam Karimi
 * Email: mkarimif@uwo.ca
 */
public class mkarimif_session3_q1 {

    public static class ListNode {

        final int val;
        ListNode next;

        public ListNode(final int val) {
            this.val = val;
        }
    }

   public static class Solution {

       public static boolean hasCycle(final ListNode head) {

           if (head == null) return false;

           ListNode slowPtr = head;
           ListNode fastPtr = head.next;

           while (fastPtr != null && fastPtr.next != null) {

               if (slowPtr == fastPtr) return true;

               slowPtr = slowPtr.next;
               fastPtr = fastPtr.next.next;
           }

           return false;
       }
   }

    public static void checkTestCase(final int testNumber, final ListNode head, final boolean expected) {

        if (Solution.hasCycle(head) == expected) {
            System.out.printf("Test Case #%d Passed %n", testNumber);
        } else {
            System.out.printf("Test Case #%d Failed  %n", testNumber);
        }
    }

    public static void main(String[] args) {

        final ListNode node1 = new ListNode(1);
        final ListNode node2 = new ListNode(2);
        final ListNode node3 = new ListNode(3);
        final ListNode node4 = new ListNode(4);


        // Test Case 1 from the question no cycle
        checkTestCase(1, node1, false);

        // Test Case 2 from the question with cycle
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        checkTestCase(2, node1, true);

        // Test Case 3
        checkTestCase(3, null, false);

        // Test Case 4
        node3.next = node4;
        checkTestCase(4, node1, false);

        // Test Case 5
        node4.next = node1;
        checkTestCase(5, node1, true);
    }
}
