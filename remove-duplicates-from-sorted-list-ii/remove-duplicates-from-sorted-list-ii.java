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
    public ListNode deleteDuplicates(ListNode head) {
        
        
        if(head==null||head.next==null)return head;
        ListNode curr=head;
        ListNode start=head;
        ListNode prev=new ListNode(-(int)1e9);
        
        while(curr.next!=null){
            ListNode c=curr;
            ListNode p=prev;
            if(curr.val==curr.next.val){
                
              while(curr!=null&&c.val==curr.val){
                 
                  curr=curr.next;
                  
                  
              }  
                
            
                if(p.val==-(int)1e9){
                   start=curr;
                }
                p.next=curr;
                
                if(curr==null)break;
                
            }else{
                prev=curr;
                curr=curr.next;
            }
        }
        
        return start;
        
    }
}


// [1,2,3,3,3]


