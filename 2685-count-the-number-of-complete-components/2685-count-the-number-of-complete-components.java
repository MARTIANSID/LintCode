class Solution {
    public int findParent(int x,int[] parent){
        if(parent[x] == x){
            return x;
        }
        int u=findParent(parent[x],parent);
        parent[x]=u;
        return u;
    }
    public int countCompleteComponents(int n, int[][] edges) {
       int[] parent=new int[n];
       int[] size=new int[n];
        
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        for(int[] e:edges){
            int u=e[0],v=e[1];
            
            int p1=findParent(u,parent);
            int p2=findParent(v,parent);
            if(p1!=p2){
                parent[p1]=p2;
                size[p2]+=size[p1]+1;
            }else{
                size[p1]++;
            }
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            int p=findParent(i,parent);
            map.put(p,map.getOrDefault(p,0)+1);
        }
       
        int cnt=0;
        Set<Integer> set=map.keySet();
        for(int key:set){
            int nodes=map.get(key);
            int edge=size[key];
            int val=((nodes)*(nodes-1))/2;
            if(val == edge)cnt++;
        }
        return cnt;
        
    }
}