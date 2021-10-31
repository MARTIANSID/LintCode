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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        if(head==null||head.next==null||head.next.next==null)return new int[]{-1,-1};
        List<Integer> criticalPoints=new ArrayList<>();
        ListNode p=head;
        int prev=p.val;
        p=p.next;
        
        int count=1;
        while(p!=null){
            if(p.next!=null){
                if((p.val>p.next.val&&p.val>prev)||(p.val<p.next.val&&p.val<prev)){
                    criticalPoints.add(count);
                }
            }
            count++;
            prev=p.val;
            p=p.next;
        }
        
        if(criticalPoints.size()<2)return new int[]{-1,-1};
        
        int maxDist=criticalPoints.get(criticalPoints.size()-1)-criticalPoints.get(0);
        
        int min=(int)1e9;
        for(int i=0;i<criticalPoints.size()-1;i++){
            min=Math.min(min,criticalPoints.get(i+1)-criticalPoints.get(i));
        }
        
        return new int[]{min,maxDist};
    }
}