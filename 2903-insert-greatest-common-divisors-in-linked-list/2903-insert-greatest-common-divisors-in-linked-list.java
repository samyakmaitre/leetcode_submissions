/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Edge case: return head if the list is too short
        }

        ListNode firstHead = head;

        while (head != null && head.next != null) {
            int x = head.val;
            int y = head.next.val;
            int gcd = GCD(x, y);

            ListNode newNode = new ListNode(gcd);
            newNode.next = head.next;
            head.next = newNode;

            head = head.next.next; // Move ahead two nodes
        }
        return firstHead;
    }
}