class Solution {
    
    List<List<Integer>> graph;
     int[] ans;
    int[] childs;
    
        
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph=new ArrayList<>();
        childs=new int[n];
        
        ans=new int[n];
    
    for(int i=0;i<n;i++){
        graph.add(new ArrayList<>());
    }
        
    //making the graph
    for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
       bottomUp(0,-1,n);
        
        // for(int i=0;i<n;i++)System.out.println(childs[i]);
        
        calc(n,0,-1);
        
     
        
        return ans;
    
    }
    
    
    public void bottomUp(int src,int parent,int n){
        
        int sum=0;
      
        int x=0;
        for(int child:graph.get(src)){
            if(child!=parent){
                 bottomUp(child,src,n);
                    childs[src]+=childs[child]+1;
                    ans[src]+=ans[child]+childs[child]+1;
            }
            
        }
        
    }
    
  
    
    public void calc(int n,int src,int parent){
         for(int child:graph.get(src)){
            if(child!=parent){
                
                ans[child]=(ans[src]-childs[child])+(n-(childs[child]+2));
               calc(n,child,src);
            
            }
            
        }
    }
   
}