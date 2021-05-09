class Solution {
    boolean cycle=false; 
    
 public int largestPathValue(String colors , int[][] edges) {
         
         if(edges.length==0){
                 return 1;
         }
         
     List<List<Integer>> graph=new ArrayList<>();
         int n=colors.length();
         
         for(int i=0;i<=n;i++){
                 graph.add(new ArrayList<>());
         }
         
       for(int i=0;i<edges.length;i++){
               int u=edges[i][0];
               int v=edges[i][1];
              
               
               graph.get(u).add(v);
       }  
         
          int max=0;
         HashMap<Integer,int[]> map=new HashMap<>();
         boolean[] visited=new boolean[n+1]; 
         
         int[] visited2=new int[n+1];// TO CHECK CYCLE
     
      
         
         for(int i=0;i<n;i++){
             if(!map.containsKey(i)){
                      int[] arr= dfs(i,graph,visited,map,colors,visited2);
                     
                     if(cycle)return -1;
               
                 for(int j=0;j<26;j++){
                         max=Math.max(arr[j],max);
                 }
             }
               
         }
         return max;
         
         
 }
     public int[] dfs(int src,List<List<Integer>> graph,boolean[] visited,HashMap<Integer,int[] > map,String colors,int[] visited2){
             
           
             if(map.containsKey(src))return map.get(src);
             
             visited[src]=true;
            visited2[src]=-1;
          int[] arr=new int[26];
             for(int child:graph.get(src)){
                     if(visited2[child]==-1){
                             cycle=true;
                     }
                     if(visited[child]!=true){
                         int[] a=    dfs(child,graph,visited,map,colors,visited2);
                             for(int i=0;i<26;i++){
                                   arr[i]=  Math.max(arr[i],a[i]);
                             }
                     }
             }
             visited[src]=false;
             visited2[src]=2;
              arr[colors.charAt(src)-'a']++;
             map.put(src,arr);
             return  arr;
             
             
             
     }
     

}