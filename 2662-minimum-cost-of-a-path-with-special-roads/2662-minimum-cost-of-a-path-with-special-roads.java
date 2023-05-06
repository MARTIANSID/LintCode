import java.util.*;
class Solution {
    class pair{
        int x;
        int y;
        int cost;
        pair(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int n=start.length;
        
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });

        pq.add(new pair(start[0],start[1],0));

        HashSet<String> visited=new HashSet<>();

        while(pq.size()!=0){
            pair p=pq.poll();
            int x=p.x,y=p.y,cost=p.cost;
            String key=x+"."+y;
            if(visited.contains(key))continue;
            visited.add(key);
            if(x == target[0] && y == target[1])return cost;
            pq.add(new pair(target[0],target[1],cost+Math.abs(x-target[0])+Math.abs(y-target[1])));
            
            for(int[] sR:specialRoads){
                int sx1=sR[0],sy1=sR[1],sx2=sR[2],sy2=sR[3],scost=sR[4];
                String key1=sx1+"."+sy1;
                String key2=sx2+"."+sy2;

                if(x == sx1 && y == sy1){
                    if(!visited.contains(key2)){
                        pq.add(new pair(sx2,sy2,cost+scost));
                    }
                }else if(x == sx2 && y == sy2){
                    if(!visited.contains(key1)){
                        pq.add(new pair(sx1,sy1,cost+Math.abs(x-sx1)+Math.abs(y-sy1)));
                    }
                }else{
                    if(!visited.contains(key2)){
                        pq.add(new pair(sx2,sy2,cost+Math.abs(x-sx2)+Math.abs(y-sy2)));
                    }
                    if(!visited.contains(key1)){
                        pq.add(new pair(sx1,sy1,cost+Math.abs(x-sx1)+Math.abs(y-sy1)));
                    }
                }
                
            }
        }
            return -1;
    }
}