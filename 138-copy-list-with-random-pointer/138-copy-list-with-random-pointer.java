/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
        
        Node newHead=head;

        while(head!=null){
            int val=head.val;
            Node curr=null,next=null,random=null;
            
            if(map.containsKey(head))curr=map.get(head);
            else curr=new Node(val);
            
             map.put(head,curr);
            
            if(head.next!=null){
                if(map.containsKey(head.next)){
                    next=map.get(head.next);
                }else{
                    next=new Node(head.next.val);
                    
                }
            }
            
             if(head.next!=null)
            map.put(head.next,next);
            
            
            
            if(head.random!=null){
                if(map.containsKey(head.random)){
                    random=map.get(head.random);
                }else{
                    random=new Node(head.random.val);
                }
            }
            
            curr.next=next;
            curr.random=random;
            

           
            if(head.random!=null)
            map.put(head.random,random);
            head=head.next;
                
            }
        return map.get(newHead);
        }
    }
