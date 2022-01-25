class Solution {
    private int findParent(int u,int[] parent){
        if(parent[u]==u){
            return u;
        }
       int x= findParent(parent[u],parent);
        parent[u]=x;
        return x;
    }
    public boolean gcdSort(int[] nums) {
        int n=nums.length;
        int max=-(int)1e9;
        for(int ele:nums){
            max=Math.max(max,ele);
        }
        int[] parent=new int[max+1];
        for(int i=0;i<parent.length;i++)parent[i]=i;
        int[] arr=new int[n];
        int index=0;
        for(int ele:nums){
            arr[index++]=ele;
            int p1=findParent(ele,parent);
            for(int i=2;i<=Math.sqrt(ele);i++){
                if(ele%i==0){
                    int p2=findParent(i,parent);
                    int p3=findParent(ele/i,parent);
                    parent[p2]=p1;
                    parent[p3]=p1;
                }
            }
        }
        
        Arrays.sort(arr);
       
            for(int i=0;i<n;i++){
            if(findParent(arr[i],parent)!=findParent(nums[i],parent)){
                return false;
            }
        }
        return true;
        
        
    }
}



