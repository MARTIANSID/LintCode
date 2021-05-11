class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>(); 
          
            if(richer.length==0){
                    
                    Arrays.sort(quiet);
                    return quiet;
            }
            
            
              for(int i=0;i<quiet.length;i++){
                      
                graph.add(new ArrayList<>());
              }
           
            
           for(int i=0;i<richer.length;i++){
                   
                   int u=richer[i][0];
                   int v=richer[i][1];
                   
                   graph.get(v).add(u);
           } 
            
            
            List<Integer> result=new ArrayList<>();
            int[] ans=new int[quiet.length];
            
            
            boolean[] visited=new boolean[quiet.length];
            
            
            for(int i=0;i<quiet.length;i++){
                    
                    dfs(graph,visited,result,i);
                   ans[i]= getMin(result,quiet,i);
                visited=new boolean[quiet.length];
                    result=new ArrayList<>();
                    
                    
            }
            
            return ans;
            
    }
        public void dfs(ArrayList<ArrayList<Integer>> graph,boolean[] visited,  List<Integer> result,int src){
                
        visited[src]=true;
        result.add(src);
                
        for(int child:graph.get(src)){
                if(visited[child]!=true)
                        dfs(graph,visited,result,child);
        }
                
                
        
                
        }
        
         public int getMin(List<Integer> result,int[] quiet,int j){
                 
                 int max=(int)1e9;
                 int a=j;
                
                 for(int i=0;i<result.size();i++){
                       if(quiet[result.get(i)]<max){
                               a=result.get(i);
                               max=quiet[result.get(i)];
                       }
                 }
                 
                 return a;
         }
}