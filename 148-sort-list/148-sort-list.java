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
    
    ListNode midNode(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        
        while(slow!=null&&fast.next!=null&&fast!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
        
    }
    
    
    public int length(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }
    
    public ListNode sortList(ListNode head) {
        
        if(head==null||head.next==null)return head;
        
        
        return mergeSort(head);
        
        
    }
    
    public ListNode mergeSort(ListNode head){
        
    if(head.next==null)return head;
        
      ListNode mid=  midNode(head);
        ListNode nextMid=mid.next;
        mid.next=null;
    
       ListNode left= mergeSort(head);
       ListNode right= mergeSort(nextMid);
        
        return mergeTwoList(left,right);
        
    }
    
    public ListNode mergeTwoList(ListNode left,ListNode right){
        ListNode dummy=new ListNode(-1);
        
        ListNode head=dummy;
        
        while(left!=null&&right!=null){
            if(left.val<right.val){
                dummy.next=left;
                dummy=dummy.next;
                left=left.next;
            }else{
                dummy.next=right;
                dummy=dummy.next;
                right=right.next;
            }
        }
        
        while(left!=null){
            dummy.next=left;
            dummy=dummy.next;
            left=left.next;
        }
        
         while(right!=null){
            dummy.next=right;
            dummy=dummy.next;
            right=right.next;
        }
        
        return head.next;
        
        
    }
}