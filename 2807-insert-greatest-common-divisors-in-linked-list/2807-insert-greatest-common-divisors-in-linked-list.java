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

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null)return head;
        
        ListNode start=head;
        
        while(head.next != null){
            int first=head.val;
            int second=head.next.val;
            int hcf=gcd(first,second);
            ListNode temp=head.next;
            head.next=new ListNode(hcf);
            head.next.next=temp;
            head=head.next.next;
        }
        return start;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
