
class Solution {
    public int findParent(int u,int[] parent){
                if(parent[u]==u){
                        return u;
                }
             int x=   findParent(parent[u],parent);
                parent[u]=x;
                return x;
        }
    public int largestComponentSize(int[] nums) {
        
        int[] parent=new int[1000000];
            for(int i=0;i<parent.length;i++){
                    parent[i]=i;         
            }
        
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int ele :nums)h.put(ele,1);
            
        int n=nums.length,max=0;
        
        for(int ele:nums)max=Math.max(max,ele);
        
        for(int i=2;i<=max;i++){
            for(int j=i*2;j<=max;j+=i){
                if(!h.containsKey(j))continue;
             
                int p1=findParent(i,parent);
                int p2=findParent(j,parent);

                if(p1!=p2){
                    parent[p1]=p2;
                }
   
            }
    } 
            int m=0;
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                     int p=  findParent(nums[i],parent);
              
                     m=Math.max(m,map.getOrDefault(p,0)+1);
                    map.put(p,map.getOrDefault(p,0)+1);
            }
        

            return m;
    }
}