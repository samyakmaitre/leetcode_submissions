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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // This will eventually be the new head
        ListNode curr = head; // Start with the head of the list
        ListNode next = null; // Will be used to temporarily store the next node
        
        while (curr != null) {
            next = curr.next; // Save the next node
            curr.next = prev; // Reverse the link
            prev = curr; // Move prev to current
            curr = next; // Move current to next node
        }
        
        return prev; // prev will be the new head at the end of the list
    }
}

// Additional utility methods to create and print the linked list
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a linked list [1, 2, 3, 4, 5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse the linked list
        ListNode reversedHead = solution.reverseList(head);

        // Print the reversed linked list
        printList(reversedHead);
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}