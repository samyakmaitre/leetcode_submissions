/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Step 1: Traverse both lists to find lengths and last nodes
        ListNode currA = headA;
        ListNode currB = headB;
        int lenA = 0, lenB = 0;
        ListNode tailA = null, tailB = null;
        
        while (currA != null) {
            lenA++;
            tailA = currA;
            currA = currA.next;
        }
        
        while (currB != null) {
            lenB++;
            tailB = currB;
            currB = currB.next;
        }
        
        // Step 2: If the last nodes are different, no intersection
        if (tailA != tailB) {
            return null;
        }
        
        // Step 3: Find the absolute difference in lengths
        int diff = Math.abs(lenA - lenB);
        
        // Step 4: Traverse the longer list by the absolute difference
        currA = headA;
        currB = headB;
        if (lenA > lenB) {
            while (diff-- > 0) {
                currA = currA.next;
            }
        } else {
            while (diff-- > 0) {
                currB = currB.next;
            }
        }
        
        // Step 5: Traverse both lists in parallel until intersection
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        
        // Return the intersection node
        return currA;
    }
}
