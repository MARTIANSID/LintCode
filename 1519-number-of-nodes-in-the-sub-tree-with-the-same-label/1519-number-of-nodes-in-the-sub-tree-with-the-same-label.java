class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        
        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int[] ans=new int[n];
        dfs(graph,0,-1,labels,ans);
        
        return ans;
        
    }
    public int[] dfs(List<List<Integer>> graph,int src,int parent,String labels,int[] ans){
        
        int[] f=new int[26];
        for(int child:graph.get(src)){
            if(child!=parent){
                int[] freq=dfs(graph,child,src,labels,ans);
                for(int i=0;i<26;i++){
                    f[i]+=freq[i];
                }
            }
        }
        f[labels.charAt(src)-'a']++;
        ans[src]=f[labels.charAt(src)-'a'];
        return  f;
        
    }
}