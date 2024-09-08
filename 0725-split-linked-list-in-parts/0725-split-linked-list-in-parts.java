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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode current = head;
        while (current != null) {
            n++;
            current = current.next;
        }

        int partSize = n / k;
        int remainder = n % k;

        ListNode[] result = new ListNode[k];

        current = head;
        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            ListNode prev = null;
            
            int currentPartSize = partSize + (i < remainder ? 1 : 0);
            
            for (int j = 0; j < currentPartSize; j++) {
                prev = current;
                if (current != null) {
                    current = current.next;
                }
            }

            if (prev != null) {
                prev.next = null;
            }

            result[i] = partHead;
        }
        
        return result;
    }
}
