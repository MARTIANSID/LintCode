class Solution {
    public int findParent(int u,int[] parent){
        if(parent[u] == u)return u;
        
        int x=findParent(parent[u],parent);
        parent[u]=x;
        return x;
    }
    class pair{
        int index;
        int val;
        pair(int index,int val){
            this.index=index;
            this.val=val;
        }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        
        HashMap<Integer,PriorityQueue<Integer>> map=new HashMap<>();
        
        int[] parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        List<pair> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new pair(i,nums[i]));
        }
        Collections.sort(arr,(a,b)->{
            return a.val-b.val;
        });
        
        for(int i=0;i<n-1;i++){
            pair p1=arr.get(i);
            pair p2=arr.get(i+1);
            if(Math.abs(p1.val-p2.val)<=limit){
                int par1=findParent(p1.index,parent);
                int par2=findParent(p2.index,parent);
                if(par1!=par2){
                    parent[par1]=par2;
                }
                
            }
        }
        
        for(int i=0;i<nums.length;i++){
            int p=findParent(i,parent);
            map.putIfAbsent(p,new PriorityQueue<>());
            map.get(p).add(nums[i]);
        }
        int[] ans=new int[n];
        
        for(int i=0;i<n;i++){
            ans[i]=map.get(findParent(i,parent)).poll();
        }
        return ans;
    }
}
