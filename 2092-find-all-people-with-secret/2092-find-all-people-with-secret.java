class Solution {
    
    class pair{
        int vrtx;
        int t;
        pair(int vrtx,int t){
            this.vrtx=vrtx;
            this.t=t;
        }
    }
    
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        
            List<Integer> ans=new ArrayList<>(); 
            List<List<int[]>> graph=new ArrayList<>();
            for(int i=0;i<n;i++)graph.add(new ArrayList<>());
             
        
            //buuld graph
        
            for(int[] met:meetings){
                int u=met[0],v=met[1],w=met[2];
                graph.get(u).add(new int[]{v,w});
                graph.get(v).add(new int[]{u,w});
                 
            }
        
            PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
                return a.t-b.t;
            });
            
            for(int[] child:graph.get(0)){
                pq.add(new pair(child[0],child[1]));
            }
        
            for(int[] child:graph.get(firstPerson)){
                pq.add(new pair(child[0],child[1]));
            }
        
            
            boolean[] visited=new boolean[n];
            int time=0;
            while(pq.size()!=0){
                pair p=pq.poll();
                if(visited[p.vrtx])continue;
                ans.add(p.vrtx);
                time=p.t;
                visited[p.vrtx]=true;
                
                for(int[] child:graph.get(p.vrtx)){
                    if(time<=child[1]&&!visited[child[0]]){
                        pq.add(new pair(child[0],child[1]));
                    }
                }
                
            }
        
        if(!ans.contains(0))ans.add(0);
        if(!ans.contains(firstPerson))ans.add(firstPerson);
        
        return ans;
        
        
        
        
    }
}