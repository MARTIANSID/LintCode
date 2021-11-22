class Solution {
     class  pair{
        int vrtx;
        int fees;
        int time;
        pair(int vrtx,int fees,int time){
            this.vrtx=vrtx;
            this.fees=fees;
            this.time=time;
        }
    }
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        List<List<int[]>> graph=new ArrayList<>();
        int n=passingFees.length;
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        //build graph
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int fee=e[2];
            graph.get(u).add(new int[]{v,fee});
            graph.get(v).add(new int[]{u,fee});
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            if(a.fees==b.fees)return a.time-b.time;
            return a.fees-b.fees;
        });
        boolean[] visited=new boolean[n];
        int[] v=new int[n];
        pq.add(new pair(0,passingFees[0],0));
        while(pq.size()!=0){
            pair p= pq.poll();
            if(p.vrtx==n-1)return p.fees;   
            visited[p.vrtx]=true;
            v[p.vrtx]=p.time;
            for(int[] child:graph.get(p.vrtx)){
                if(!visited[child[0]]&&(p.time+child[1])<=maxTime){
                    pq.add(new pair(child[0],p.fees+passingFees[child[0]],p.time+child[1]));
                }else if(visited[child[0]]&&v[child[0]]>(p.time+child[1])){
                    v[child[0]]=p.time+child[1];
                      pq.add(new pair(child[0],p.fees+passingFees[child[0]],p.time+child[1]));
                }
            }
            
        }
        
        return -1;
    }
}