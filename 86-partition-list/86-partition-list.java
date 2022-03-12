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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy=new ListNode(-1);
        
        ListNode h=head;
        ListNode newHead=dummy;
        
        while(head!=null){
            if(head.val<x){
                dummy.next=new ListNode(head.val);
                dummy=dummy.next;
            }
            head=head.next;
        }
        while(h!=null){
            if(h.val>=x){
                dummy.next=new ListNode(h.val);
                dummy=dummy.next;
            }
            h=h.next;
        }
        
        return newHead.next;
    }
}