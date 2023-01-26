import java.util.ArrayList;
import java.util.*;
class Solution {
  class pair{
    int vrtx;
    int cost;
    int stops;
    pair(int vrtx,int cost,int stops){
      this.vrtx=vrtx;
      this.cost=cost;
      this.stops=stops;
    }
  }
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    List<List<pair>> graph=new ArrayList<>();
    for(int i=0;i<n;i++){
      graph.add(new ArrayList<>());
    }

    for(int i=0;i<n;i++)graph.add(new ArrayList<>());
      for(int[] f:flights){
        int u=f[0],v=f[1];
        graph.get(u).add(new pair(v,f[2],0));
      }
      
      boolean[][] visited=new boolean[n][2*n+1];
     
      PriorityQueue<pair> que=new PriorityQueue<>((a,b)->{
        return a.cost-b.cost;
      });
      que.add(new pair(src,0,0));

      while(que.size()!=0){
        int size=que.size();
        while(size-->0){
          pair p=que.poll();
          int vrtx=p.vrtx;
          int cost=p.cost;
          if(visited[vrtx][p.stops])continue;
          if(p.stops-1>k)continue;
          if(vrtx == dst){ 
              return cost;
          }
          visited[vrtx][p.stops]=true;
          for(pair child:graph.get(vrtx)){
              que.add(new pair(child.vrtx,child.cost+cost,p.stops+1));
          }
        }
      }
      return -1;
  }
}