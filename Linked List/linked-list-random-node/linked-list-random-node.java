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

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head;
    
    List<Integer> nodes=new ArrayList<>();
    
    public Solution(ListNode head) {
        this.head=head;
        ListNode curr=head;
        while(curr!=null){
            nodes.add(curr.val);
            curr=curr.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
         Random r = new Random();
 int x= r.nextInt(nodes.size());
        return nodes.get(x);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */