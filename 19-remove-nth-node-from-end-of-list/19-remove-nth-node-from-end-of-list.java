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

    public int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        
        int cnt = length - n;
        if(cnt==0){
            return head.next;
        }
        ListNode h = head;
        while (cnt-- > 1) {
            head = head.next;
        }
        if(head.next==null){
            head.next=null;
        }else{
            head.next=head.next.next;
        }
        return h;
    }
}
