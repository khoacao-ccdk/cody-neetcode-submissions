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
    if (head == null || head.next == null) return head;

    ListNode last = head;

    while(last.next != null) {
        last = last.next;
    }

    ListNode newHead = last;
    while(head != newHead) {
        ListNode temp = head.next;
        head.next = newHead.next;
        newHead.next = head;
        
        head = temp;
    }

    return newHead;

  }
}
