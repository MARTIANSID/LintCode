/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// 5 - > [(1,left),(2,right)]
// 1 - > [(5,parent),(3,left)]
// 3 - > [(1,parent)]
// 2 - > [(5,parent),(6,left),(4,right)]
// 6 - > [(2,parent)]
// 4 - > [(2,parent)]


// que = [(3,"")]

// que = [(1,"U")]

// que = [(5,"UU")]

// que = [(2,"UUR")]

// que = [(6,"UURL"),(4,"UURR")]






class Solution {
    
    class Node {
        int val;
        char relation;
        
        Node(int val, char relation) {
            this.val = val;
            this.relation = relation;
        }
        
    }
    
    class Path {
            int currentNode;
            String path;
            
            Path(int currentNode, String path) {
                this.currentNode = currentNode;
                this.path = path;
            }
        }
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        List<List<Node>> graph = new ArrayList<>();
        
        int n = noOfNodes(root);
        
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        makeGraph(root, graph, -1);
        
        boolean[] visited = new boolean[n + 1];
        
        LinkedList<Path> que = new LinkedList<>();
        
        que.add(new Path(startValue,""));
        
        while(que.size() != 0) {
            int size = que.size();
            
            while(size --> 0) {
                Path p = que.removeFirst();
                
                int node = p.currentNode;
                String path = p.path;
                
                if(node == destValue) {
                    return path;
                }
                
                if(visited[node]) {
                    continue;
                }
                visited[node] = true;
                
                for(Node child : graph.get(node)) {
                    
                    if(!visited[child.val]) {
                        que.add(new Path(child.val,path + child.relation));
                    }
                }
            }
        }
        return "";
        
    }
    
    private int noOfNodes(TreeNode root) {
        
        if(root == null) return 0;
        
        int cnt = 0;
        
        cnt += noOfNodes(root.left);
        cnt += noOfNodes(root.right);
        
        return cnt + 1;
    }
    
    private void makeGraph(TreeNode node, List<List<Node>> graph, int parent) {
        if(node == null) return;
        
        
        int val = node.val;
        
        if(parent != -1) {
            graph.get(val).add(new Node(parent,'U'));
        }
        
        if(node.left != null) {
            graph.get(val).add(new Node(node.left.val, 'L'));
        }
        
        if(node.right != null) {
            graph.get(val).add(new Node(node.right.val, 'R'));
        }
        
        makeGraph(node.left, graph, node.val);
        makeGraph(node.right, graph, node.val);
    }
}