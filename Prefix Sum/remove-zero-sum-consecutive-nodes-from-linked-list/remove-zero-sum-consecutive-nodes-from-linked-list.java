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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer,List<ListNode>> map=new HashMap<>();
            ListNode curr=head;
            
            ListNode dummy=new ListNode(-1);
            dummy.next=head;
            List<ListNode> ini=new ArrayList<>();
            ini.add(dummy);
            map.put(0,ini);
            int sum=0;
            while(curr!=null){
                    List<ListNode> arr=new ArrayList<>();
                  sum+=curr.val;
                  if(map.containsKey(sum)){
                            
                arr=map.get(sum);
                    for(ListNode node:arr){
                            
                            node.next=curr.next;
                    }
                          
                             
                  }
                    arr.add(curr);
                 
                    map.put(sum,arr);
                   
                  
               
                    curr=curr.next;
                    
            }
            return dummy.next;
    }
}