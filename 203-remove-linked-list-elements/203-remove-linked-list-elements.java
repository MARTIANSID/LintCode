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
        
        if(head == null)return head;
        
         ListNode prev=null;
        
        while(head!=null && head.val==val){
            head=head.next;
        }
        
        
        ListNode start=head;
        
        while(head!=null){
            if(head.val == val){
                prev.next=head.next;
                ListNode temp=head.next;
                head.next=null;
                head=temp;
            }else{
                prev=head;
                head=head.next;
            }
        }
        return start;
        
    }
}