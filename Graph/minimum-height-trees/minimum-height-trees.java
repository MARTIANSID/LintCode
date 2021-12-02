class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        
        if(n==1||n==2){
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<n;i++)ans.add(i);
            return ans;
        }
        
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        int[] indegree=new int[n];
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }
        
        
        LinkedList<Integer> que=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(indegree[i]==1)que.add(i);
        }
        
       
        List<Integer> a=new ArrayList<>();
        while(que.size()!=0){
            int size=que.size();
          
            while(size-->0){
            int vrtx=que.removeFirst();
                
                a.add(vrtx);
                   
            for(int child:graph.get(vrtx)){


                indegree[child]--;
                if(indegree[child]==1){
                           

                    que.addLast(child);
                }
        }
            }
            if((que.size()==1||que.size()==2)&&(a.size()==n-2||a.size()==n-1)){
                List<Integer> ans=new ArrayList<>();
                for(int i=0;i<que.size();i++){
                    ans.add(que.get(i));
                    
                }
                return ans;
            }
        
        }
        return null;
        
    }
}
