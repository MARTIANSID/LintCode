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
        
        // ListNode curr=head;
        // ListNode next=head;
        
       ListNode curr=head;
        ListNode start=curr;
        while(curr.next!=null)
        {
            
            if(curr.val==curr.next.val){
                curr.next=curr.next.next;
                
            }else{
                curr=curr.next;
                
            }
            
            
        }
        return start;
}
}


// 1->1->1

// [1,1,1`]
// ->1->2
    
    
//     1,1,2,3,3