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

    while(head != last) {
        ListNode temp = head.next;
        head.next = last.next;
        last.next = head;
        
        head = temp;
    }

    return last;
  }
}
