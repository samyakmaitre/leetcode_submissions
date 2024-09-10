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
    static int GCD(int a, int b)
    {
        int i;
        if (a < b)
            i = a;
        else
            i = b;
        for (i = i; i > 1; i--) {
            if (a % i == 0 && b % i == 0)
                return i;
        }
        return 1;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode firstHead = head;
        while(head != null && head.next != null){
            int x = head.val;
            int y= head.next.val;
            int gcd = GCD(x,y);
            ListNode newNode = new ListNode(gcd);
            newNode.next = head.next;
            head.next = newNode;

            head = head.next.next;
        }
        return firstHead;
    }
}