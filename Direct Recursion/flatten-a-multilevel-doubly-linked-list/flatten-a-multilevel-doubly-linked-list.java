/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
       
        if(head==null)return head;
        
        Node front=head;
        f(head);
        return front;
    }
    
    public Node f(Node head){
        
        if(head.child!=null){
           Node node= f(head.child);
            node.next=head.next;
            if(head.next!=null)
            head.next.prev=node;
            head.next=head.child;
            head.child.prev=head;
            head.child=null;
        }
        
        
        if(head.next==null)return head;
        
          return   f(head.next);


    
       
    }
}