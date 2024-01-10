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
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        List<List<Integer>> graph = new ArrayList<>();
        
        int n = (int)1e5;
        
        for(int i=0;i<=n;i++)graph.add(new ArrayList<>());
        
        makeGraph(root,graph);
        
        LinkedList<Integer> que=new LinkedList<>();
        
        que.add(start);
        
        boolean[] visited=new boolean[n+1];
        
        int level=0;
        
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                int node=que.removeFirst();
                if(visited[node])continue;
                visited[node]=true;
                
                for(int child:graph.get(node)){
                    if(!visited[child]){
                        que.add(child);
                    }
                }
            }
            level++;
        }
        return level-1;
        
    }
    public void makeGraph(TreeNode root, List<List<Integer>> graph){
        
        if(root == null)return;
        
        if(root.left!=null){
            graph.get(root.val).add(root.left.val);
            graph.get(root.left.val).add(root.val);
        }
        
        if(root.right!=null){
            graph.get(root.val).add(root.right.val);
            graph.get(root.right.val).add(root.val);
        }
        
        makeGraph(root.left,graph);
        makeGraph(root.right,graph);
        
        
    }
        
//     public int nodes(TreeNode root){
//         if(root == null)return 0;
        
//         int cnt=0;
        
//         cnt+=nodes(root.left);
//         cnt+=nodes(root.right);
        
//         return cnt+1;
//     }
}