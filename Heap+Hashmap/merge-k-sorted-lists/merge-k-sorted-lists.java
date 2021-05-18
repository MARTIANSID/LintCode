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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->{
                return a.val-b.val;
        });
            
            ListNode dummy=new ListNode(-1);
            ListNode curr=dummy;
            
            
        for(int i=0;i<lists.length;i++)if(lists[i]!=null)pq.add(lists[i]);
            
            
         while(pq.size()!=0){
              ListNode n=   pq.poll();
                curr.next=new ListNode(n.val);
                 curr=curr.next;
                if(n.next!=null){
                        pq.add(n.next);
                }  
                 
         }   
            
            return dummy.next;
            
    }
}