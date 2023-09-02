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
    public ListNode doubleIt(ListNode head) {
        ListNode dummy=head;
        ListNode d=head;
        
        int carry=solve(dummy);
        if(carry>0){
            ListNode node=new ListNode(carry);
            node.next=head;
            return node;
        }
        
        return head;
    }
    
    public int solve(ListNode head){
        if(head == null)return 0;
        
        int carry=solve(head.next);
        int value=2*(head.val)+carry;
        int c=value/10;
        head.val=value%10;
        return c;
    }
}