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
    public int[] nextLargerNodes(ListNode head) {
         int n=sizee(head);
        int[] right=new int[n];
          head=  reverse(head);
            
           Arrays.fill(right,0);
            
            Stack<Integer> st=new Stack<>();
            int i=n-1;
            
           while(head!=null){
                   while(st.size()>0&&st.peek()<=head.val){
                           st.pop();
                   }
                   if(st.size()>0&&st.peek()>head.val){
                           
                           right[i]=st.peek();
                   }
                   st.push(head.val);
                   
                   head=head.next;
                   i--;
           }
            return right;
    }
        
        public int sizee(ListNode head){
                ListNode curr=head;
                int count=0;
                
                while(curr!=null){
                        count++;
                        curr=curr.next;
                }
                return count;
        }
        
        public ListNode reverse(ListNode head){
                ListNode curr=head;
                ListNode prev=null;
                
                while(curr!=null){
                        
                        ListNode next=curr.next;
                        curr.next=prev;
                        prev=curr;
                        curr=next;
                }
                 return prev;
        }
       
}