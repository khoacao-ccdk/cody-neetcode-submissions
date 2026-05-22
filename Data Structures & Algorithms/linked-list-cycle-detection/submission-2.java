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
  public boolean hasCycle(ListNode head) {
    if(head == null || head.next == null) return false;

    ListNode hare = head.next, turtle = head;

    while(hare.next != null && hare.next.next != null) {
        if(hare == turtle) return true;

        turtle = turtle.next;
        hare = hare.next.next;
    }

    return false;
  }
}
