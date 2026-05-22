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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode result = new ListNode(), last = result;

    while(list1 != null && list2 != null) {
        if(list1.val < list2.val) {
            last.next = list1;
            list1 = list1.next;
        }
        else {
            last.next = list2;
            list2 = list2.next;
        }

        last = last.next;
    }

    cleanup(list1, last);
    cleanup(list2, last);

    return result.next;
  }

  private void cleanup(ListNode list, ListNode result) {
    while(list != null) {
        result.next = list;
        list = list.next;
        result = result.next;
    }
  }
}