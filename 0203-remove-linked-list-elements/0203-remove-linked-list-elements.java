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
    public ListNode removeElements(ListNode head, int val) {
        // Handle the case where the head node itself has the value to be removed
        while (head != null && head.val == val) {
            head = head.next;
        }
        
        ListNode current = head;
        ListNode prev = null;
        
        while (current != null) {
            if (current.val == val) {
                // Skip the current node by adjusting the pointers of the previous node
                prev.next = current.next;
            } else {
                // Update the previous node only if the current node's value is not to be removed
                prev = current;
            }
            current = current.next;
        }
        
        return head;
    }
}
