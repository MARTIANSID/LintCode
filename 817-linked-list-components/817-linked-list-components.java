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
    
    // public int findParent(int[] parent,int u){
    //     if(parent[u]==u){
    //         return u;
    //     }
    //     int x=findParent(parent,parent[u]);
    //     parent[u]=x;
    //     return x;
    // }
    
    public int numComponents(ListNode head, int[] nums) {
       
        HashSet<Integer> set=new HashSet<>();
        for(int ele:nums){
            set.add(ele);
        }
        boolean prev=false;
        int connectedComp=0;
        while(head!=null){
            boolean noInNums=set.contains(head.val);
            
            if(noInNums){
                prev=true;
            }else{
                if(prev)connectedComp++;
                prev=false;
            }
            
            head=head.next;
            
        }
        
        if(prev)connectedComp++;
        
        return connectedComp;
        
        
    }
}