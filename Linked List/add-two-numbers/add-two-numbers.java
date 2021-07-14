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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry=0;
        int result=0;
        ListNode dummy=new ListNode(-1);
       ListNode head=dummy;
        
        
        while(l1!=null&&l2!=null){
            int x=l1.val+l2.val+carry;
            carry=x/10;
            result=x%10;
            ListNode node= new ListNode(result);
            dummy.next=node;
            dummy=node;
            l1=l1.next;
            l2=l2.next;
            
        }
        
        // return head.next;
        
        while(l1!=null){
            int x=l1.val+carry;
            carry=x/10;
            result=x%10;
             ListNode node= new ListNode(result);
            dummy.next=node;
            dummy=node;
            l1=l1.next;
            // l2=l2.next;
            
            
        }
        
        while(l2!=null){
            
             int x=l2.val+carry;
            carry=x/10;
            result=x%10;
             ListNode node= new ListNode(result);
            dummy.next=node;
            dummy=node;
            l2=l2.next;
            
        }
        
        if(carry>0){
            ListNode node=new ListNode(carry);
            dummy.next=node;
            
        }
        
        return head.next;
        
        
        // return null;
    }
}

// carry=0;
// [2,4,3]
// [5,6,4]

// 7%10--7 result
// 7 /10--- 0 carry

// 10%10--- 0--result

// 10/10-- 1---carry

// 3+4+1=11
// 11%10--- 1 result

// 11/10-- 1


// [3,4,2]
// [4,5]

