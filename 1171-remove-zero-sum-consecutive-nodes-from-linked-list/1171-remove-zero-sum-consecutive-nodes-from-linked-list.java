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
        
        HashMap<Integer, List<ListNode>> map = new HashMap<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        List<ListNode> arr = new ArrayList<>();
        
        arr.add(dummy);
        
        map.put(0, arr);

        int sum = 0;

        while (head != null) {
            sum += head.val;

            if (map.containsKey(sum)) {
                List<ListNode> temp = map.get(sum);
                
                for(ListNode node : temp){
                    node.next = head.next;
                }
                
            }
            
            if(!map.containsKey(sum)){
                map.put(sum, new ArrayList<>());
            }
           
            map.get(sum).add(head);
            
            head = head.next;
        }
        return dummy.next;
    }
}
