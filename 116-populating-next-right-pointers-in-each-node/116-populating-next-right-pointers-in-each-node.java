/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root==null)return null;
        
        LinkedList<Node> que=new LinkedList<>();
        que.add(root);
        
        while(que.size()!=0){
            int size=que.size();
            int index=0;
            LinkedList<Node> st=new LinkedList<>();
            while(size-->0){
                Node node=que.removeFirst();
                if(node.left!=null){
                    
                    que.add(node.left);
                    st.add(node.left);
                }
                if(node.right!=null){
                   
                    que.add(node.right);
                    st.add(node.right);
                }  
                
                while(st.size()>=2){
                 st.removeFirst().next=st.peek();
                }

            }
            
        }
        return root;
    }
}