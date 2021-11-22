class Solution {
    int maxVal=-(int)1e9;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<List<int[]>> graph=new ArrayList<>();
        maxVal=values[0];
        int n=values.length;
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        
        for(int[] e:edges){
            int s=e[0];
            int j=e[1];
            int w=e[2];
            graph.get(s).add(new int[]{j,w});
            graph.get(j).add(new int[]{s,w});
        }
        
        solve(graph,maxTime,values,0,0);
        return maxVal;
         
    }
    
    public void solve(List<List<int[]>> graph,int maxTime,int[] values,int src,int val){
        if(src==0){
            maxVal=Math.max(maxVal,val);
        }
        for(int[] child:graph.get(src)){
            int vrtx=child[0],w=child[1];
            if(maxTime-w>=0){
                int v=values[src];
                values[src]=0;
                solve(graph,maxTime-w,values,vrtx,val+v);
                values[src]=v;
            }
            
        }
        
    }
}