package session3;

import java.util.Stack;

/**
 * Author: Maryam Karimi
 * Email: mkarimif@uwo.ca
 */
public class mkarimif_session3_q2 {

    public static class MyQueue {

        private final Stack<Integer> pushStack = new Stack();
        private final Stack<Integer> popStack = new Stack();
        private Integer front;

        public void push(final int val) {
            if (pushStack.isEmpty()) front = val;
            pushStack.push(val);
        }

        public int pop() {
            if (!popStack.isEmpty()) {
                return popStack.pop();
            }

            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
            return popStack.pop();
        }

        public int peek() {
            if (!popStack.isEmpty()) {
                return popStack.peek();
            }
            return front;
        }

        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);

        if (myQueue.peek() == 1) {
            System.out.println("push works");
            System.out.println("peek works");
        }

        if (myQueue.pop() == 1) {
            System.out.println("pop works");
        }

        if (!myQueue.empty()) {
            myQueue.push(3);
            myQueue.push(4);
            myQueue.pop();
            myQueue.pop();
            myQueue.pop();

            if (myQueue.empty()) {
                System.out.println("empty works");
            }
        }
    }
}
