/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer,Node> map=new HashMap<>();
    public Node cloneGraph(Node node) {
        
        boolean[] visited=new boolean[101];
        
        return buildGraph(node,visited);
        
    }
    public Node buildGraph(Node node,boolean[] visited){
        if(node==null)return null;
        visited[node.val]=true;
        
        List<Node> children=node.neighbors;
        Node n=new Node(node.val);
        map.put(node.val,n);
        for(Node child:children){
            if(!visited[child.val]){
                n.neighbors.add(buildGraph(child,visited));
            }else{
                 n.neighbors.add(map.get(child.val));
            }
            
        }
        
        return n;
    }
}