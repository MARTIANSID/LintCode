class Solution {
    
    HashMap<Long,Integer> map=new HashMap<>();
    long max=0;
    public int countHighestScoreNodes(int[] parents) {
        
        
            List<List<Integer>> graph=new ArrayList<>();
            int n=parents.length;
            for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            if(parents[i]!=-1){
                graph.get(parents[i]).add(i);
            }
        }
        
        
        
        int total=size(graph,0);
        
        
        dfs(graph,0,total);
       
        
      
       return map.get(max);
        
        
        
        
    }
    
    public long dfs(List<List<Integer>> graph,int src,int total){
        long ans=0;
        List<Long> a=new ArrayList<>();
        for(int child:graph.get(src)){
              ans=(dfs(graph,child,total));
            a.add(ans);
            
        }
        long sum=0,prod=1;
        for(long ele:a){
            sum+=ele;
            prod*=ele;
            
        }
       long x=(total-sum-1)==0?1:(total-sum-1);
      
        max=Math.max(max,x*prod);
        
        map.put(x*prod,map.getOrDefault(x*prod,0)+1);
        
        
        return sum+1;
    }
    
    
    public int size(List<List<Integer>> graph,int src){
        
        int ans=0;
        for(int child:graph.get(src)){
             ans+=(size(graph,child));
        }
        return ans+1;
    }
    

   
}